/**
 * 
 */
package employee;

import rope.Rope;
import static rope.Rope.*;
import static java.util.Collections.sort;

/**
 * @author edinjos
 *
 */
public class RopeSwing {

	private static Rope rope1 = new Rope();
	private static Rope rope2 = new Rope();
	
	{
		System.out.println(rope1.lenth);
	}

	public static void main(String[] args) {
		rope1.lenth = 2;
		rope2.lenth = 8;
		System.out.println(rope1.lenth);
	}

}
