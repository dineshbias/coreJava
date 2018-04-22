package ocp.generics;

public interface Liquid {
	public String taste();
}

class Juice implements Liquid {

	@Override
	public String taste() {
		return "Sweet";

	}

}

class Water implements Liquid {

	@Override
	public String taste() {
		return null;

	}

}

class AppleMangoJuice extends Juice implements Fluid, MOIST {

}