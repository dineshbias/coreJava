/**
 * 
 */
package ocp.concurrency.service;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

/**
 * @author edinjos
 *
 */
public class TestConcurrentCollections {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//testConcurrentHashMap();
		//testConcurrentList();
		testSkipListCollections();
		//testConcurrentQueue();
		//testConcurrentDeque();
		//testBlockingQueue();
	}

	public static void testConcurrentHashMap() {
		java.util.Map<String, String> map = new ConcurrentHashMap<String, String>();
		map.put("1", "Apple");
		map.put("2", "Mango");
		map.put("3", "Banana");
		for (String key : map.keySet()) {
			System.out.println(map.get(key));
			map.remove("1");

		}

		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		for (Map.Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}

	public static void testConcurrentList() {
		java.util.List<String> list = new CopyOnWriteArrayList<String>();
		list.add("ABC");
		list.add("XYZ");
		list.add("ABC");
		list.add("XYZ");
		for (String element : list) {
			list.remove("ABC");
			list.remove("XYZ");
			System.out.print(element + " ");
		}
		System.out.println();
		for (String element : list) {

			System.out.print(element);
		}

		System.out.println();

		java.util.Set<String> set = new CopyOnWriteArraySet<String>();
		set.add("ABC");
		set.add("XYZ");
		set.add("ABC");
		set.add("XYZ");
		for (String element : set) {
			set.remove("XYZ");
			System.out.println(element);
		}
	}

	public static void testBlockingQueue() {
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();
		try {
			queue.offer("ABC", 1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		queue.add("PQR");
		queue.add("XYZ");
		for ( ;queue.size()>0;) {
			System.out.print(queue.size()+" ");
			System.out.print(queue.poll()+"\n");
		}
	}
	
	public static void testBlockingDeQueue() {
		LinkedBlockingDeque<String> queue = new LinkedBlockingDeque();
				
		try {
			queue.offer("ABC", 1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Object o;
		}
		queue.add("PQR");
		queue.add("XYZ");
		for ( ;queue.size()>0;) {
			System.out.print(queue.size()+" ");
			System.out.print(queue.poll()+"\n");
		}
	}
	
	public static void testSkipListCollections() {
		Set<String> concurrentSortedSet = new ConcurrentSkipListSet<String>();
		concurrentSortedSet.add("one");
		concurrentSortedSet.add("two");
		concurrentSortedSet.add("three");
		concurrentSortedSet.add("ONE");
		concurrentSortedSet.add("TWO");
		concurrentSortedSet.add("THREE");
		concurrentSortedSet.add("one");
		concurrentSortedSet.add("two");
		concurrentSortedSet.add("three");
		concurrentSortedSet.add("ONE");
		concurrentSortedSet.add("TWO");
		concurrentSortedSet.add("THREE");

		concurrentSortedSet.forEach(System.out::println);

		Map<String, String> concurrentSortedMap = new ConcurrentSkipListMap<String, String>();
		concurrentSortedMap.put("1", "ONE");
		concurrentSortedMap.put("o", "ooo");
		concurrentSortedMap.put("3", "Three");
		concurrentSortedMap.put("O", "OOOO");
		concurrentSortedMap.put("1", "ONE");
		concurrentSortedMap.put("o", "ooo");
		concurrentSortedMap.put("3", "Three");
		concurrentSortedMap.put("O", "OOOO");

		BiConsumer<String, String> biConsumer = (String s1, String s2) -> {
			System.out.println(s1 + " " + s2);
		};
		concurrentSortedMap.forEach(biConsumer);
	}

	public static void testConcurrentDeque() {
		Deque<String> queue = new ConcurrentLinkedDeque<String>();
		queue.add("1");
		queue.add("2");
		queue.add("3");
		queue.add("4");
		for (String s : queue) {

			System.out.println("Size:" + queue.size() + "---" + queue.peek()
					+ "---" + queue.peekLast());
			queue.remove("4");
		}

		System.out.println("Starting");
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(5);

			service.submit(() -> {
				for (int i = 0; i <= 50; i++) {

					if (i == 10 || i == 20 || i == 30 || i == 40 || i == 50) {
						queue.offerFirst("" + i);
						continue;
					}
					queue.offer("" + i);
				}

			});

			service.submit(() -> {
				for (int i = 51; i <= 100; i++) {

					if (i == 60 || i == 70 || i == 80 || i == 90 || i == 100) {
						queue.add("" + i);
						continue;
					}
					queue.offerLast("" + i);
				}

			});

			service.submit(() -> {
				for (int i = 0; i <= 100; i++) {
					System.out.println("Remove " + queue.pop());
				}
			});

		} finally {
			if (null != service)
				service.shutdown();
		}
		System.out.println("Exiting");
	}

	public static void testConcurrentQueue() {

		Queue<String> queue = new ConcurrentLinkedQueue<String>();
		
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(5);

			service.submit(() -> {
				for (int i = 0; i < 20; i++) {
					System.out.println("Added String:" + i);
					queue.offer("String:" + i);
					try {
						Thread.sleep(20);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				;
			});

			service.submit(() -> {
				for (int i = 0; i < 20; i++) {
					System.out.println("Removed:" + queue.poll());
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				;
			});

			LinkedList<String> linkedList = new LinkedList<String>();

		} finally {
			System.out.println("Finally.. ");
			System.out.println(queue.size());
			if (null != service)
				service.shutdown();
		}

		System.out.println("Exiting.. ");
	}

	public static volatile int i;

	public static void testNonConcurrentQueue() {

		Queue<String> queue = new LinkedList<String>();

		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(5);

			service.submit(() -> {
				for (; i < 100; i++) {
					System.out.println("Added String:  " + i);
					queue.offer("String:" + i);
					try {
						Thread.sleep(20);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				;
			});

			service.submit(() -> {
				for (; i < 100; i++) {
					System.out.println("Added String:  " + i);
					queue.offer("String:" + i);
					try {
						Thread.sleep(20);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				;
			});

			service.submit(() -> {
				for (int j = 0; j < 100; j++) {
					System.out.println("Removed:    " + queue.poll());
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				;
			});

			service.submit(() -> {
				for (int j = 0; j < 100; j++) {
					System.out.println("Removed:    " + queue.poll());
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				;
			});

		} finally {
			System.out.println("Finally.. ");
			System.out.println(queue.size());
			if (null != service)
				service.shutdown();
		}

		System.out.println("Exiting.. ");
	}
}
