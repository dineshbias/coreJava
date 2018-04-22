/**
 * 
 */
package ocp.concurrency.service;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author edinjos
 *
 */
public class TestAtomicOperations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		testSyncIssue();
		//testSynchronizedCounter();
	}

	public static void testSyncIssue() {
		ExecutorService service = Executors.newFixedThreadPool(100);
		Example e = new Example();
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			service.submit(() -> a.add(e.getNextValue()));
		}
		try {
			service.awaitTermination(10, TimeUnit.SECONDS);
			service.shutdown();
			System.out.print(a);
			for (int i = 0; i < 1000; i++) {
				if (a.contains(i))
					continue;
				System.out.println(i);
			}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static void testSynchronizedCounter() {
		ExecutorService service = Executors.newFixedThreadPool(100);
		SynchronizedCounter e = new SynchronizedCounter();
		ArrayList<Integer> a = new ArrayList<Integer>();
		Stack s;
		for (int i = 0; i < 1000; i++) {
			service.submit(() -> a.add(e.getNextValue()));
		}
		try {
			service.awaitTermination(10, TimeUnit.SECONDS);
			service.shutdown();
			System.out.println(a);
			for (int i = 0; i < 1000; i++) {
				if (a.contains(i))
					continue;
				System.out.println(i);
			}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}

class Example {
	private int value = 0;

	public int getNextValue() {
		return value++;
	}
}

class SynchronizedCounter {
	private int value = 0;

	synchronized public int getNextValue() {
		return value++;
	}
}