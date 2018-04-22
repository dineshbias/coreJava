/**
 * 
 */
package com.test;

/**
 * @author edinjos
 *
 */
public class TestAccess {
	
	String name = "parrot";
	
	/**
	 * 
	 */
	public TestAccess() {
		System.out.println("TestAccess Constructor run");
	}
	
	void floatInWater(){
		System.out.println("floatInWater : "+name);
	}
}
