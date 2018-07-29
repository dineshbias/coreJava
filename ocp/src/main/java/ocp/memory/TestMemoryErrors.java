/**
 * 
 */
package ocp.memory;

/**
 * @author dinesh.joshi
 *
 */
public class TestMemoryErrors {

	/**
	 * 
	 */
	public static void main(String... strings) {
		System.out.println("Testing Error");
		testBadRecursive();
	}

	private static void testBadRecursive() {
		testBadRecursive();
	}
}
