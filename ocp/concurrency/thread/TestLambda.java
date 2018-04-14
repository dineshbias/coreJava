/**
 * 
 */
package ocp.concurrency.thread;

/**
 * @author edinjos
 *
 */
public class TestLambda {

	public static int counter;

	public static void main(String[] args) {
		new Thread(() -> {
			for(int i=0 ; i<10000 ; i++)
			counter++;
			System.out.println("counter : "+ counter);
		}).start();


		while (counter < 10000)
			System.out.println("Not reached yet.");

		System.out.println("Exiting main method " + counter);
	}

}
