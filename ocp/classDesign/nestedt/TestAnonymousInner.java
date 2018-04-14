/**
 * 
 */
package ocp.classDesign.nestedt;

/**
 * @author edinjos
 *
 */
public class TestAnonymousInner {

	public static void main(String[] args) {
		AnonInner a = new AnonInner();
		System.out.println(a.admission(1000));
	}

}

interface SaleTodayOnly {
	abstract int dollarsOff();
}

class AnonInner {
	private int i =100;
	
	
	public int admission(int basePrice) {
		
		
		SaleTodayOnly s = new SaleTodayOnly() {

			@Override
			public int dollarsOff() {
				return i+10;
			}
			
		};
		
		return basePrice  - s.dollarsOff();
	}
}