/**
 * 
 */
package com.test.meth;

/**
 * @author edinjos
 *
 */
public class TestLambda {

	public TestLambda() {
		System.out.println("TestLambda constructor");
	}

	public static void main(String[] args) {
		
		System.out.println(operate( (z) -> "Poof")); 
		
		int e=1,f=2,g=3,h=4,i=0;
		i = e++ + (-f) - ++e * ++g + ++h;
		    
		System.out.println(i);
		
		System.out.println(0b10);
		System.out.println(071);
		System.out.println(100);
		System.out.println(0x1D);
		MathOperation addition = (int a, int b) -> a + b;
		MathOperation subtraction = (a, b) -> b - a;
		MathOperation multiplication = (int a, int b) -> {return a * b;};
		MathOperation division = (int a, int b) -> b / a;
		MathOperation remainder = (int a, int b) -> b % a;

		TestLambda tl = new TestLambda();
		int a = 10, b = 12;
		System.out.println("a:" + a + " b:" + b);

		System.out.println(tl.operate(a, b, addition));
		System.out.println(tl.operate(a, b, subtraction));
		System.out.println(tl.operate(a, b, multiplication));
		System.out.println(tl.operate(a, b, division));
		System.out.println(tl.operate(a, b, remainder));
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
	

	private static String operate(Secret a) {
		return a.magic(3.2);
	}
}

interface MathOperation {
	public int operation(int a, int b);
}

@FunctionalInterface
interface Secret {
	String magic(double d);
}