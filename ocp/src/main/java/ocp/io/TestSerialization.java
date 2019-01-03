/**
 * 
 */
package ocp.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dinesh.joshi
 *
 */
public class TestSerialization {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		test1();
		test2();
		try {
			testDeepCloningUsingSeraialization();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testDeepCloningUsingSeraialization()
			throws FileNotFoundException, IOException, ClassNotFoundException {
		City city = new City("Dehradun");

		Person person1 = new Person("Naresh", 10000, city);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.obj"));
		oos.writeObject(person1);
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.obj"));
		Person person2 = (Person) ois.readObject();
		// Shallow Copying Issue.
		city.setName("Pune");
		System.out.println(person1);

		System.out.println(person2);

		if (person1 == person2) {

			System.out.println("Both person1 and person2 holds same object");

		}

		if (person1.equals(person2)) {

			System.out.println("But both person1 and person2 are equal and have same content");

		}

		if (person1.getCity() == person2.getCity()) {

			System.out.println("Both person1 and person2 have same city object");

		}
	}

	private static void test2() throws CloneNotSupportedException {
		City city = new City("Dehradun");

		Person person1 = new Person("Naresh", 10000, city);
		Person person2 = person1.clone();
		// Shallow Copying Issue.
		city.setName("Pune");
		System.out.println(person1);

		System.out.println(person2);

		if (person1 == person2) {

			System.out.println("Both person1 and person2 holds same object");

		}

		if (person1.equals(person2)) {

			System.out.println("But both person1 and person2 are equal and have same content");

		}

		if (person1.getCity() == person2.getCity()) {

			System.out.println("Both person1 and person2 have same city object");

		}
	}

	private static void test1() {
		D d1 = new D();
		d1.setExperience(13);
		D d2 = new D();
		d2.setExperience(45);

		List<D> l = new ArrayList<>();
		l.add(d1);
		l.add(d2);
		C c = new C();
		c.setAge(35);
		c.setL(l);

		Z z = new Z();
		z.setDepartment("development");
		z.setC(c);

		City city = new City("Dehradun");
		Y y = new Y();
		y.setName("Dinesh Joshi");
		y.setCity(city);
		y.setZ(z);

		System.out.println(y);
		Y yClone = y.cloneSample();
		System.out.println(yClone);
	}

}

class X {
	private int I;
	private Object obj;

	public X(int i, Object obj) {
		super();
		I = i;
		this.obj = obj;
	}

	public int getI() {
		return I;
	}

	public void setI(int i) {
		I = i;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "X [I=" + I + ", obj=" + obj + "]";
	}

}

class Y extends X implements Cloneable {
	@Override
	public String toString() {
		return "Y [" + super.toString() + "name=" + name + ", z=" + z + " city" + city + "]";
	}

	private String name;
	private Z z;

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	private int income;

	private City city;

	public Y() {
		super(1000, "Dummy");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Z getZ() {
		return z;
	}

	public void setZ(Z z) {
		this.z = z;
	}

	protected Y cloneSample() {
		try {
			return (Y) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}

class Z {
	@Override
	public String toString() {
		return "Z [department=" + department + ", c=" + c + "]";
	}

	private String department;
	private C c;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public C getC() {
		return c;
	}

	public void setC(C c) {
		this.c = c;
	}
}

class C {

	@Override
	public String toString() {
		return "C [age=" + age + ", l=" + l + "]";
	}

	private int age;
	private List<D> l;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<D> getL() {
		return l;
	}

	public void setL(List<D> l) {
		this.l = l;
	}

}

class D {
	@Override
	public String toString() {
		return "D [experience=" + experience + "]";
	}

	private int experience;

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

}

class City implements Cloneable, Serializable {

	private String name;

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public City(String name) {

		super();

		this.name = name;

	}

	@Override
	public City clone() throws CloneNotSupportedException {

		return (City) super.clone();

	}

	@Override

	public String toString() {

		return "City [name=" + name + "]";

	}

	@Override

	public int hashCode() {

		final int prime = 31;

		int result = 1;

		result = prime * result + ((name == null) ? 0 : name.hashCode());

		return result;

	}

	@Override

	public boolean equals(Object obj) {

		if (this == obj)

			return true;

		if (obj == null)

			return false;

		if (getClass() != obj.getClass())

			return false;

		City other = (City) obj;

		if (name == null) {

			if (other.name != null)

				return false;

		} else if (!name.equals(other.name))

			return false;

		return true;

	}

}

class Person implements Cloneable, Serializable {

	private String name;

	private int income;

	private City city;

	public String getName() {

		return name;

	}

	public void setName(String firstName) {

		this.name = firstName;

	}

	public int getIncome() {

		return income;

	}

	public void setIncome(int income) {

		this.income = income;

	}

	public City getCity() {

		return city;

	}

	public void setCity(City city) {

		this.city = city;

	}

	public Person(String firstName, int income, City city) {

		super();

		this.name = firstName;

		this.income = income;

		this.city = city;

	}

	@Override

	public Person clone() throws CloneNotSupportedException {

		Person p = (Person) super.clone();
		// Enable next 2 lines for deep copy
		City c = this.city.clone();
		p.setCity(c);

		return p;
	}

	@Override

	public String toString() {

		return "Person [name=" + name + ", income=" + income + ", city=" + city + "]";

	}

	@Override

	public int hashCode() {

		final int prime = 31;

		int result = 1;

		result = prime * result + ((city == null) ? 0 : city.hashCode());

		result = prime * result + income;

		result = prime * result + ((name == null) ? 0 : name.hashCode());

		return result;

	}

	@Override

	public boolean equals(Object obj) {

		if (this == obj)

			return true;

		if (obj == null)

			return false;

		if (getClass() != obj.getClass())

			return false;

		Person other = (Person) obj;

		if (city == null) {

			if (other.city != null)

				return false;

		} else if (!city.equals(other.city))

			return false;

		if (income != other.income)

			return false;

		if (name == null) {

			if (other.name != null)

				return false;

		} else if (!name.equals(other.name))

			return false;

		return true;

	}

}