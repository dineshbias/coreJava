/**
 * 
 */
package ocp.design.builder;

import java.util.List;

/**
 * @author edinjos
 *
 */
public class AnimalBuilder {

	private String species;
	private int age;
	private List<String> favoriteFoods;

	/**
	 * 
	 */
	public AnimalBuilder setSpecies(String species) {
		this.species = species;
		System.out.println(species);
		return this;
	}

	public AnimalBuilder setAge(int age) {
		this.age = age;
		System.out.println(age);
		return this;
	}

	public AnimalBuilder setFavoriteFoods(List<String> favoriteFoods) {
		this.favoriteFoods = favoriteFoods;
		System.out.println(favoriteFoods);
		return this;
	}

	public Animal build() {
		return new Animal(species, age, favoriteFoods);
	}
}
