/**
 * 
 */
package com.test.classdesign;

/**
 * @author edinjos
 *
 */
public class Eagle extends Bird {
	public static boolean isStaticBiped(){
		return true;
	}
	
	public boolean isNonStaticBiped(){
		return true;
	}
	
	public void printStaticY(){
		System.out.println("printStaticY "+isStaticBiped());
	}
	
	public void printNonStaticY(){
		System.out.println("printNonStaticY "+isNonStaticBiped());
	}
}
