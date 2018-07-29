/**
 * 
 */
package ocp.io;

import java.io.Serializable;

/**
 * @author edinjos
 *
 */

public class A implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long time;
	private Example e;

	private transient B test;
	private transient String a;
	private transient int b = 10;
	private static char type = 'c';

	{
		this.b = 100;
	}

	public A() {
		this.a = "not known";
		this.b = 1000;
		this.type = 'Q';
		this.test = new B();
	}

	public A(String a, int b, char type) {
		this.a = a;
		this.b = b;
		this.type = type;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public void setE(Example e) {
		this.e = e;
	}

	public long getTime() {
		return time;
	}

	public Example getE() {
		return e;
	}

	@Override
	public String toString() {
		return "a:" + a + " b:" + b + " type:" + type + " time:" + time + " "
				+ (e == null ? null : e.toString() + " B:" + test);
	}
}

class B {
	B() {
		System.out.println("B Constructor");

	}

}