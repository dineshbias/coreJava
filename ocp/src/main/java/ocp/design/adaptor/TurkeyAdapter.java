package ocp.design.adaptor;

public class TurkeyAdapter implements Duck {

	private Turkey turkey;

	public TurkeyAdapter(Turkey turkey) {
		System.out.println("TurkeyAdapter created..");
		this.turkey = turkey;
	}

	@Override
	public void quack() {
		turkey.gobble();
	}

	@Override
	public void fly() {
		turkey.fly();

	}

}
