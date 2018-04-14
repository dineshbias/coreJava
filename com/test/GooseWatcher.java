/**
 * 
 */
package com.test;

import com.test.TestAccess;
import com.test.pond.shore.Bird;

/**
 * @author edinjos
 *
 */
public class GooseWatcher extends Bird {

	/**
	 * 
	 */
	public GooseWatcher() {
		System.out.println("GooseWatcher Constructor run");
	}

	public void test() {
		floatInWater();
		System.out.println(name);
	}

	public void helpOthers() {
		GooseWatcher g = new GooseWatcher();
		g.floatInWater();
		System.out.println(g.name);
		
		GooseWatcher g1 = new GooseWatcher();
		g1.floatInWater();
		System.out.println(g1.name);
		
		TestAccess ta = new TestAccess();
		System.out.println(ta.name);
		ta.floatInWater();
	}

}
