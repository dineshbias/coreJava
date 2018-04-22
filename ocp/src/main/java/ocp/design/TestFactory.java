/**
 * 
 */
package ocp.design;

import ocp.design.factory.Food;
import ocp.design.factory.FoodFactory;

/**
 * @author edinjos
 *
 */
public class TestFactory {

	/**
	 * 
	 */
	public TestFactory() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Food food = FoodFactory.getFood("polar bear");
		food.consumed();
		food = FoodFactory.getFood("zebra");
		food.consumed();
	}

}
