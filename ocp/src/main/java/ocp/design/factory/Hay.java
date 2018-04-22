/**
 * 
 */
package ocp.design.factory;

/**
 * @author edinjos
 *
 */
public class Hay extends Food {

	/**
	 * @param quantity
	 */
	Hay(int quantity) {
		super(quantity);
	}

	/* (non-Javadoc)
	 * @see ocp.design.factory.Food#consumed()
	 */
	@Override
	public void consumed() {
		System.out.println("Hay eaten "+ getQuantity());
	}

}
