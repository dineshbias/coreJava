/**
 * 
 */
package com.test.exce;

/**
 * @author edinjos
 *
 */
public class UncheckedE extends RuntimeException {

	/**
	 * 
	 */
	public UncheckedE() {
		System.out.println("UncheckedE constructor");
	}

	/**
	 * @param paramString
	 */
	public UncheckedE(String paramString) {
		super(paramString);
		System.out.println("UncheckedE constructor "+paramString);
	}

	/**
	 * @param paramThrowable
	 */
	public UncheckedE(Throwable paramThrowable) {
		super(paramThrowable);
		System.out.println("UncheckedE constructor "+paramThrowable);
	}

	/**
	 * @param paramString
	 * @param paramThrowable
	 */
	public UncheckedE(String paramString, Throwable paramThrowable) {
		super(paramString, paramThrowable);
		System.out.println("UncheckedE constructor "+ paramString + " " + paramThrowable);
	}

	/**
	 * @param paramString
	 * @param paramThrowable
	 * @param paramBoolean1
	 * @param paramBoolean2
	 */
	public UncheckedE(String paramString, Throwable paramThrowable,
			boolean paramBoolean1, boolean paramBoolean2) {
		super(paramString, paramThrowable, paramBoolean1, paramBoolean2);
		System.out.println("UncheckedE constructor "+ paramString + " " + paramThrowable +" " +paramBoolean1 + " " + paramBoolean2);
	}

}
