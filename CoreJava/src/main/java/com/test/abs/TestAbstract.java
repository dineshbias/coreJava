/**
 * 
 */
package com.test.abs;

/**
 * @author edinjos
 *
 */
public abstract class TestAbstract {

	/**
	 * 
	 */
	public TestAbstract() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("TestAbstract main");
		AbsBaseClass a = new XYZ();
		a.test();
	}

}
