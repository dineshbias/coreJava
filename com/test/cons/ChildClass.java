/**
 * 
 */
package com.test.cons;

/**
 * @author edinjos
 *
 */
public class ChildClass extends SampleConstructor {
	
	int i=10;
	public ChildClass() {
		System.out.println("ChildClass Constructor");
		test();
	}
	
	public void test() {
		System.out.println("ChildClass test "+i);
		super.test();
	}
	
	static{
		System.out.println("Static block in ChildClass");
	}
	
	{
		System.out.println("Instance block in ChildClass");
	}
}
