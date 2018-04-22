/**
 * 
 */
package ocp.design;

import java.util.ArrayList;

import ocp.design.immutable.Animal;
import ocp.design.immutable.Test;

/**
 * @author edinjos
 *
 */
public class TestImmutable {

	/**
	 * 
	 */
	public TestImmutable() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<String> food = new ArrayList<String>();
		food.add("meat");

		Test t = new Test(4);
		Animal a1 = new Animal("Lion",2,  food);
		System.out.println(a1.toString());
		food.add("fish");
		System.out.println(a1.toString());
		System.out.println(" main " + " " + food);

		ArrayList<String> food2 = new ArrayList<String>();
		for (int i = 0; i < a1.getFavoriteFoodsCount(); i++) {
			food2.add(a1.getFavoriteFood(i));
		}
		food2.add("fish");
	
		System.out.println(a1.toString());
	}

}
