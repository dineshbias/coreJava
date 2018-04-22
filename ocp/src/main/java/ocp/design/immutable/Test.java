/**
 * 
 */
package ocp.design.immutable;

/**
 * @author edinjos
 *
 */
final public class Test {
	
	private final int legs;
	/**
	 * 
	 */
	public Test(int legs) {
		this.legs = legs;
	}
	
	public int getLegs(){
		return this.legs;
	}

}
