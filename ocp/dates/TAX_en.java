/**
 * 
 */
package ocp.dates;

import java.util.ListResourceBundle;

/**
 * @author edinjos
 *
 */
public class TAX_en extends ListResourceBundle {

	/**
	 * 
	 */
	public TAX_en() {
		System.out.println("TAX_en constructor");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.ListResourceBundle#getContents()
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] { { "first_en", "1" },{ "second_en", "2" }
				};
	}

}