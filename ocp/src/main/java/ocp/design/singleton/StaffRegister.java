/**
 * 
 */
package ocp.design.singleton;

/**
 * @author edinjos
 *
 */
public class StaffRegister {

	private volatile static StaffRegister instance;
	
	
	/**
	 * 
	 */
	private StaffRegister() {
		System.out.println("StaffRegister constructed");
	}

	public static StaffRegister getInstance() {
		if (null == instance) {
			synchronized (StaffRegister.class) {
				if (null == instance) {
					instance = new StaffRegister();
				}
			}
		}
		return instance;
	}
}

