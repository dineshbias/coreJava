/**
 * 
 */
package ocp.classDesign.nestedt;

/**
 * @author edinjos
 *
 */
public class TestLocalInner {

	public static void main(String[] args) {
		Out out = new Out();
		out.callInner();
		out.callInner();
		out.callInner();
		out.callInner();
	}

}

class Out {
	private String greetings = "Hi out";

	public Out() {
		System.out.println("Out Constructor");

	}

	public void callInner() {
		int repeat = 1;
		final class Inner {
			Inner() {
				System.out.println("Inner Constructor");
			}

			public void go() {
				Out out = new Out();
				
				for (int i = 0; i < repeat; i++) {
					System.out.println(greetings);
				}
			}
		}

		Inner in = new Inner();
		in.go();

	}
}