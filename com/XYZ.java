/**
 * 
 */
package com;

import com.test.GooseWatcher;

/**
 * @author edinjos
 *
 */
public class XYZ extends GooseWatcher {

	
	
	
	/**
	 * 
	 */
	public XYZ() {
		System.out.println("GooseWatcher Constructor run");
	}

	public void test() {
		floatInWater();
		System.out.println(name);
	}

	public void helpOthers() {
		XYZ g = new XYZ();
		g.floatInWater();
		System.out.println(g.name);
	}

}
