/**
 * 
 */
package ocp.dates;

import java.util.ListResourceBundle;

/**
 * @author edinjos
 *
 */
public class TAX_hi extends ListResourceBundle {

	/**
	 * 
	 */
	public TAX_hi() {
		System.out.println("TAX_hi constructor");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.ListResourceBundle#getContents()
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] { { "firstTAX_hi", "1" },{ "secondTAX_hi", "2" }
				};
	}

}


