/**
 *
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author edinjos
 *
 */
public class TestJunitAvailable {

	/**
	 * @param args
	 */
	@Test
	public void testJunit() {
		System.out.println("Inside testJunit");
		String str = "Junit is working";
		assertEquals(str,"Junit is working");
	}

	@Test
	public void testJunit2() {
		System.out.println("Inside testJunit2");
		String str = "Junit is working";
		assertEquals(str,"Junit is working");
	}

	@Ignore
	public void testFailedCase() {
		System.out.println("Inside testJunit");
		String str = "Junit is not working";
		assertEquals(str,"Junit is working");
	}

	public void testCaseNotExecuted() {
		System.out.println("Inside testCaseNotExecuted");
		String str = "testCaseNotExecuted";
		assertEquals(str,"testCaseNotExecuted");
	}

	@Before
	public void testBeforeEachTestMethod() {
		System.out.println("Inside testBeforeEachTestMethod");
	}

	@After
	public void testAfterEachTestMethod() {
		System.out.println("testAfterEachTestMethod");
		System.out.println(" ");
	}

	@BeforeClass
	public static void testBeforeClass() {
		System.out.println("Inside testBeforeClass");
	}

	@AfterClass
	public static void testAfterClass() {
		System.out.println("testAfterClass");
		System.out.println(" ");
	}
}
