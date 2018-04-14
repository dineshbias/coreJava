/**
 * 
 */
package ocp.classDesign;

/**
 * @author edinjos
 *
 */
public class Employee extends Person {

	private Gender gender;
	private String name;
	private int age;
	private float salary;
	private String employeeId;

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Gender getGender() {
		return gender;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public float getSalary() {
		return salary;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	@Override
	public String toString() {
		return "gender:" + gender + " name:" + name + " age:" + age
				+ " salary:" + salary + " employeeId:" + employeeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
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
		Employee other = (Employee) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (gender != other.gender)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	/*
	@Override
	public boolean equals(Object paramObject) {

		if (null == paramObject || !(paramObject instanceof Employee))
			return false;
		if (this == paramObject)
			return true;
		Employee e = (Employee) paramObject;
		if (e.getGender().name().hashCode() == this.getGender().name()
				.hashCode()
				&& e.getAge() == this.getAge()
				&& e.getName().hashCode() == this.getName().hashCode()) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return getGender().name().hashCode() + getAge() * 7 + getGender().name().hashCode();
	}
	*/
}
