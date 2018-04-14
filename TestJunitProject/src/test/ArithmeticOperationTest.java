/**
 *
 */
package test;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author edinjos
 *
 */
public class ArithmeticOperationTest extends BaseTestCase {

	/**
	 *
	 */
	public ArithmeticOperationTest() {
		System.out.println("Initializing ArithmeticOperationTest");
	}

	/**
	 * @param name
	 */
	public ArithmeticOperationTest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testSum()
	{
		System.out.println("testSum start");
		int sum = 3;
		assertEquals(this.value1 + this.value2, sum);
	}

	public void testSubtract()
	{
		System.out.println("testSubstract start");
		int difference = 1;
		assertEquals(this.value2 - this.value1, difference);
	}

	public void testMulliplication()
	{
		System.out.println("testSubstract multiply");
		int product = 2;
		assertEquals(this.value2 * this.value1, product);
	}

	public void testDivision1()
	{
		System.out.println("testDivision start");
		int quotient = 0;
		assertEquals(this.value2 / this.value1, quotient);
	}

	@Ignore
	public void testDivision2()
	{
		System.out.println("testDivision start");
		int remainder = 0;
		assertEquals(this.value2 % this.value1, remainder);
	}

}
