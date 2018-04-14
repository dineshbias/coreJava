/**
 * 
 */
package com.test.meth;

/**
 * @author edinjos
 *
 */
public class A {
	
	private final int i;
	
	public A() {
		
		System.out.println("Constructo A");
	}
	
	static {
		System.out.println("static Block A");
		z=10;
	}
	
	{
		System.out.println("Instance Block A");
		i=1;
	}
	
	final public static int z;
}
