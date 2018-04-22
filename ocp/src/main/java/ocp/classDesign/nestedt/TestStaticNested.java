/**
 * 
 */
package ocp.classDesign.nestedt;

import ocp.classDesign.nestedt.Enclosing.Nested;

/**
 * @author edinjos
 *
 */
public class TestStaticNested {

	public static void main(String[] args) {
		Nested n = new Nested();
		System.out.println("static class price:"+ n.price);
		Nested.test();

	}

}
