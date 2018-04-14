/**
 * 
 */
package ocp.concurrency.thread;

/**
 * @author edinjos
 *
 */
public class TestThread {

	public static void main(String[] args) {
		Thread t = new ReadInventory();
		t.setDaemon(true);
		t.setPriority(Thread.MAX_PRIORITY);
		t.start();
		System.out.println("Exiting main method");
	}

}

class ReadInventory extends Thread {

	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.println("Printing record: " + i);
		}
	}
}