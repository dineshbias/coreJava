/**
 * 
 */
package com.test.classdesign;

/**
 * @author edinjos
 *
 */
public class Animal extends Object{

	/**
	 * 
	 */
	public Animal(int age) {
		super();
		System.out.println("Constructor Animal");
		this.age=age;
		
	}
	
	public Animal(String age) {
		
		System.out.println("String Constructor Animal");
		
		
	}
	private int age;
	public int publicTemp;
	int defaultTemp;
	
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age=age;
	}
	
	protected int protNumberOfLegs;
	public int getprotNumberOfLegs(){
		return protNumberOfLegs;
	}
	public void setprotNumberOfLegs(int protNumberOfLegs){
		this.protNumberOfLegs=protNumberOfLegs;
	}
	
	public void roar(){
		System.out.println("The "+ getAge()+ " Legs : " );
	}
}
