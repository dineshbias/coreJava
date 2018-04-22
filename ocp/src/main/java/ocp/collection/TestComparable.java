/**
 * 
 */
package ocp.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author edinjos
 *
 */
public class TestComparable {

	/**
	 * 
	 */
	public static void main(String... strings) {
		LinkedList<Duck> duck = new LinkedList<Duck>();
		duck.add(new Duck("kwasi"));
		duck.add(new Duck("Kwasi"));
		duck.add(new Duck("PATRICK"));
		duck.add(new Duck("1PATRICK"));
		System.out.println(duck);
		System.out.println("Sorting collection");
		Collections.sort(duck);
		System.out.println("Sorting collection");
		System.out.println(duck);
		
		Fruit[] fruits = new Fruit[4];
		Fruit pineappale = new Fruit("Pineapple", "Pineapple description",70);
		Fruit apple = new Fruit("Apple", "Apple description",100);
		Fruit orange = new Fruit("Orange", "Orange description",80);
		Fruit banana = new Fruit("Banana", "Banana description",90);
		fruits[0]=pineappale;
		fruits[1]=apple;
		fruits[2]=orange;
		fruits[3]=banana;
		
		for(int i=0; i< fruits.length; i++)
			System.out.print(fruits[i].getQuantity()+" ");
		System.out.println("---------Arrays Sorting");
		Arrays.sort(fruits);
		System.out.println("---------Array Sorted");
		for(int i=0; i< fruits.length; i++)
			System.out.print(fruits[i].getQuantity()+ " ");
		
	}

}

class Duck implements Comparable<Duck> {

	private String name;

	public String toString() {
		return name;
	};

	Duck(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Duck duck) {
		System.out.println("compareTo " + this.name+" "+duck.name);
		return name.compareTo(duck.name);
	}

}


class Fruit implements Comparable<Fruit> {
	private String fruitName;
	private String fruitDesc;
	private int quantity;

	public Fruit(String fruitName, String fruitDesc, int quantity) {
		super();
		this.fruitName = fruitName;
		this.fruitDesc = fruitDesc;
		this.quantity = quantity;
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public String getFruitDesc() {
		return fruitDesc;
	}

	public void setFruitDesc(String fruitDesc) {
		this.fruitDesc = fruitDesc;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	/*
	 * Comparable is a functional Interface having abstarct function compareTo 
	 * compareTo should return 0 if both objects are equal.
	 * compareTo should return less than zero if object on which compareTo has been called is smaller than the one which has been passed. 
	 */
	public int compareTo(Fruit paramT) {
		int compareQuantity = ((Fruit) paramT).getQuantity();
		System.out.println("compareTo..."+this.getFruitName()+" "+paramT.fruitName);
		
		// ascending order
		return this.quantity - compareQuantity;

	}

}