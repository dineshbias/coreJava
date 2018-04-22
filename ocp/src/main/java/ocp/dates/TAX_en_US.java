/**
 * 
 */
package dates;

import java.util.ListResourceBundle;

/**
 * @author edinjos
 *
 */
public class TAX_en_US extends ListResourceBundle {

	/**
	 * 
	 */
	public TAX_en_US() {
		System.out.println("TAX_en_US constructor");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.ListResourceBundle#getContents()
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] { { "first_en_US", "1" },{ "second_en_US", "2" }
				};
	}

}


