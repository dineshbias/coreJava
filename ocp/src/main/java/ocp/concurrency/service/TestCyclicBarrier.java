/**
 * 
 */
package ocp.concurrency.service;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author edinjos
 *
 */
public class TestCyclicBarrier {

	public static void main(String... args) throws Exception {
		CyclicBarrierExample.testUsingRunnable();
		//testUsingLambda();
	}

	public static void testUsingLambda() throws Exception {
		Animal animal = new Animal();
		animal.setName("Lion");

		Cage cage = new Cage();
		cage.setAnimal(animal);

		CyclicBarrier cb1 = new CyclicBarrier(3);
		CyclicBarrier cb2 = new CyclicBarrier(3,
				() -> System.out.println("*********Cleaned**********"));

		Zoo zoo = new Zoo(cage, cb1, cb2);

		ExecutorService service = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 3; i++) {
			service.submit(() -> zoo.performTasks());
		}

		service.shutdown();
	}

}

class Animal {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name.toString();
	}
}

class Zoo {
	private Cage cage;
	private CyclicBarrier cb1;
	private CyclicBarrier cb2;

	public Zoo(Cage cage, CyclicBarrier cb1, CyclicBarrier cb2) {
		// TODO Auto-generated constructor stub
		this.cage = cage;
		this.cb1 = cb1;
		this.cb2 = cb2;
	}

	public void setCage(Cage cage) {
		this.cage = cage;
	}

	public Cage getCage() {
		return cage;
	}

	public void performTasks() {

		try {
			cage.removeAnimals();
			cb1.await();
			cage.cleanCage();
			cb2.await();
			cage.addAnimals();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class Cage {

	private Animal animal;

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void removeAnimals() {

		System.out.println(Thread.currentThread().getName()
				+ " Removing Animal from Cage : " + animal);
	}

	public void cleanCage() {

		System.out.println(Thread.currentThread().getName()
				+ " Cleaning Cage : " + animal);
	}

	public void addAnimals() {

		System.out.println(Thread.currentThread().getName()
				+ " Adding animal to Cage : " + animal);
	}
}

class CyclicBarrierExample {

	static class Task implements Runnable {

		private CyclicBarrier barrier;

		public Task(CyclicBarrier barrier) {
			this.barrier = barrier;
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()
					+ " is waiting on barrier.");
			
			try {
				barrier.await();
				for (int i = 0; i < 1000; i++) {

				}
				System.out.println(Thread.currentThread().getName()
						+ " has crossed the barrier.");
			} catch (InterruptedException e) {

				e.printStackTrace();
			} catch (BrokenBarrierException e) {

				e.printStackTrace();
			}
		}

	}

	public static void testUsingRunnable() {
		final CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
			public void run() {
				System.out.println("******All parties arrived at barrier*****");
			}
		});

		Thread t1 = new Thread(new Task(cb), "Thread 1");
		Thread t2 = new Thread(new Task(cb), "Thread 2");
		Thread t3 = new Thread(new Task(cb), "Thread 3");

		t1.start();
		t2.start();
		t3.start();
	}
}