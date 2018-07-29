/**
 * 
 */
package ocp.reflection.test;

/**
 * @author dinesh.joshi
 *
 */
public class Sample extends SampleAbstractClass {

	private int privateI;
	protected String potectedS;
	public String publicS;
	public static String publicStaticString;
	private TestC testC;

	public Sample(TestC testC) {
		super();
		this.testC = testC;
	}

	public Sample() {
		super();
	}

	public static String getPublicStaticString() {
		return publicStaticString;
	}

	public static void setPublicStaticString(String publicStaticString) {
		Sample.publicStaticString = publicStaticString;
	}

	public TestC getTestC() {
		return testC;
	}

	public void setTestC(TestC testC) {
		this.testC = testC;
	}

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

	protected String getProtectedMethod() {
		return "protected Mehod";
	}

	String getDefaultMethod() {
		return "default Mehod";
	}

	String testPrivateMsg() {
		System.out.println("Private method called.");
		return "Private method called.";
	}

	public String getPublicMethod() {
		return "public Method";
	}

	@Override
	public String toString() {
		return "Sample [privateI=" + privateI + ", potectedS=" + potectedS + ", publicS=" + publicS + "]";
	}

}
