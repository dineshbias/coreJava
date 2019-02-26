/**
 * 
 */
package com;

/**
 * @author dinesh.joshi
 *
 */
public class TestPassByValueRefrence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i=1;
		int j=2;
		System.out.println( "swap " + i +" " +j);
		swapIntegers(i, j);
		System.out.println( "swap " + i +" " +j);
		
		A a = new A();
		a.setIdentifier("First Object");
		A b = new A();
		b.setIdentifier("Second Object");
		System.out.println( "Before swap " + a +" " +b);
		swapObjects(a, b);
		System.out.println( "After swap " + a +" " +b);
		manuplateObjects(a, b);
		System.out.println( "After Manuplating " + a +" " +b);
	}
	
	public static void swapIntegers(int i, int j){
		int swap = i;
		i = j ;
		j =	swap;	
	}
	
    public static void swapObjects(A a, A b){
		A swap = a;
		a = b;
		b = swap;
	}
    
    public static void manuplateObjects(A a, A b){
		String identifier = a.getIdentifier();
		a.setIdentifier(b.getIdentifier());
		b.setIdentifier(identifier);
	}
}

class A{
	
	private String identifier;
	
	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	@Override
	public String toString() {
		return "A [identifier=" + identifier + "]";
	}

}