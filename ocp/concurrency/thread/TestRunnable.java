/**
 * 
 */
package ocp.concurrency.thread;

/**
 * @author edinjos
 *
 */
public class TestRunnable {

	public static void main(String[] args) {
		Thread t1 = new Thread(new PrintData());
		Thread t2 = new Thread(new PrintData());
		t1.setPriority(Thread.MIN_PRIORITY);
		t1.setName("Thread1");
		t2.setPriority(Thread.MAX_PRIORITY);
		t2.setName("Thread2");
		t1.start();
		t2.start();

		System.out.println("Exiting main method");
	}

}

class PrintData implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName()
					+ " Printing record: " + i);
		}
	}

}
