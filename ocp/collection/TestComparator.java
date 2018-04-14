/**
 * 
 */
package ocp.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author edinjos
 *
 */
public class TestComparator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Tiger> list = new LinkedList<Tiger>();
		list.add(new Tiger("Robin", (float) 50.3));
		list.add(new Tiger("Zobin", (float) 30.8));
		list.add(new Tiger("Tobin", (float) 70.2));
		
		System.out.println(list);
		System.out.println();
		sortByComparator(list);
		System.out.println();
		sortByComparatorUsingLabdaExpressions(list);

	}

	public static void sortByComparator(List list) {

		Comparator cByWeight = new Comparator<Tiger>() {

			@Override
			public int compare(Tiger arg0, Tiger arg1) {
				Float f = arg0.getWeight() - arg1.getWeight();
				return f.intValue();
			}
		};

		Comparator cByName = new Comparator<Tiger>() {

			@Override
			public int compare(Tiger arg0, Tiger arg1) {
				return arg0.getName().compareTo(arg1.getName());
			}
		};

		Collections.sort(list, cByWeight);
		System.out.println(list);
		Collections.sort(list, cByName);
		System.out.println(list);
	}

	public static void sortByComparatorUsingLabdaExpressions(List list) {
		Comparator<Tiger> cByWeight = (Tiger d1, Tiger d2) -> {
			return Float.valueOf((d1.getWeight() - d2.getWeight())).intValue();
		};

		Comparator<Tiger> cByName = (d1,d2) -> {return d1.getName().compareTo(d2.getName());};
				
		Collections.sort(list, cByWeight);
		System.out.println(list);
		Collections.sort(list, cByName);
		System.out.println(list);
		
		
	}
}

class Tiger {
	String name;
	float weight;

	Tiger(String name, float weight) {
		this.name = name;
		this.weight = weight;
	}

	public float getWeight() {
		return weight;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name + " " + weight;
	}
}