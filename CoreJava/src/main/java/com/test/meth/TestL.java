/**
 * 
 */
package com.test.meth;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author edinjos
 *
 */
public class TestL {

	public TestL() {
		System.out.println("TestL constructor");
	}

	public static void main(String[] args) {
		System.out.println("TestL main");

		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("Fish", false, true));
		animals.add(new Animal("Kangaroo", true, false));
		animals.add(new Animal("Rabbit", true, false));
		animals.add(new Animal("Turtle", false, true));
		
		TestL t = new TestL();
		t.print(animals, a -> {return a.canHop();} );
		t.print(animals, a -> a.canSwim() );
	}

	private void print(List<Animal> animals, Predicate<Animal> checker) {
		
		for(Animal a : animals){
			if(checker.test(a)){
				System.out.print(a.getSpecies()+" ");
			}
		}
		System.out.println(" ");
	}

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
