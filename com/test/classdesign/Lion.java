/**
 * 
 */
package com.test.classdesign;

/**
 * @author edinjos
 *
 */
public class Lion extends Animal {

	/**
	 * 
	 */
	public Lion() {
		super(10);
		//this("Dinesh");
		System.out.println("Constructor Lion");
		protNumberOfLegs=4;
		roar();
	}
	
	public Lion(String age) {
		super("");
		
	}
	public void roar(){
		System.out.println("The "+ getAge()+ " Legs : " + protNumberOfLegs+" year old lion says ROAR!!! "+publicTemp+ " "+ defaultTemp);
		
	}
}
