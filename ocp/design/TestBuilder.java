/**
 * 
 */
package ocp.design;

import java.util.Arrays;
import java.util.List;

import ocp.design.builder.Animal;
import ocp.design.builder.AnimalBuilder;

/**
 * @author edinjos
 *
 */
public class TestBuilder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		AnimalBuilder builder = new AnimalBuilder();
		Animal a = builder.setAge(10).setSpecies("duck")
				.setFavoriteFoods(Arrays.asList("grass", "fish")).build();
		
	}

}
