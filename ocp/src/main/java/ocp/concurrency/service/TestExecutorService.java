/**
 * 
 */
package ocp.concurrency.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

/**
 * @author edinjos
 *
 */
public class TestExecutorService {

	/**
	 * @param args
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws TimeoutException
	 */
	public static void main(String[] args) throws InterruptedException,
			ExecutionException, TimeoutException {
		System.out.println("Processors : "
				+ Runtime.getRuntime().availableProcessors());
		//testSingleThreadExecutorAndShutdown();
		// testSingleThreadExecutorAndShutDownNow();
		//testSingleThreadExecutorAndSubmit();
		// testSingleThreadExecutorSubmitFuture();
		//testSingleThreadExecutorWithCallable();
		//testTasksAsCollections();
		// testAmbiguousLambdas();
		testConcurrencyWithFixedThreadPool();
		
		
		//testSchedulingNonRepeatitiveRunnableTaskwithDelay();
		//testSchedulingNonRepeatitiveCallableTaskwithDelay();
		//testScheduleRepeatitiveTaskAtFixedRate();
		//testScheduleRepeatitiveTaskAtFixedInterval();
		//testSynschronization();
	}

	public static void testSingleThreadExecutorAndShutdown()
			throws InterruptedException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			System.out.println("Begin ..");

			service.execute(() -> {
				for (int i = 0; i < 100000; i++) {
					System.out.println("i = " + i);
				}
			});

			service.execute(() -> System.out
					.println("Lambda Thread Implementation"));
		} finally {
			if (null != service) {
				service.awaitTermination(10, TimeUnit.SECONDS);
				service.shutdown();
				
			}

		}
		System.out.println("End ..");
	}

	public static void testSingleThreadExecutorAndShutDownNow() {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			System.out.println("Begin ..");
			service.execute(() -> {
				for (int i = 0; i < 10; i++) {
					System.out.println("Thread 1 " + i + "= " + i);
				}
			});
			service.execute(() -> {
				for (int i = 0; i < 10; i++) {
					System.out.println("Thread 2 " + i + "= " + i);
				}
			});
			service.execute(() -> System.out
					.println("Lambda Thread Implementation"));
		} finally {
			if (null != service) {
				List<Runnable> task = service.shutdownNow();
				System.out.println(task);
			}

		}
	}

	public static void testSingleThreadExecutorAndSubmit() {
		ExecutorService service = null;
		Future<?> task1 = null;
		Future<?> task2 = null;
		
		try {
			service = Executors.newSingleThreadExecutor();
			System.out.println("Begin ..");
			task1 = service.submit(() -> {
				for (int i = 0; i < 100; i++) {

					System.out.println(Thread.currentThread().getName()
							+ " Executing** " + i);
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		})	;
			System.out.println("*********Sbmitted**********");
			task2 = service.submit(() -> {
				for (int i = 0; i < 100; i++) {

					System.out.println(Thread.currentThread().getName()
							+ " Executing " + i);
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		})	;
		} finally {
			if (null != service) {
				System.out.println("Shutting Down ");

				service.shutdown();
				System.out.println("Shut Down Completed");
			}
		}
		System.out.println("Task1 completed " + task1.isDone()
				+ " Task1 cancelled " + task1.isCancelled());
		System.out.println("Task2 completed " + task2.isDone()
				+ " Task2 cancelled " + task2.isCancelled());
		
		System.out.println("End ..");
	}

	public static void testSingleThreadExecutorSubmitFuture()
			throws InterruptedException, ExecutionException {
		ExecutorService service = null;
		Future<?> task1 = null;
		Future<?> task2 = null;
		try {
			service = Executors.newSingleThreadExecutor();
			System.out.println("Begin :");
			task1 = service.submit(() -> System.out.println("Thread 1"));
			
			task2 = service.submit(() -> {
				for (int i = 0; i < 1000000000; i++) {
				}

				// System.out.println("Thread 2 " + i);
				});
			System.out.println("task1 " + task1.isCancelled() + " "
					+ task1.isDone());
			System.out.println("task2 " + task2.isCancelled() + " "
					+ task2.isDone());

			System.out.println("task1 " + task1.get());
			System.out.println("task2 " + task2.get(10, TimeUnit.SECONDS));
			System.out.println("task1 " + task1.isCancelled() + " "
					+ task1.isDone());
			System.out.println("task2 " + task2.isCancelled() + " "
					+ task2.isDone());
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			service.shutdownNow();
			System.out.println("Inside Finally");
		}
	}

	public static void testSingleThreadExecutorWithCallable() {
		ExecutorService service = null;
		Future<Temp> task1 = null;
		try {
			service = Executors.newSingleThreadExecutor();
			task1 = service.submit(() -> new Temp());
			System.out.println("Result of a task/callable:" + task1.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			
		} finally {
			System.out.println("finally..");
			if (null != service) {
				service.shutdown();
			}
		}
		System.out.println("...............");
	}

	public static void testTasksAsCollections() {
		ExecutorService service = null;

		Callable<Boolean> task1 = () -> {
			for (int i = 0; i < 1000; i++) {

			}
			System.out.println("processing task1.");
			return true;
		};

		Callable<Boolean> task2 = () -> {
			for (int i = 0; i < 1000; i++) {

			}
			System.out.println("processing task2...");
			return true;
		};

		Collection<Callable<Boolean>> list = new ArrayList<Callable<Boolean>>();
		list.add(task1);
		list.add(task2);

		try {
			service = Executors.newSingleThreadExecutor();
			List<Future<Boolean>> respList = service.invokeAll(list);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("finally....");
			if (null != service)
				service.shutdown();
		}
		System.out.println("Exiting....");
	}

	public static void testAmbiguousLambdas() {
		useCallable(() -> 9);
		useSupplier(() -> 9);

		useCallable(() -> {
			throw new Exception();
		});

		/*
		 * useSupplier(() -> { throw new Exception(); });
		 */

	}

	public static void useCallable(Callable<Integer> callable) {
		System.out.println("useCallable");
	}

	public static void useSupplier(Supplier<Integer> supplier) {
		System.out.println("useSupplier");
	}

	public static void testSchedulingNonRepeatitiveRunnableTaskwithDelay() {

		ScheduledExecutorService service = null;
		ScheduledFuture<?> future = null;
		try {
			service = Executors.newSingleThreadScheduledExecutor();
			
			future = service.schedule(
					() -> System.out.println("Running Delayed Task"), 999,
					TimeUnit.MILLISECONDS);
		} finally {
			System.out.println("finally executing");
			if (null != service)
				service.shutdown();
		}
		
		try {
			if (null != service) {
				System.out.println("Task Completed : "
						+ service.awaitTermination(1, TimeUnit.SECONDS));

				if (!service.isTerminated())
					System.out.println("Future :" + future.cancel(true));
			}

		} catch (InterruptedException e) {
			System.out.println("Exception " + e);
		}
		System.out.println("Exiting...");
	}

	public static void testSchedulingNonRepeatitiveCallableTaskwithDelay() {
		ScheduledExecutorService service = null;
		ScheduledFuture<Temp> future = null;
		try {
			service = Executors.newSingleThreadScheduledExecutor();
			future = service.schedule(new CallableExample(), 10,
					TimeUnit.SECONDS);
			System.out.println("************scheduled************");
			future = service.schedule(new CallableExample(), 5,
					TimeUnit.SECONDS);
			System.out.println("************scheduled************");
		} finally {
			try {
				System.out.println("finally....." + future.get());
			} catch (InterruptedException | ExecutionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (null != service) {
				service.shutdown();
				try {
					service.awaitTermination(1, TimeUnit.MILLISECONDS);
					future.cancel(true);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}

		}
		System.out.println("Exiting ....");
	}

	public static void testScheduleRepeatitiveTaskAtFixedRate() {
		ScheduledExecutorService service = null;
		try {
			service = Executors.newSingleThreadScheduledExecutor();
			
			service.scheduleAtFixedRate(
					() -> {
						System.out.println("Task..");
						for (int i = 0; i < 2; i++) {
							System.out.println(Thread.currentThread().getName()
									+ " " + i);
						}
					}, 0, 1, TimeUnit.MILLISECONDS);
		} finally {
			System.out.println("finally....");
			if (null != service) {

				try {
					Thread.sleep(1000);
					//service.shutdown();
					service.awaitTermination(5, TimeUnit.SECONDS);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		System.out.println("Exiting ...");
	}

	public static void testScheduleRepeatitiveTaskAtFixedInterval() {
		ScheduledExecutorService service = null;
		ScheduledFuture<?> future = null;
		try {
			service = Executors.newSingleThreadScheduledExecutor();
			future = service.scheduleWithFixedDelay(() -> {
				System.out.println("Task.." + System.currentTimeMillis());
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}, 0, 1, TimeUnit.MILLISECONDS);
		} finally {
			System.out.println("finally...");
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (null != service)
				service.shutdown();
		}
		System.out.println("Exiting...");
	}

	public static void testConcurrencyWithFixedThreadPool() {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(2);
			Callable<String> task = null;
			Collection<Callable<String>> taskList = new ArrayList<Callable<String>>();
			for (int j = 0; j < 20; j++) {
				task = () -> {
					for (int i = 0; i < 10000; i++) {
					}
					System.out.println("Task "
							+ Thread.currentThread().getName());
					return "";
				};
				taskList.add(task);
			}

			try {
				service.invokeAll(taskList);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} finally {
			if (null != service)
				service.shutdown();
		}
	}

	public static void testConcurrencyWithCachedThreadPool() {
		ExecutorService service = null;
		
		System.out.println();
		try {
			service = Executors.newCachedThreadPool();
			Callable<String> task = null;
			Collection<Callable<String>> taskList = new ArrayList<Callable<String>>();
			for (int j = 0; j < 20; j++) {
				task = () -> {
					for (int i = 0; i < 10000; i++) {
					}
					System.out.println("Task "
							+ Thread.currentThread().getName());
					return "";
				};
				taskList.add(task);
			}

			try {
				service.invokeAll(taskList);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} finally {
			if (null != service)
				service.shutdown();
		}
	}

	public static void testSynschronization() {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(4);
			for (int i = 0; i < 500; i++) {
				service.submit(new RunnableCountExample());
			}

		} finally {
			System.out.println("finally...");
			if (null != service) {
				service.shutdown();
			}
			try {
				service.awaitTermination(20, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("exiting...");
		SingleTone s = SingleTone.getInstance();
		for (int i = 0; i < 500; i++) {
			if (!s.listCount.contains(i))
				System.out.print(i + " ");
		}
		System.out.println("");
		for (int i = 0; i < 500; i++) {
			if (!s.listAtomicCount.contains(i))
				System.out.print(i + " ");
		}
	}
}

class Temp {
	private int count = 0;

	public void incrementAndPrint() {
		System.out.println(Thread.currentThread().getName() + ":" + ++count);
	}
}

class SingleTone {
	private int count = 0;
	public ArrayList<Integer> listCount = new ArrayList<Integer>();
	public ArrayList<Integer> listAtomicCount = new ArrayList<Integer>();

	private AtomicInteger atomicCounter = new AtomicInteger(0);

	public void incrementAtomicCounterAndPrint() {
		listAtomicCount.add(new Integer(atomicCounter.incrementAndGet()));
	}

	public void incrementCounterAndPrint() {
		listCount.add(new Integer(++count));
	}

	private static volatile SingleTone instance = null;

	private SingleTone() {

	}

	public static SingleTone getInstance() {
		if (null == instance) {
			synchronized (SingleTone.class) {
				if (null == instance) {
					instance = new SingleTone();
				}
			}
		}
		return instance;
	}
}

class CallableExample implements Callable<Temp> {

	@Override
	public Temp call() throws Exception {
		System.out
				.println("Running call : " + Thread.currentThread().getName());
		return new Temp();
	}

}

class RunnableCountExample implements Runnable {

	@Override
	public void run() {
		SingleTone object = SingleTone.getInstance();
		object.incrementCounterAndPrint();
		object.incrementAtomicCounterAndPrint();
	}

}