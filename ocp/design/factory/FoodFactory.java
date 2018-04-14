/**
 * 
 */
package ocp.design.factory;

/**
 * @author edinjos
 *
 */
public final class FoodFactory {

	public static Food getFood(String animalName) {
		switch (animalName) {
		case "zebra":
			return new Hay(100);
		case "polar bear":
			return new Fish(10);
		}
		throw new UnsupportedOperationException();
	}

}
