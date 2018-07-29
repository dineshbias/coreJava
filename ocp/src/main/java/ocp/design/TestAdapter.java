/**
 * 
 */
package ocp.design;

import ocp.design.adaptor.Duck;
import ocp.design.adaptor.MallardDuck;
import ocp.design.adaptor.Turkey;
import ocp.design.adaptor.TurkeyAdapter;
import ocp.design.adaptor.WildTurkey;

/**
 * @author dinesh.joshi
 *
 */
public class TestAdapter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Duck duck = new MallardDuck();
		Turkey turkey = new WildTurkey();
		TurkeyAdapter turkeyAdapter = new TurkeyAdapter(turkey);
		System.out.println();

		duck.fly();
		duck.quack();
		System.out.println();
		turkey.fly();
		turkey.gobble();
		System.out.println();

		turkeyAdapter.fly();
		turkeyAdapter.quack();
	}

}
