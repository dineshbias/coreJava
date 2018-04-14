/**
 * 
 */
package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author edinjos
 *
 */
public class Person {

	private String name;
	private int age;
	private float height;
	private List<String> address;
	
	public Person(String name, int age, float height) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
		this.height = height;
		address = new ArrayList<String>();
		address.add("Roorkee");
		address.add("Delhi");
		address.add("Haridwar");
	}
	
	/**
	 * 
	 */
	public Person() {
		// TODO Auto-generated constructor stub
	}

	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	public float getHeight(){
		return height;
	}
	
	public List<String> getAddress(){
		return address;
	}
}
