/**
 * 
 */
package com.test.cons;

/**
 * @author edinjos
 *
 */
public class SampleConstructor extends Object {

	int i = 100;
	
	static{
		System.out.println("Static block in SampleConstructor");
	}
	
	{
		System.out.println("Instance block in SampleConstructor");
	}
	public SampleConstructor() {
		System.out.println("SampleConstructor Constructor");
		test();

	}

	public void SampleConstructor() {
		System.out.println("SampleConstructor Method");
	}

	public void test() {
		System.out.println("SampleConstructor test " + i);
	}
}
