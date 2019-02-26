/**
 * 
 */
package com.test.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author edinjos
 *
 */
public class TestJAVA8Lambdas {

	TestJAVA8Lambdas() {
		System.out.println("Constructor");
	}

	static {
		System.out.println("Static Block");
	}

	public static void main(String... strings) throws Exception {

		System.out.println("MAIN");
		TestJAVA8Lambdas tester = new TestJAVA8Lambdas();
		System.out.println(test2((i) -> i == 6));
		System.out.println(test2((i) -> {return i == 5;}));
		
		MathOperation addition = (int a, int b) -> a + b;
		int x = 2, y = 5;
		System.out.println(x + "+" + y + "=" + tester.operate(x, y, addition));

		// with out type declaration
		MathOperation subtraction = (a, b) -> b - a;
		System.out.println(y + "-" + x + "="
				+ tester.operate(x, y, subtraction));

		MathOperation multiplication = (a, b) -> {
			return a * b;
		};
		System.out.println(y + "*" + x + "="
				+ tester.operate(x, y, multiplication));

		MathOperation division = (a, b) -> b / a;
		System.out.println(y + "/" + x + "=" + tester.operate(x, y, division));

		MathOperation modulus = (int a, int b) -> {
			return b % a;
		};
		System.out.println(y + "%" + x + "=" + tester.operate(x, y, modulus));

		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("Fish", false, true));
		animals.add(new Animal("Kangaroo", true, false));
		animals.add(new Animal("Rabbit", true, false));
		animals.add(new Animal("Turtle", false, true));

		tester.print(animals, a -> a.canHop());
		tester.print(animals, a -> a.canSwim());

		// With Anonymous class.
		IsFunctional isFunc = new IsFunctional() {
			@Override
			public void testMetod(String data) {
				System.out.println("Printing " + data
						+ " from Anonymous class.");
			}
		};
		// With lambda expression.
		IsFunctional func = demoData -> 
			System.out.println("Printing " + demoData
					+ " from Lambda expression.");
		
		
		tester.test(func);
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

	private void print(List<Animal> animals, Predicate<Animal> checker) {
		for (Animal animal : animals) {
			if (checker.test(animal)) {
				System.out.print(animal.getSpecies() + " ");
			}
		}
		System.out.println(" ");
	}
	
	private void test(IsFunctional mathOperation) {
		System.out.println("test caled");
	}
	
	private static boolean test2(Predicate<Integer> p) {
		   return p.test(5);
		}
}

interface MathOperation {
	public int operation(int a, int b);
}

class Animal {
	private String species;
	private boolean canHop;
	private boolean canSwim;

	public Animal(String species, boolean canHop, boolean canSwim) {
		this.species = species;
		this.canHop = canHop;
		this.canSwim = canSwim;
	}

	public boolean canHop() {
		return canHop;
	}

	public boolean canSwim() {
		return canSwim;
	}

	public String getSpecies() {
		return species;
	}
}

// Functional Interfaces can have only one abstract method.
@FunctionalInterface
interface IsFunctional {
	void testMetod(String data);
}


