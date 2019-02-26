/**
 * 
 */
package com.test.inte;

/**
 * @author edinjos
 *
 */
public interface OtherInterface {
	public int constant = 1;
	abstract public int print();
	default public void Abc() {
		System.out.println("OtherInterface Abc");
	}
	
}
