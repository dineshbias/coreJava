/**
 * 
 */
package ocp.classDesign.nestedt;

/**
 * @author edinjos
 *
 */
public class Test {

	interface Furry {
	}

	static class Chipmunk {
	}

	class FurryChipmunk implements Furry {
	}

	public static void main(String[] args) {
		
		Chipmunk c = new ocp.classDesign.nestedt.Test.Chipmunk();
		int result = 0;
		if (c instanceof Furry)
			result += 1;
		if (c instanceof Chipmunk)
			result += 2;
		if (null instanceof FurryChipmunk)
			result += 4;
		System.out.println(result);
	}

}
