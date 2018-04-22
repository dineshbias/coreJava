/**
 * 
 */
package com.test.meth;

/**
 * @author edinjos
 *
 */
public class TestMethodOverride extends Object{

	/**
	 * 
	 */
	public TestMethodOverride() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		P p = new Q();
		p.print();
		p.test();
		System.out.println(p.i);
		System.out.println(p);
		System.out.println(Integer.toHexString(p.hashCode()));
	}

}

class P {
	int i=0;
	public static void print() {
		System.out.println("print:P ");
	}

	public void test() {
		System.out.println("test:P "+ i);
	}
}

class Q extends P {
	int i=100;
	public static void print() {
		System.out.println("print:Q");
	}

	public void test() {
		System.out.println("test:Q "+ i);
	}
}