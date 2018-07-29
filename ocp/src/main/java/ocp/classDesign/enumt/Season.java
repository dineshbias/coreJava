/**
 * 
 */
package ocp.classDesign.enumt;

/**
 * @author edinjos
 *
 */
public enum Season {
	WINTER("LOW") {
		@Override
		public void printhours() {
			Season.SPRING.printhours();

		}

		@Override
		public void testFUN() {
			System.out.println("WINTER Inside enum value function");
		}
	},
	SPRING("MEDIUM") {
		@Override
		public void printhours() {
			System.out.println("SPRING printhours");

		}
	},
	SUMMER("HIGH") {
		@Override
		public void printhours() {
			// TODO Auto-generated method stub

		}
	},
	FALL("MEDIUM") {
		@Override
		public void printhours() {
			// TODO Auto-generated method stub

		}
	};
	private static int i;
	private String intensity;

	Season(String s) {
		System.out.println("Parameterized Constructor " + s);
		intensity = s;
	}

	public abstract void printhours();

	public void testFUN() {
		System.out.println("Inside enum function");
	}

	public static void main(String... varArgs) {
		System.out.println("Running main ");
		for (Season s : Season.values()) {
			System.out.println(s.ordinal() + " " + s.name());
		}

		Season summer = Season.SUMMER;

		System.out.println(summer + " " + summer.intensity + " " + summer.name());

		switch (summer) {
		case WINTER:
			System.out.println("It is winter");
			break;
		case SPRING:
			System.out.println("It is spring");
			break;
		case SUMMER:
			System.out.println("It is summer");
			break;
		case FALL:
			System.out.println("It is fall");
			break;
		}

		Season.WINTER.testFUN();
		Season.SPRING.testFUN();
		Season.SPRING.printhours();
		RuntimeException r;
	}

}
