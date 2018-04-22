/**
 * 
 */
package ocp.design.factory;

/**
 * @author edinjos
 *
 */
public class Fish extends Food {

	/**
	 * @param quantity
	 */
	Fish(int quantity) {
		super(quantity);
	}

	/* (non-Javadoc)
	 * @see ocp.design.factory.Food#consumed()
	 */
	@Override
	public void consumed() {
		System.out.println("Fish eaten "+ getQuantity());
	}

}
