/**
 * 
 */
package ocp.memory;

/**
 * @author dinesh.joshi
 *
 */
public class Test {

	String s;

	/**
	 * 
	 */
	public Test(String s) {
		this.s = s;
	}

	public void test() {
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " test...");

		try {
			testBadRecursive();
		} catch (Error e) {
			System.out.println(e);
		}

		// testBadLoop();
	}

	private void testBadRecursive() {
		testBadRecursive();
	}

	private void testBadLoop() {
		try {

			Sample s = new Sample();

		} finally {
			System.out.println("testBadLoop..");
		}
	}
}
