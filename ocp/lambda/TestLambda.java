/**
 * 
 */
package ocp.lambda;

import java.util.function.Predicate;

class Animal {

	private String species;
	private boolean canHop;
	private boolean canSwim;

	Animal(String species, boolean canHop, boolean canSwim) {
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

	@Override
	public String toString() {
		return species;
	}
}

@FunctionalInterface
interface CheckTrait {
	public boolean testSample(Animal a);
}

public class TestLambda {

	public static void print(Animal a, CheckTrait t) {
		if (t.testSample(a))
			System.out.println(" " + a.toString());
	}

	public static void test() {
		int input1 = 10, input2 = 5;
		MathOperation addition = (a, b) -> a + b;
		MathOperation subtraction = (a, b) -> {
			return a - b;
		};
		MathOperation division = (a, b) -> a / b;
		MathOperation multiplication = (a, b) -> a * b;

		System.out.println("Addition :" + addition.operate(input1, input2));
		System.out.println("Subtraction :"
				+ subtraction.operate(input1, input2));
		System.out.println("Division :" + division.operate(input1, input2));
		System.out.println("Multiplication :"
				+ multiplication.operate(input1, input2));

		System.out.println("Addition :"
				+ HelperPredicate.testMathOperations(addition, input1, input2));
		System.out.println("Subtraction :"
				+ HelperPredicate.testMathOperations(subtraction, input1,
						input2));
		System.out.println("Division :"
				+ HelperPredicate.testMathOperations(division, input1, input2));
		System.out.println("Multiplication :"
				+ HelperPredicate.testMathOperations(multiplication, input1,
						input2));
	}

	public static void main(String[] args) {
		test();
		Animal human = new Animal("Mammal", true, true);
		Animal fish = new Animal("fish", false, true);
		Animal kangaroo = new Animal("kangaroo", true, false);

		System.out.print("CanHop");
		print(human, a -> a.canHop());
		print(fish, a -> a.canHop());
		print(kangaroo, a -> a.canHop());

		System.out.print("CanSwim");

		print(human, (Animal a) -> a.canSwim());
		print(fish, a -> {
			return a.canSwim();
		});
		print(kangaroo, (Animal a) -> {
			return a.canSwim();
		});

		System.out.println("Using Predicate");
		HelperPredicate.print(fish, a -> a.canHop());
		HelperPredicate.print(human, a -> a.canHop());
	}

}

class HelperPredicate {
	public static void print(Animal a, Predicate<Animal> t) {
		if (t.test(a))
			System.out.println(" " + a.toString());
	}

	public static int testMathOperations(MathOperation operation, int input1,
			int input2) {
		return operation.operate(input1, input2);
	}
}

@FunctionalInterface
interface MathOperation {

	int operate(int input1, int input2);
}