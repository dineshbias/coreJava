/**
 * 
 */
package ocp.design.adaptor;

/**
 * @author dinesh.joshi
 *
 */
public class WildTurkey implements Turkey {

	/**
	 * 
	 */
	public WildTurkey() {
		System.out.println("Turkey Created");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ocp.design.adaptor.Turkey#fly()
	 */
	@Override
	public void fly() {
		System.out.println("Turkey fly");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ocp.design.adaptor.Turkey#gobble()
	 */
	@Override
	public void gobble() {
		System.out.println("Turkey gobble");

	}

}
