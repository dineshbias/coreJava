/**
 * 
 */
package com.test.exce;

import com.test.meth.A;

/**
 * @author edinjos
 *
 */
public abstract class TestException {

	/**
	 * 
	 */
	public TestException() {
		System.out.println("TestException A");
	}

	/**
	 * @param args
	 * @throws UncheckedE
	 * @throws CheckedE
	 * @throws Exception
	 */
	public static void main(String[] args) throws Error, UncheckedE, Exception {
		Exception e = test();
		e.getStackTrace();
	}

	public static Exception test() throws Exception, UncheckedE {
		A a = new A();
		try {
			throw new CheckedE();
		} catch (CheckedE e) {
			System.out.println("Inside catch " + e);
			throw new UncheckedE();
		} catch (Exception e) {
			System.out.println("Inside catch " + e);
			throw new UncheckedE();
		}

		finally {
			System.out.println("Inside finally");
			try {
				return new Exception();

			} catch (Error e) {
				System.out.println("Inside catch " + e);
			}

		}

	}
}
