/**
 * 
 */
package com.test.classdesign;

/**
 * @author edinjos
 *
 */
public class Bird {
	public static boolean isStaticBiped(){
		return false;
	}
	
	public boolean isNonStaticBiped(){
		return false;
	}
	
	public void printStaticX(){
		System.out.println("printStaticX "+isStaticBiped());
	}
	
	public void printNonStaticX(){
		System.out.println("printNonStaticX "+isNonStaticBiped());
	}
}
