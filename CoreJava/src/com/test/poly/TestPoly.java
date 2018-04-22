/**
 * 
 */
package com.test.poly;

/**
 * @author edinjos
 *
 */
public class TestPoly {
	static {
		temp=1;
	}
	{
		dkasd =1;
	}
	/**
	 * 
	 */
	public TestPoly() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuilder b = new StringBuilder("01234567");
		b.replace(0, 3, "abcdez").append(true).insert(1, "FUCK you").delete(0, 0).reverse().reverse();
		System.out.println(b);
		//abcdez4567true
		//abcdez34567true
		
		String s = "";
		s.concat("ABC").toString();
		System.out.println(s.concat("ABC").toString());
		
		Z z = new Z();
		z.print(new A());
		z.print(new B());
		z.print(new C());
	}
	public static int temp;
	static{
		
	}
	
	int dkasd;
}

class Z {
	public void print(A a){
		a.getX();
		System.out.println(a.x);
	}
	public void print(B a){
		a.getX();
		System.out.println(a.x);
	}
	public void print(C a){
		a.getX();
		System.out.println(a.x);
	}
}

class A {
	protected int x = 10;

	protected void getX() {
		System.out.println("A : getX");
	}
}

class B extends A {
	protected int x = 100;
	
	protected void getX() {
		System.out.println("B : getX");
	}
}

class C extends B {
	protected int x = 100;
	
	protected void getX() {
		System.out.println("C : getX");
	}
}