/**
 * 
 */
package com.test.exce;

/**
 * @author edinjos
 *
 */
public class CheckedE extends Exception {

	/**
	 * 
	 */
	public CheckedE() {
		System.out.println("CheckedE constructor");
	}

	/**
	 * @param paramString
	 */
	public CheckedE(String paramString) {
		super(paramString);
		System.out.println("CheckedE constructor "+paramString);
	}

	/**
	 * @param paramThrowable
	 */
	public CheckedE(Throwable paramThrowable) {
		super(paramThrowable);
		System.out.println("CheckedE constructor "+paramThrowable);
	}

	/**
	 * @param paramString
	 * @param paramThrowable
	 */
	public CheckedE(String paramString, Throwable paramThrowable) {
		super(paramString, paramThrowable);
		System.out.println("CheckedE constructor "+ paramString + " " + paramThrowable);
	}

	/**
	 * @param paramString
	 * @param paramThrowable
	 * @param paramBoolean1
	 * @param paramBoolean2
	 */
	public CheckedE(String paramString, Throwable paramThrowable,
			boolean paramBoolean1, boolean paramBoolean2) {
		super(paramString, paramThrowable, paramBoolean1, paramBoolean2);
		System.out.println("CheckedE constructor "+ paramString + " " + paramThrowable +" " +paramBoolean1 + " " + paramBoolean2);
	}

}
