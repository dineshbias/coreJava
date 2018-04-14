/**
 *
 */
package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author edinjos
 *
 */
public class TestRunner {

	/**
	 *
	 */
	public TestRunner() {
		System.out.println("TestRunner Initialized");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Result result = JUnitCore.runClasses(TestJunitAvailable.class);
		System.out.println("Run Count : "+ result.getRunCount());
		System.out.println("Failure Count : "+ result.getFailureCount());
		for(Failure failure : result.getFailures())
		{
			System.out.println("Failure Message :" + failure.getMessage());
		}

		System.out.println(" ");
		Result result2 = JUnitCore.runClasses(ArithmeticOperationTest.class);
		System.out.println("Run Count : "+ result2.getRunCount());
		System.out.println("Failure Count : "+ result2.getFailureCount());

	}

}
