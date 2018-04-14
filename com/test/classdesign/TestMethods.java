/**
 * 
 */
package com.test.classdesign;


/**
 * @author edinjos
 *
 */
public class TestMethods {

	/**
	 * 
	 */
	public TestMethods() {
		System.out.println("Constructor TestMethods");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		com.test.basic.baseClass tb;
		Bird b = new Eagle();
		Eagle e = (Eagle) b;

		String[] animals = new String[0];
		System.out.println(animals.length);

		b.printNonStaticX(); // printNonStaticX true
		b.printStaticX(); // printStaticX false
		System.out.println();
		e.printNonStaticX();// printNonStaticX true
		e.printStaticX();// printStaticX false
		e.printNonStaticY();// printNonStaticY true
		e.printStaticY();// printStaticY true
		try {
			setNumberEggs(-7);
			

		} catch (Exception e3) {
			System.out.println("Exception catch");
		} catch (Error e2) {
			System.out.println("Error catch");
		} finally {

			System.out.println("finally");
		}

	}

	

	public static void setNumberEggs(int count) {
		throw new Error();
	}

}



