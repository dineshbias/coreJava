package test;

import org.junit.Before;

import junit.framework.TestCase;

public class BaseTestCase extends TestCase {

	protected int value1, value2;
	public BaseTestCase() {
		// TODO Auto-generated constructor stub
	}

	public BaseTestCase(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	protected void setUp()
	{
		value1 = 1;
		value2 = 2;
		System.out.println("Values Intialized.");
	}

	protected void tearDown()
	{
		System.out.println("Going Down");
	}

	protected void noInvocation()
	{
		System.out.println("Don't Invoke");
	}
}
