/**
 * 
 */
package ocp.classDesign;

import ocp.classDesign.Person.Gender;

/**
 * @author edinjos
 *
 */
public class TestEqualsHashCode {

	/**
	 * 
	 */
	public TestEqualsHashCode() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Employee e = new Employee();
		e.setAge(30);
		e.setEmployeeId("000001");
		e.setGender(Gender.MALE);
		e.setName("Dinesh");
		e.setSalary(100000);
		System.out.println(e);
		
		Employee e2 = new Employee();
		e2.setAge(32);
		e2.setEmployeeId("000001");
		e2.setGender(Gender.MALE);
		e2.setName("Dinesh");
		e2.setSalary(1000);
		System.out.println(e2);
		System.out.println(e.hashCode());
		System.out.println(e2.hashCode());
		System.out.println("Employess are same :" + e.equals(e2));
	}

}
