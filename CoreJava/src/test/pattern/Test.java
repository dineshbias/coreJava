/**
 * 
 */
package test.pattern;

import test.TestAbstractClass;
import test.TestClass;

/**
 * @author edinjos
 *
 */
public class Test {

	/**
	 * 
	 */
	public Test() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestClass test = new TestClass();
		checkTest(test);
	}

	public static void checkTest(TestAbstractClass obj) {
		TestClass abc = (TestClass) obj;
		System.out.println(abc.getName());
		abc.printDetails();
	}
}
