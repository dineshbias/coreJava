/**
 * 
 */
package ocp.dates;

import java.util.ListResourceBundle;

/**
 * @author edinjos
 *
 */
public class TAX extends ListResourceBundle {

	/**
	 * 
	 */
	public TAX() {
		System.out.println("TAX constructor");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.ListResourceBundle#getContents()
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] { { "firstTAX", "1" },{"SecondTAX", "2"}
				};
	}

}


