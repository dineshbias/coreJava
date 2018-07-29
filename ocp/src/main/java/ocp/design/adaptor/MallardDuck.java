package ocp.design.adaptor;

public class MallardDuck implements Duck {

	public MallardDuck() {
		System.out.println("MallardDuck Created");
	}

	@Override
	public void quack() {
		System.out.println("Duck quack");

	}

	@Override
	public void fly() {
		System.out.println("Duck fly");

	}

}
