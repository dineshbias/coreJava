/**
 * 
 */
package ocp.concurrency.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author edinjos
 *
 */
public class TestParallelStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// createParallelStream();
		// testPerformanceLimits();
		//testReduceTerminalOperationWithParallelStream();
		testCollectTerminalOperationWithParallelStream();

	}

	public static void createParallelStream() {

		// From Serial Stream
		Stream<Integer> s = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).stream();
		s.forEach(e -> System.out.print(e + " "));
		System.out.println();
		s = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).stream();
		s.parallel().forEach(e -> {
			System.out.print(e + " ");
		});

		// From collections
		LinkedList<String> list = new LinkedList<String>();
		list.offer("ABC");
		list.offer("FGH");
		list.offer("PQR");
		list.offer("XYZ");
		System.out.println();
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");
		System.out.println("***************");
		list.parallelStream().forEach(
				e -> System.out.print(Thread.currentThread().getName() + ":"
						+ e + " "));

		// Forcing parallel stream to be processed as serial stream.
		System.out.println();
		list.parallelStream().forEachOrdered(
				e -> System.out.print(Thread.currentThread().getName() + ":"
						+ e + " "));

		System.out.println();
		list.parallelStream()
				.unordered()
				.forEach(
						e -> System.out.print(Thread.currentThread().getName()
								+ ":" + e + " "));

	}

	public static void testPerformanceLimits() {
		WhaleDataCalculator calculator = new WhaleDataCalculator();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 100_00_000; i++)
			list.add(i);

		long start = System.currentTimeMillis();
		calculator.processAllDataParallelStream(list);
		System.out.println("Time taken with Parallel Stream :"
				+ (System.currentTimeMillis() - start) / 1000);

		start = System.currentTimeMillis();
		calculator.processAllDataSerialStream(list);
		System.out.println("Time taken with Serial Stream :"
				+ (System.currentTimeMillis() - start) / 1000);

	}

	public static void testReduceTerminalOperationWithParallelStream() {

		List<Character> characterList = Arrays.asList('a', 'b', 'c', 'd', 'e',
				'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
				'r', '1', '2', '3', '4', '5', '6', '7', '8', '9');

		// Serial Stream.
		Stream<Character> stream = characterList.stream();
		String s = stream.reduce("", (c, s1) -> c + s1, (s2, s3) -> s2 + s3);
		System.out.println(s);

		// Parallel Stream
		Stream<Character> stream2 = characterList.parallelStream();
		s = stream2.reduce("", (c, s1) -> c + s1, (s2, s3) -> s2 + s3);
		System.out.println(s);

	}

	public static void testCollectTerminalOperationWithParallelStream() {
		Stream<String> stream = Stream.of("w", "o", "l", "f", "w", "o", "l",
				"f").parallel();
		TreeSet<String> treeSet = stream.collect(TreeSet::new, TreeSet::add,
				TreeSet::addAll);
		System.out.println(treeSet);

		// Using the one argument collect method.
		stream = Stream.of("lions", "tigers", "beers", "owl", "monkey");

		Collector<String, ?, Map<Integer, String>> c = Collectors.toMap(
				String::length, k -> k, (s1, s2) -> s1 + "," + s2);
		
		System.out.println(" ");
		for (Characteristics ch : c.characteristics())
			System.out.print(ch + " ");
		System.out.println("--------- ");
		java.util.Map<Integer, String> map = stream.collect(c);
		System.out.println(map);

		stream = Stream.of("lions", "tigers", "beers", "owl", "monkey")
				.parallel();
		Collector<String, ?, ConcurrentMap<Integer, String>> collectorMap = Collectors
				.toConcurrentMap(String::length, k -> k, (s1, s2) -> s1 + ","
						+ s2);

		for (Characteristics ch : collectorMap.characteristics())
			System.out.print(ch + "*");

		map = stream.collect(c);
		System.out.println(map);

		stream = Stream.of("lions", "tigers", "beers", "owl", "monkey")
				.parallel();
		Collector<String, ?, ConcurrentMap<Integer, List<String>>> cGrouping = Collectors
				.groupingByConcurrent(String::length);
		for (Characteristics ch : cGrouping.characteristics())
			System.out.print(ch + " ");
		ConcurrentMap<Integer, List<String>> mapList = stream
				.collect(cGrouping);
		System.out.println(mapList);
	}
}

class WhaleDataCalculator {

	public int processRecord(int input) {

		// System.out.println("Sleeping " +
		// Thread.currentThread().getName());
		// Thread.sleep(10);

		return input + 1;
	}

	public void processAllDataSerialStream(List<Integer> data) {
		Stream<Integer> s = data.stream().map(a -> processRecord(a));
		System.out.println("Elements on stream : " + s.count());
	}

	public void processAllDataParallelStream(List<Integer> data) {
		Stream<Integer> s = data.parallelStream().map(a -> processRecord(a));
		System.out.println("Elements on stream : " + s.count());
	}
}