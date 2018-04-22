/**
 *
 */
package test;

import com.Cache;

/**
 * @author edinjos
 *
 */
public class TestMain {

	public static int i;
	public int x;
	/**
	 *
	 */
	public TestMain() {
		// TODO Auto-generated constructor stub
		int i2 = i;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i2 = i;
		Cache c = new Cache();
		System.out.println(c.getData());
		System.out.println("i : " + this.x );
	}

	public int abc()
	{
		int i2 = i;
		return i2;
	}
}
