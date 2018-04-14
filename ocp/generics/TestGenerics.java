/**
 * 
 */
package ocp.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author edinjos
 *
 */
public class TestGenerics {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test();
		Ship<?> s = new Ship<A>();
		System.out.println(s);

		List<String> l1 = new ArrayList<>();
		l1.add("Test String");
		printList1(l1);
		// printList2(l1);

		List<Object> l2 = new ArrayList<>();
		l2.add("Test String");
		l2.add(new Object());
		l2.add(new Integer(1));
		printList1(l2);
		printList2(l2);

		List<?> anyList = new ArrayList<String>();
		anyList.add(null);

		A a = new A();
		System.out.println(a.<String> test("s"));

		// Using Class Generics
		Elephant e = new Elephant();
		Double weight = 123_45.00_0000;
		GenericClassMulipleParams<Elephant, Double> gE = new GenericClassMulipleParams<>(
				e, weight);

		Human h = new Human();
		GenericClassMulipleParams<Human, Integer> gH = new GenericClassMulipleParams<>(
				h, 200);

		System.out.println(gE.getContents() + " " + gE.getSizeLimit());
		System.out.println(gH.getContents() + " " + gH.getSizeLimit());

		// Generic Methods
		gH.getContentsDefault("test", "method");
		gH.<String, String> getContentsDefault("sample", "");

		ArrayList list = new ArrayList<Human>();
		list.add(new Elephant());
		printHuman(list);

		// Upper bounded wildcards
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(new Integer(10));
		System.out.println("Total : " + total(numbers));

		List<Short> fnumbers = new ArrayList<Short>();
		fnumbers.add((short) 1);
		fnumbers.add(new Short((short) 10));
		System.out.println("Total : " + total(fnumbers));

		List<Goose> gooseGroupFlying = new ArrayList<Goose>();
		gooseGroupFlying.add(new Goose());
		gooseGroupFlying.add(new Goose());
		// anyFlyer(gooseGroupFlying);
		groupOfFlyers(gooseGroupFlying);
		System.out.println("  ");

		List<Flyer> everyoneFlying = new ArrayList<Flyer>();
		everyoneFlying.add(new Goose());
		everyoneFlying.add(new HangGlider());
		anyFlyer(everyoneFlying);
		groupOfFlyers(everyoneFlying);

		List<String> strings = new ArrayList<String>();
		strings.add("Tweet");

		List<Object> objects = new ArrayList<Object>(strings);
		// addSound3(strings);
		addSound4(strings);

		addSound3(objects);
		addSound4(objects);

		C c = new C();
		B b = new B();
		Object obj = new Object();

		List<?> unbounded = new ArrayList<A>();
		unbounded = new ArrayList<B>();
		// unbounded.add(a);
		// unbounded.add(b);
		// unbounded.add(c);
		// unbounded.add(obj);

		unbounded = new ArrayList<C>();
		// unbounded.add(a);
		// unbounded.add(b);
		// unbounded.add(c);
		// unbounded.add(obj);

		List<? extends A> upperBounded = new ArrayList<A>();
		upperBounded = new ArrayList<B>();
		// upperBounded.add(a);
		// upperBounded.add(b);
		// upperBounded.add(c);
		// upperBounded.add(obj);

		upperBounded = new ArrayList<C>();
		// upperBounded.add(a);
		// upperBounded.add(b);
		// upperBounded.add(c);
		// upperBounded.add(obj);

		List<? super A> lowerBounded = new ArrayList<A>();
		lowerBounded = new ArrayList<A>();
		lowerBounded.add(a);
		lowerBounded.add(b);
		lowerBounded.add(c);
		// lowerBounded.add(obj);

		lowerBounded = new ArrayList<Object>();
		lowerBounded.add(a);
		lowerBounded.add(b);
		lowerBounded.add(c);
		// lowerBounded.add(obj);

	}

	private static void test() {

		Juice j = new Juice();
		Water w = new Water();
		Glass<Juice> juice = new Glass<>(j);
		Glass<Water> water = new Glass<Water>(w);

		System.out.println("Taste:" + juice.getLiquidTaste());
		System.out.println("Taste:" + water.getLiquidTaste());

		juice = new Glass<Juice>();
		water = new Glass<Water>();

		System.out.println("Taste:" + juice.getLiquidTaste(j));
		System.out.println("Taste:" + water.getLiquidTaste(w));

		Glass2<AppleMangoJuice> appleMangoJuice = new Glass2<>();
		//Glass2<AppleJuice> appleJuice = new Glass2<AppleJuice>();
		
		Liquid l = new Water(); // Inhertiance works
		//Inheritence doesn't work for generics.
		//Glass3<Liquid> liquid = new Glass3<Water>();   
		
		Glass3<Liquid> liquid = new Glass4<Liquid>();
		
		System.exit(9);
		// Glass<Cake> cake = new Glass<>();
		// Glass<Diesel> diesel = new Glass<Diesel>();

	}

	private static int test(String string) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * Using unbounded
	 */
	private static void printHuman(List<?> humans) {
		for (Object human : humans) {
			System.out.println(human.toString());
		}
	}

	/*
	 * Using upper bound
	 */
	private static long total(List<? extends Number> list) {
		long count = 0;
		for (Number n : list) {
			count += n.longValue();
		}

		return count;
	}

	private static void anyFlyer(List<Flyer> flyers) {
		for (Flyer flyer : flyers) {
			flyer.fly();
		}
	}

	private static void groupOfFlyers(List<? extends Flyer> groupOfFlyers) {
		for (Flyer flyer : groupOfFlyers) {
			flyer.fly();
		}
	}

	/*
	 * private static void addSound1(List<?> list) { list.add("Quack"); }
	 * 
	 * private static void addSound2(List<? extends Object> list) {
	 * list.add("Quack"); }
	 */

	private static void addSound3(List<Object> list) {
		list.add("Quack");
	}

	/*
	 * Using Lower bound
	 */
	private static void addSound4(List<? super String> list) {
		list.add("Quack");
	}

	private static void printList1(List<?> list) {
		for (Object o : list) {
			System.out.println(o);
		}
	}

	private static void printList2(List<Object> list) {
		for (Object o : list) {
			System.out.println(o);
		}
	}
}

class Animal {
	@Override
	public String toString() {
		return "Animal";
	}
}

class Elephant extends Animal {

	@Override
	public String toString() {

		return "Elephant";
	}
}

class Human {

	@Override
	public String toString() {
		return "Human";
	}

}

interface Flyer {
	void fly();
}

class HangGlider implements Flyer {

	@Override
	public void fly() {
		System.out.println("HangGlider is flying");
	}

}

class Goose implements Flyer {

	@Override
	public void fly() {
		System.out.println("Goose is flying");
	}

}

class A {

	public <T> T test(T s) {
		return s;
	}
}

class B extends A {

}

class C extends B {

}

class Glass<T extends Liquid> {

	private T liquid;

	public Glass() {

	}

	public Glass(T liquid) {
		this.liquid = liquid;
	}

	public String getLiquidTaste() {
		return liquid.taste();
	}

	public <U extends Liquid> String getLiquidTaste(U juice) {
		return juice.taste();
	}
}

class Cake {

}

class Diesel {

}

class Glass2<T extends Juice & Fluid & MOIST> {

	private T liquid;

	public Glass2() {

	}

	public Glass2(T liquid) {
		this.liquid = liquid;
	}

	public String getLiquidTaste() {
		return liquid.taste();
	}

	public <U extends Juice & Fluid & MOIST> String getLiquidTaste(U juice) {
		return juice.taste();
	}
}

class Glass3<T> {

	private T liquid;

	public T getLiquidTaste() {
		return liquid;
	}
	
}

class Glass4<T> extends Glass3<T>{
	
}