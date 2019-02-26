/**
 * 
 */
package com.test.cons;

/**
 * @author edinjos
 *
 */
public class TestConstructor {

	
	public TestConstructor() {
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ChildClass c = new ChildClass();
		SampleConstructor s = (SampleConstructor)c; 
		c.test();
		
		
	}

}
