/**
 * 
 */
package ocp.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author edinjos
 *
 */
public class TestMethodRefrences {

	public static void test() {
		List<String> list = new ArrayList<String>();
		list.add("ABC");
		list.add("XYZ");
		list.add("PQR");
		System.out.println(list);

		Predicate<String> p = s -> s.startsWith("A");
		list.removeIf(p);
		System.out.println(list);
		
		
		//Predicate<String> p2 =  String :: startsWith;
		//list.removeIf(p2);
		
		System.out.println(list);

	}

	public static void testMethodRefrences() {
		List<Animal> aList = new ArrayList<Animal>();
		aList.add(new Animal("Tiger", 60));
		aList.add(new Animal("Lion", 80));
		aList.add(new Animal("Dog", 20));

		// static method refrences.
		Comparator<Animal> cByWeight = DuckHelper::compareByWeight;

		Test<Animal> test = DuckHelper::compareByWeight;

		for (Animal a : aList) {
			System.out.println(a);
		}
		System.out.println("\nSort by weight");
		Collections.sort(aList, cByWeight);
		for (Animal a : aList) {
			System.out.println(a);
		}

		// Instance methods on a particular Instance.
		System.out.println("\nSort by Name");
		DuckHelper duckHelper = new DuckHelper();
		//Comparator<Animal> abc = (a1,a2) -> duckHelper.compareByName(a1, a2);
		
		Collections.sort(aList, duckHelper::compareByName);
		// aList.forEach(c -> System.out.println(c));
		aList.forEach(System.out::println);

		
		// Instance methods on an instance to be determined at runtime.
		String[] stringArray = { "Barbara", "James", "mary", "John",
				"Patricia", "Robert", "Michael", "Linda" };
		for (String name : stringArray)
			System.out.print(name + " ");
		System.out.println("");
		Comparator<String> cIgnoreCase = String::compareToIgnoreCase;
		Arrays.sort(stringArray, cIgnoreCase);

		for (String name : stringArray)
			System.out.print(name + " ");
		
		//Constructors
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test();
		testMethodRefrences();
	}

}

class Animal {
	private String name;
	private int weight;

	public Animal(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public String toString() {
		return name + " " + weight;
	}
}

class DuckHelper {

	public static int compareByWeight(Animal a1, Animal a2) {
		return a1.getWeight() - a2.getWeight();
	}

	public int compareByName(Animal a1, Animal a2) {
		return a1.getName().compareTo(a2.getName());
	}
}

@FunctionalInterface
interface Test<T> {
	int test(T t1, T t2);
}