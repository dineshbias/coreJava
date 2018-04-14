/**
 * 
 */
package com.test.abs;

/**
 * @author edinjos
 *
 */
public abstract class AbsBaseClass {
	private static int i = 1;

	public AbsBaseClass() {
		super();
		System.out.println("AbsBaseClass constructor");
	}

	static {
		System.out.println("AbsBaseClass static " + i);
	}

	abstract void test();
	
	public static void a() {
		
	}

}

class XYZ extends AbsBaseClass {

	public XYZ() {
		System.out.println("XYZ constructor");
	}

	private static int i = 100;
	static {
		System.out.println("XYZ static " + i);
	}

	void test() {
		System.out.println("XYZ test");
		ABC a = new ABC();
		a.test();
	}

}

class ABC {
	static {
		System.out.println("ABC static ");
	}

	public ABC() {
		super();
		System.out.println("ABC constructor");
	}
	private class PQR {
		
		public PQR() {
			System.out.println("PQR constructor");
		}
		
		public void test() {
			System.out.println("PQR " );
		}
	}

	void test() {
		System.out.println("ABC test" );
		PQR test = new PQR();
		test.test();
	}
}