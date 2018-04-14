/**
 * 
 */
package com.test.pond.shore;

/**
 * @author edinjos
 *
 */
public class Bird {

	protected String name = "parrot";
	/**
	 * 
	 */
	public Bird() {
		System.out.println("Bird Constructor run");
	}
	
	protected void floatInWater(){
		System.out.println("floatInWater : "+name);
	}
}
