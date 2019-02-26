/**
 * 
 */
package com.test.inte;

/**
 * @author edinjos
 *
 */
public class TestInterfaces {

	/**
	 * 
	 */
	public TestInterfaces() {
		System.out.println("TestInterfaces Constructor");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		XYZ obj = new XYZ();
		obj.print();
		BaseInterface.test();
	}

}

class XYZ implements BaseInterface,OtherInterface {
	
	public XYZ() {
		System.out.println("XYZ Constructor");
	}
	
	public void Abc() {
		System.out.println("OtherInterface Abc");
	}
	
	public int print() {
		System.out.println("XYZ.print");
		return 0;
	}
	
}

interface A extends BaseInterface,OtherInterface {
	default public void Abc() {
		System.out.println("OtherInterface Abc");
	}	
}


class P {
	protected Object dispaly() throws Exception{
		return 2;
	}
}

class Q extends P {
	public Integer dispaly() throws RuntimeException {
		return 9;
	}



}