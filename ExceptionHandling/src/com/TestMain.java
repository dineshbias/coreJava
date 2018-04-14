/**
 * 
 */
package com;

/**
 * @author edinjos
 *
 */
public class TestMain {

	/**
	 * 
	 */
	public TestMain() {
		// TODO Auto-generated constructor stub
	}
	
	public static void abc(int i) throws Exception {
		if(i==1){
			throw new Exception("Dinesh");
		}
	}
	
	public static void xyz(int i)  throws Exception {
		try{
			abc(i);
		}finally{
			System.out.println("Finally Block&&&&&&&&&&&&&&&&&");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***********");
		try {
			xyz(1);
		} catch(Exception e) {
			System.out.println("***********");
		}
		System.out.println("|||||||||||||||||||||||||||");
		try {
			xyz(2);
		} catch(Exception e) {
			System.out.println("|||||||||||||||||||||||||||");
		}
	}

}
