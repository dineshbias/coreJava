/**
 * 
 */
package ocp.classDesign.nestedt;

/**
 * @author edinjos
 *
 */
public class TestMemberInner {

	/**
	 * 
	 */
	public TestMemberInner() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Outer out = new Outer();
		out.callInner();
		ocp.classDesign.nestedt.Outer.Inner obj = out.new Inner();
		out.new Inner().new X();
	}

}

class Outer {

	private String greetings = "Hi outer";

	public Outer() {
		System.out.println("Outer Constructor");
	}

	public class Inner {
		private String greetings = Outer.this.greetings;

		Outer out;

		Inner() {
			System.out.println("Inner Constructor " + greetings);
			out = new Outer();

		}

		private int repeat = 3;

		public void go() {
			for (int i = 0; i < repeat; i++) {
				System.out.println(greetings);
			}
		}

		class X {
			public X() {
				System.out.println("X Constructor");
			}

			private int repeat = 4;
		}
	}

	public void callInner() {
		Inner in = new Inner();
		System.out.print("****");
		greetings = "Hi outer2";
		in.go();

	}
}

class Enclosing {
	private int counter;

	Enclosing() {
		System.out.println("Enclosing Constructor");
	}

	public static class Nested {
		public int price = 6;

		Nested() {
			System.out.println("Nested Constructor");
		}

		public static void test() {
			System.out.println("test counter of enclosing: " + new Enclosing().counter);
		}
	}
}