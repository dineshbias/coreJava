/**
 * 
 */
package ocp.design.immutable;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

/**
 * @author edinjos
 *
 */
public final class Animal {

	private final String species;
	private final int age;
	private final List<String> favoriteFoods ;

	public Animal(final String species, final int age, final List<String> favoriteFoods) {
		if (favoriteFoods == null) {
			throw new RuntimeErrorException(new Error(),
					"favoritefood is required.");
		}
		this.favoriteFoods = new ArrayList<String>(favoriteFoods);
		this.species = species;
		this.age = age;
		System.out.println("Animal constructed");
	}

	public String getSpecies() {
		return species;
	}
	
	public String getSpecies(String s ) {
		return species;
	}
	
	public int getAge() {
		return age;
	}

	public int getFavoriteFoodsCount() {
		return this.favoriteFoods.size();
	}

	public String getFavoriteFood(int index) {
		return this.favoriteFoods.get(index);
	}
}
