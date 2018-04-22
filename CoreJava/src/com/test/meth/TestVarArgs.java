/**
 * 
 */
package com.test.meth;

/**
 * @author edinjos
 *
 */
public class TestVarArgs {

	/**
	 * 
	 */
	public TestVarArgs() {
		System.out.println("TestVarArgs Constructor");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		B b = new B();
	}

	public static void printStrings(String... strings) {
		for (String s : strings) {
			System.out.println(s);
		}
	}

	public static void print(short i) {

		System.out.println("short " + i);

	}

	public static void print(Integer i) {

		System.out.println("Integer " + i);

	}

	public static void print(int... i) {

		System.out.println("int... " + i[0]);

	}
	
	}

