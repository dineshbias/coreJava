/**
 *
 */
package test;

/**
 * @author edinjos
 *
 */
public class TestRun {

	/**
	 *
	 */
	public TestRun() {
		// TODO Auto-generated constructor stub
		System.out.println("TestRun constructor");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Testing Main");
		Subscriber sub = new Subscriber();
		sub.setName("Dinesh");
		System.out.println(sub.getName());
	}

}
