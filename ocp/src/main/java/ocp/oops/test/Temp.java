/**
 * 
 */
package ocp.oops.test;

/**
 * @author dinesh.joshi
 *
 */
public class Temp implements X {

	private String sPrivate;

	protected String sProtected;

	public String sPublic;

	String sDefault;

	public Temp() {
		System.out.println(
				"********************************************** Constructed *************************************");
	}

	@Override
	public String getsPrivate() {
		return sPrivate;
	}

	@Override
	public void setsPrivate(String sPrivate) {
		this.sPrivate = sPrivate;
	}

	@Override
	public String getsProtected() {
		return sProtected;
	}

	@Override
	public void setsProtected(String sProtected) {
		this.sProtected = sProtected;
	}

	@Override
	public String getsPublic() {
		return sPublic;
	}

	@Override
	public void setsPublic(String sPublic) {
		this.sPublic = sPublic;
	}

	@Override
	public String getsDefault() {
		return sDefault;
	}

	@Override
	public void setsDefault(String sDefault) {
		this.sDefault = sDefault;
	}

	@Override
	public String toString() {
		return "Temp [sPrivate=" + sPrivate + ", sProtected=" + sProtected + ", sPublic=" + sPublic + ", sDefault="
				+ sDefault + "]";
	}

}
