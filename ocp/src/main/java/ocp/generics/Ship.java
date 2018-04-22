package ocp.generics;

public class Ship<U> implements Shippable<U> {

	U[] content;
	
	public Ship(U[] content){
		System.out.println("Constructor.....");
		this.content = content;
	}
	
	public Ship(){
		System.out.println("Constructor....."+ content);
		
	}
	
	@Override
	public void ship(U[] t) {
		System.out.println("ship.....");
		this.content = t;
		
	}



}
