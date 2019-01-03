/**
 * 
 */
package ocp.synch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dinesh.joshi
 *
 */
public class TestHelloWorldSynchronization {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testSynchronization();
		// testDeadLock();
	}

	public static void testSynchronization() {
		HelloWorldSynchronization sharedObject = new HelloWorldSynchronization();

		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(10);

			service.submit(() -> HelloWorldSynchronization.test1());
			service.submit(() -> sharedObject.test2());
			service.submit(() -> sharedObject.test3());
			service.submit(() -> sharedObject.test4());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != service) {

				service.shutdown();
				System.out.println("Shutdown Service");
			}
		}
	}

	public static void testDeadLock() {
		HelloWorldSynchronization sharedObject = new HelloWorldSynchronization();

		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(10);

			service.submit(() -> sharedObject.test5());
			service.submit(() -> sharedObject.test6());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != service) {

				service.shutdown();
				System.out.println("Shutdown Service");
			}
		}
	}

}
