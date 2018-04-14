/**
 * 
 */
package com.test.meth;

/**
 * @author edinjos
 *
 */
public class B extends A {

	
	public B() {
		System.out.println("Constructo B");
	}
	
	static {
		System.out.println("static Block B");
		b=10;
		
	}
	
	{
		System.out.println("Instance Block B");
		a=1;
	}
	
	private final int a;
	final private static int b;
}
