/**
 * 
 */
package ocp.reflection.test;

/**
 * @author dinesh.joshi
 *
 */
public class Sample {
	private int privateI;
	protected String potectedS;
	public String publicS;

	public int getPrivateI() {
		return privateI;
	}

	public void setPrivateI(int privateI) {
		this.privateI = privateI;
	}

	public String getPotectedS() {
		return potectedS;
	}

	public void setPotectedS(String potectedS) {
		this.potectedS = potectedS;
	}

	public String getPublicS() {
		return publicS;
	}

	public void setPublicS(String publicS) {
		this.publicS = publicS;
	}

	private String getPrivateMethod() {
		return "private Mehod";
	}

	private String getProtectedMethod() {
		return "protected Mehod";
	}

	public String getPublicMethod() {
		return "public Method";
	}

	@Override
	public String toString() {
		return "Sample [privateI=" + privateI + ", potectedS=" + potectedS + ", publicS=" + publicS + "]";
	}

	
}
