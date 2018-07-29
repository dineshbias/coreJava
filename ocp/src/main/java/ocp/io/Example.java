/**
 * 
 */
package ocp.io;

import java.io.Serializable;

/**
 * @author edinjos
 *
 */
public class Example implements Serializable {

	private static final long serialVersionUID = 1L;

	public static String tConsatnt = "Hello";

	private int id;
	private String name;
	private float sal;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getSalary() {
		return sal;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(float sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "id:" + getId() + " " + "name:" + getName() + " " + "sal:" + getSalary() + " tConsatnt:" + tConsatnt;
	}
}
