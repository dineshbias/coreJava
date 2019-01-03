/**
 * 
 */
package ocp.concurrency.service;

import java.util.concurrent.CompletableFuture;

/**
 * @author dinesh.joshi
 *
 */
public class TestCompletableFuture {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SampleService s = new SampleService();
		TestCompletableFuture t = new TestCompletableFuture();
		for (int i = 0; i < 5; i++) {
			CompletableFuture<Long> l = CompletableFuture.supplyAsync(() -> s.callExternal());
			l.thenAccept(t::callback);
		}
		System.out.println("Exiting...");
	}

	public void callback(long i) {
		System.out.println(
				Thread.currentThread().getName() + Thread.currentThread().getId() + " Processing callback " + i);
	}
}

class SampleService {

	public long callExternal() {
		long time = System.currentTimeMillis();
		try {
			System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId() + " sleep");

			Thread.sleep(1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId() + " awake");
		return time;
	}

}
