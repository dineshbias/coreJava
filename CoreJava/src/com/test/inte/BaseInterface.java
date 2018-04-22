/**
 * 
 */
package com.test.inte;

/**
 * @author edinjos
 *
 */
public abstract interface BaseInterface {
	int constant = 1;
	
	static public void test() {
		System.out.println("BaseInterface test");
	}
	
	default public void Abc() {
		System.out.println("BaseInterface test");
	}
}
