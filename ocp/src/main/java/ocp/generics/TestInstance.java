package ocp.generics;

public class TestInstance {

	public static void main(String... args) {
		System.out.println("Main..........");

		PQ pq = new PQ();
		boolean flag = pq instanceof X;
		System.out.println("pq instance of X " + flag);
		flag = pq instanceof Y;
		System.out.println("pq instance of Y " + flag);
		flag = pq instanceof PQ;
		System.out.println("pq instance of PQ " + flag);
		flag = pq instanceof XY;
		System.out.println("pq instance of XY " + flag);
		System.out.println("");

		XY xy = new XY();
		flag = xy instanceof X;
		System.out.println("xy instance of X " + flag);
		flag = xy instanceof Y;
		System.out.println("xy instance of Y " + flag);
		flag = xy instanceof PQ;
		System.out.println("xy instance of PQ " + flag);
		flag = xy instanceof XY;
		System.out.println("xy instance of XY " + flag);
		System.out.println("");
		System.out.println();

	}
}

interface X {

}

abstract class Y implements X {

}

class PQ extends Y {

}

class XY extends PQ {

}