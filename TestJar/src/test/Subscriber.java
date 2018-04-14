/**
 *
 */
package test;

/**
 * @author edinjos
 *
 */
public class Subscriber {

	private String name;
	/**
	 *
	 */
	public Subscriber() {
		// TODO Auto-generated constructor stub
		System.out.println("Subscriber Initialized");
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}
}
