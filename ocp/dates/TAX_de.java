/**
 * 
 */
package ocp.dates;

import java.util.ListResourceBundle;

/**
 * @author edinjos
 *
 */
public class TAX_de extends ListResourceBundle {

	/**
	 * 
	 */
	public TAX_de() {
		System.out.println("TAX_de constructor");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.ListResourceBundle#getContents()
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] { { "first_de", "1" }, { "second_de", "2" }
				};
	}

}


