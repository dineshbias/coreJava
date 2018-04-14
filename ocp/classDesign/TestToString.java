/**
 * 
 */
package ocp.classDesign;

/**
 * @author edinjos
 *
 */
public class TestToString {

	/**
	 * 
	 */
	public TestToString() {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ABC abc1 = new ABC();
		ABC abc2 = new ABC();
		System.out.print(abc1 + " " + abc2);
		System.out.println(abc1 == abc2);
		System.out.println(abc1.equals(abc2));
		System.out.println(new ABC());
		System.out.println( "(new ABC().toString()) == new ABC().toString()" + (new ABC().toString()) == new ABC().toString());
		System.out.println("(new ABC().toString()).equals(new ABC().toString())"+(new ABC().toString()).equals(new ABC().toString()));

		String fruit = "Banana";
		String building = "Bank";
		
		
		
		System.out.println(" " + "Ba".equals(fruit.substring(0, 2)));
		System.out.println(" " + "Ba" == fruit.substring(0, 2));
		System.out.println(" "
				+ building.substring(0, 2).equals(fruit.substring(0, 2)));
		System.out.println(" " + building.substring(0, 2) == fruit.substring(0,
				2));
		System.out
				.println(" " + fruit.substring(0, 2) == fruit.substring(0, 2));
		System.out.println(" " + building.substring(0, 2) == building
				.substring(0, 2));
	}

}

class ABC extends Object {

	@Override
	public String toString() {
		System.out.println("  ******* ");
		return "1";
	}
}