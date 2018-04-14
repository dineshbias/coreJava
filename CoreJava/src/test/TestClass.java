package test;

import test.TestAbstractClass;
import test.TestInterface;

public class TestClass extends TestAbstractClass implements TestInterface {
	private String name = "Dinesh";
	public TestClass() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void printDetails() {
		System.out.println("***********TestClass printDetails***********");
		
	}

}
