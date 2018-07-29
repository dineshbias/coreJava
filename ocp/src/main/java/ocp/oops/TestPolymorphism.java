package ocp.oops;

public class TestPolymorphism {

	public static void main(String[] args) {

		SampleA test = new SampleA();
		System.out.println(test.sDefault);
		System.out.println(test.sProtected);
		System.out.println(test.sPublic);

		Test t = null;

		if (t instanceof Test) {
			System.out.println("Test");

		}
		if (t instanceof Animal) {
			System.out.println("Animal");

		}
		if (t instanceof WildAnimal) {
			System.out.println("WildAnimal");

		}

		Lemur l = new Lemur();

		System.out.println("Lemur age : " + l.age);
		System.out.println("Lemur hair : " + l.hasHair());
		System.out.println("Lemur tail : " + l.isTailStripped());

		HasTail h = l;
		System.out.println("HasTail tail : " + h.isTailStripped());
		System.out.println("HasTail age : " + h.age);

		Primate p = l;
		System.out.println("Primate hair : " + p.hasHair());
		System.out.println("Primate age : " + p.age);
		System.out.println("**********");
		Lemur l3 = (Lemur) p;
		System.out.println("Lemur3 age : " + l3.age);
		System.out.println("Lemur3 hair : " + l3.hasHair());
		System.out.println("Lemur3 tail : " + l3.isTailStripped());
		System.out.println("**********");

		Lemur l2 = l;
		System.out.println("Lemur2 age : " + l2.age);
		System.out.println("Lemur2 hair : " + l2.hasHair());
		System.out.println("Lemur2 tail : " + l2.isTailStripped());

		Primate p2 = new Primate();
		l3 = (Lemur) p2;

	}

}

class Primate {
	public int age = 10;

	public boolean hasHair() {
		return true;
	}
}

interface HasTail {
	public int age = 1;

	public boolean isTailStripped();
}

class Lemur extends Primate implements HasTail {

	public int age = 100;

	@Override
	public boolean isTailStripped() {
		return false;
	}

}

interface Test {

}

class Animal implements Test {

}

class WildAnimal extends Animal {

}