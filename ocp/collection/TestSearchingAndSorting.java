/**
 * 
 */
package ocp.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author edinjos
 *
 */
public class TestSearchingAndSorting {

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee("Dinesh", 32, 163, 65, "CSI",
				"Senior Solution Integrator", 75000, 3433443));
		empList.add(new Employee("Mahesh", 32, 163, 65, "CSI",
				"Senior Solution Integrator", 67000, 111111));
		empList.add(new Employee("Ramesh", 32, 163, 65, "CSI",
				"Senior Solution Integrator", 70000, 3433443));
		empList.add(null);
		System.out.println("List created");

		for (Employee e : empList)
			System.out.println(e);
		
		
		System.out.println("BinarySearch s :"
				+ Collections.binarySearch(empList, new Employee("Mahesh", 32,
						163, 65, "CSI", "Senior Solution Integrator", 67000,
						43534534)));
		System.out.println("sorting List");
		try{
		Collections.sort(empList);
		}catch(Exception e){
			System.out.println(e);
		}
		for (Employee e : empList)
			System.out.println(e);

		Comparator<Employee> salaryComparator = (e1, e2) -> new Float(
				String.valueOf(e1.getSalary() - e2.getSalary())).intValue();
		System.out.println("sorting List according to salary");
		Collections.sort(empList, salaryComparator);
		for (Employee e : empList)
			System.out.println(e);

	}
}

class Person {
	private String name;
	private int age;
	private int height;
	private float weight;

	Person(String name, int age, int height, float weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getHeight() {
		return height;
	}

	public float getWeight() {
		return weight;
	}

	public int hashCode() {
		System.out.println("Inside hashcode");
		return name.hashCode() + 31 * age + 31 * height;
	}

	@Override
	public boolean equals(Object paramObject) {
		System.out.println("Inside equals");
		if (null == paramObject || !(paramObject.getClass() == getClass()))
			return false;
		if (this == paramObject)
			return true;
		Person other = (Person) paramObject;
		if (name.equals(other.name) && age == other.age
				&& height == other.height && weight == other.weight)
			return true;
		return false;
	}

	@Override
	public String toString() {

		return name;
	}
}

class Employee extends Person implements Comparable<Employee> {
	private int employeeId;
	private String department;
	private String designation;
	private float salary;

	Employee(String name, int age, int height, float weight, String department,
			String designation, float salary, int employeeId) {
		super(name, age, height, weight);
		this.department = department;
		this.designation = designation;
		this.salary = salary;
		this.employeeId = employeeId;
	}

	public float getSalary() {
		return salary;
	}

	public String getDesignation() {
		return designation;
	}

	@Override
	public int compareTo(Employee arg0) {
		System.out.println("Inside CompareTo");
		if (this.equals(arg0))
			return 0;
		return this.employeeId - arg0.employeeId;
	}

	@Override
	public String toString() {

		return super.toString() + " " + employeeId + " " + department + " "
				+ designation + " " + salary;
	}
}