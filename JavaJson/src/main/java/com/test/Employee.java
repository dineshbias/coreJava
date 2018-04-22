/**
 * 
 */
package com.test;

import java.util.Date;

/**
 * @author edinjos
 *
 */
public class Employee extends Person {

	public Date doj;
	public double s;
	
	/**
	 * @param name
	 * @param age
	 * @param height
	 */
	public Employee(String name, int age, float height, Date doj,double salary) {
		super(name, age, height);
		this.doj = doj;
		this.s = salary;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public Employee() {
		// TODO Auto-generated constructor stub
	}

}
