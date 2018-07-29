/**
 * 
 */
package ocp.functional;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author edinjos
 *
 */

public class TestBuiltInFunctionalInterfaces {

	public static void main(String... strings) {
		// testSample();

		// testLambdaAndVariables();
		testFunctionalInterfaces();
		// testOptional();
		// testTerminalOperation();
		// testIntermediateOperation();
		// testPrimitiveStreams();
		Integer i;
		// testAdvancedStreamConcepts();
		testCollectingResultsPredefinedCollectors();

	}

	private static void magic(Stream<Integer> s) {
		Optional o = s.limit(5).max((x, y) -> x - y);
		// Optional o = s.filter(x -> x < 5).max((x, y) -> x - y);
		System.out.println(o.get());

	}

	public static void testSample() {
		magic(Stream.of(5, 10));
		magic(Stream.iterate(1, x -> x++));
		magic(Stream.empty());

		Path userDirectory = Paths.get("/coralreef/../clown/fish").normalize(); // m1
		System.out.println("userDirectory " + userDirectory);
		System.out.println("Parent directory " + userDirectory.getParent());
		System.out.println("Root directory " + userDirectory.getRoot());
		System.out.println("Parent root directory " + userDirectory.getRoot().getParent());

		System.out.println("*********");

		userDirectory = Paths.get("coralreef/../clown/fish").normalize(); // m1
		System.out.println("userDirectory " + userDirectory);
		System.out.println("Parent directory " + userDirectory.getParent());
		System.out.println("Root directory " + userDirectory.toAbsolutePath().getRoot());
		System.out.println("Root directory " + userDirectory.getRoot());
		System.out.println("Parent root directory " + userDirectory.toAbsolutePath().getRoot().getParent());

		ExecutorService service = Executors.newSingleThreadExecutor();
		IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).parallel() // z1
				.forEachOrdered(c -> service.submit( // z2
						() -> System.out.println(10 * c))); // z3
		service.submit(() -> System.out.println("Complete!")); // z4
		service.shutdown();

		Properties p = new Properties();
		p.put("A", "Apple");
		p.put("B", "Banana");
		Set keySet = p.keySet();
		for (Object s : keySet) {
			System.out.println(s + " " + p.get(s));
		}

		List<Integer> l1 = Arrays.asList();
		List<Integer> l2 = Arrays.asList(1, 2, 3);
		List<Integer> l3 = Arrays.asList(4, 5, 6);

		Stream.of(l1, l2, l3).limit(2).peek(System.out::println) // peek 1
				.flatMap(x -> x.stream()).peek(System.out::println) // peek 2
				.map(x -> x + 1).count();

		throw new Error();
	}

	public static void testTerminalOperation() {
		// Creating Finite Streams
		Stream<String> emptyStream = Stream.empty();

		java.util.List<String> list = Arrays.asList("Dog", "Cat", "Rabbit", "Cow", "kangaroo");
		Stream<String> finiteStreamFromList = list.stream();
		Stream<String> finiteStreamFromList2 = list.stream();
		Stream<String> finiteStreamFromList3 = list.stream();

		// Creating finite Parallel Stream
		Stream<String> finiteParallelStreamFromList = list.parallelStream();
		Stream<String> finiteParallelStreamFromList2 = list.parallelStream();

		// Creating Infinite Streams
		Stream<Double> infiniteStreamForDouble = Stream.generate(() -> Math.random());
		Stream<Integer> randoms = Stream.iterate("".length(), n -> n + 2);

		// Terminal Operations on finite and infinite Streams
		System.out.println("counting number of elements in finite stream:" + emptyStream.count());
		// System.out.println("Counting number of elements in infinite stream:"
		// + infiniteStreamForDouble.count() + " " + randoms.count());
		Stream<Integer> finiteStreamFromArray = Stream.of(1, 2, 3, 4, 5);
		Optional<Integer> min = finiteStreamFromArray.min((a, b) -> a - b);
		System.out.println("min " + min.get());

		Optional<String> s = finiteStreamFromList.max((a, b) -> a.length() - b.length());
		System.out.println("max " + s.orElse(""));

		System.out.println("findFirst " + finiteStreamFromList2.findFirst().get() + " findAny "
				+ finiteStreamFromList3.findAny().get());
		System.out.println("findFirst parallel " + finiteParallelStreamFromList.findFirst().get() + " findAny parallel "
				+ finiteParallelStreamFromList2.findAny().get());
		System.out.println("findAny infinite " + randoms.findAny().get());
		emptyStream = Stream.empty();
		emptyStream.findAny().ifPresent(System.out::println);

		Stream<Item> finiteStreamOfObjects = Stream.of(new Item("Biscuit", 10.5, 1), new Item("Soap", 15, 2),
				new Item("TootahBrush", 30, 3), new Item("Biscuit", 25, 1));
		Predicate<Item> predicate = i -> i.getItemCode() == 1;
		System.out.println("All Match :" + finiteStreamOfObjects.allMatch(predicate));

		finiteStreamOfObjects = Stream.of(new Item("Biscuit", 10.5, 1), new Item("Soap", 15, 2),
				new Item("TootahBrush", 30, 3), new Item("Biscuit", 25, 1));
		System.out.println("Any Match :" + finiteStreamOfObjects.anyMatch((i) -> i.getItemCode() == 3));

		finiteStreamOfObjects = Stream.of(new Item("Biscuit", 10.5, 1), new Item("Soap", 15, 2),
				new Item("TootahBrush", 30, 3), new Item("Biscuit", 25, 1));
		System.out.println("None Match :" + finiteStreamOfObjects.noneMatch((i2) -> i2.getItemCode() == 9));

		finiteStreamOfObjects = Stream.of(new Item("Biscuit", 10.5, 1), new Item("Soap", 15, 2),
				new Item("TootahBrush", 30, 3), new Item("Biscuit", 25, 1));
		finiteStreamOfObjects.forEach((ss) -> System.out.print(" " + ss));

		finiteStreamFromList = Stream.of("D", "I", "N", "E", "S", "H");
		System.out.println("\n" + finiteStreamFromList.reduce("", (a, b) -> a + b));

		finiteStreamFromArray = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		finiteStreamFromArray.reduce((c, d) -> c + d).ifPresent(System.out::println);

		finiteStreamFromArray = Stream.of(1, 2, 3, 4);
		finiteStreamFromArray.reduce((c, d) -> c * d).ifPresent(System.out::println);

		List<Integer> lIntenger = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Stream<Integer> finiteIntegerParallelStream = lIntenger.parallelStream();
		System.out.println(finiteIntegerParallelStream.reduce(0, (c, d) -> c + d, (c, d) -> c + d));

		String[] strArray = { "abc", "mno", "xyz", "pqr", "lmn" };
		List<String> strList = Arrays.asList(strArray);

		System.out.println("stream test");
		int streamResult = strList.stream().reduce(0, (total, s1) -> {
			System.out.println(
					"accumulator: total[" + total + "] s1[" + s1 + "] s1.codePointAt(0)[" + s1.codePointAt(0) + "]");
			return total + s1.codePointAt(0);
		}, (a, b) -> {
			System.out.println("combiner: a[" + a + "] b[" + b + "]");
			return 1000000;
		});
		System.out.println("streamResult: " + streamResult);

		System.out.println("parallelStream test");
		int parallelStreamResult = strList.parallelStream().reduce(0, (total, s2) -> {
			System.out.println(
					"accumulator: total[" + total + "] s2[" + s2 + "] s2.codePointAt(0)[" + s2.codePointAt(0) + "]");
			return total + s2.codePointAt(0);
		}, (a, b) -> {
			System.out.println("combiner: a[" + a + "] b[" + b + "]");
			return a + b;
		});
		System.out.println("parallelStreamResult: " + parallelStreamResult);

		testTerminalOperationCollect();
	}

	public static void testTerminalOperationCollect() {
		Stream<Integer> finiteStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3,
				4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Averager a = finiteStream.collect(Averager::new, Averager::accept, Averager::combiner);
		System.out.println("Average " + a.average());

		Stream<String> testStream = Stream.of("w", "o", "l", "f");
		StringBuilder builder = testStream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		System.out.println(builder);

		testStream = Stream.of("w", "o", "l", "f");
		TreeSet<String> set = testStream.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
		System.out.println(set);

		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		Stream<Integer> testInegerStream = list.parallelStream();
		Averager x = testInegerStream.collect(Averager::new, Averager::accept, Averager::combiner);
		System.out.println(x.average());

		testStream = Stream.of("D", "I", "N", "E", "S", "H");
		ArrayList<String> arrayList = testStream.collect(Collectors.toCollection(ArrayList::new));
		System.out.println(arrayList);

		testStream = Stream.of("D", "I", "N", "E", "S", "H");
		TreeSet<String> tree = testStream.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(tree);

		testStream = Stream.of("D", "I", "N", "E", "S", "H");
		HashSet<String> hashSet = testStream.collect(Collectors.toCollection(HashSet::new));
		System.out.println(hashSet);

		testStream = Stream.of("D", "I", "N", "E", "S", "H");
		Set<String> treeSet = testStream.collect(Collectors.toSet());
		System.out.println(treeSet);

	}

	public static void testIntermediateOperation() {
		Stream<String> finiteStreamOfStrings = Stream.of("Dinesh", "Ramesh", "Umesh", "Anoop", "Dinker");
		Predicate<String> filter = (s) -> s.startsWith("Di");
		Stream<String> intermediateStream = finiteStreamOfStrings.filter(filter); // intermediate
																					// Operation

		intermediateStream.forEach(System.out::println); // Terminal Operation

		Stream<Item> finiteStreamOfObjects = Stream.of(new Item("Biscuit", 10.5, 1), new Item("Soap", 15, 2),
				new Item("Biscuit", 30, 1), new Item("Biscuit", 25, 1));
		Stream<Item> distinctObjects = finiteStreamOfObjects.distinct(); // intermediate
																			// operation
		System.out.println("Distinct :" + distinctObjects.count());

		Stream<Integer> infiniteStream = Stream.iterate(10, n -> n + 2);
		infiniteStream.limit(5).forEach(System.out::println); // intermediateOperation
																// limit

		infiniteStream = Stream.iterate(10, n -> n + 2);
		infiniteStream.limit(115).skip(112).forEach(System.out::println);
		;

		finiteStreamOfStrings = Stream.of("Dinesh", "Ramesh", "Umesh", "Anoop", "Dinker");
		Stream<Integer> lenthStream = finiteStreamOfStrings.map(String::length);

		lenthStream.forEach(System.out::println);

		List<String> l1 = Arrays.asList("Deer", "Kangaroo");
		List<String> l2 = new ArrayList<String>();
		List<String> l3 = Arrays.asList("Mango", "Banana", "Apple");
		Stream<List<String>> finiteStreamList = Stream.of(l1, l2, l3);
		Stream<List<String>> finiteStreamList1 = Stream.of(l1, l2, l3);
		System.out.println("finiteStreamList1 count " + finiteStreamList1.count());
		Stream<String> temp = finiteStreamList.flatMap(l -> l.stream());

		// System.out.println("temp count " + temp2.count());
		temp.forEach(System.out::println);// intermediate
											// operation
											// flatmap

		finiteStreamOfStrings = Stream.of("Dinesh", "Ramesh", "Umesh", "Anoop", "2Dinker", "dinesh");
		finiteStreamOfStrings.sorted().forEach(System.out::println); // Intermediate
																		// operation
																		// sorted
																		// using
																		// natural
																		// ordering.

		finiteStreamOfObjects = Stream.of(new Item("Biscuit", 10.5, 1), new Item("Soap", 15, 2), new Item("Oil", 30, 1),
				new Item("Biscuit", 25, 1));
		finiteStreamOfObjects.sorted((i1, i2) -> {
			return new Double(i1.getMoney() - i2.getMoney()).intValue();
		}).forEach(System.out::println); // Intermediate operation sort using
											// comparater

		finiteStreamOfStrings = Stream.of("Dinesh", "Ramesh", "Umesh", "Anoop", "Dinker");
		long c = finiteStreamOfStrings.peek(System.out::println).count(); // Peek
																			// with
																			// terminal
																			// operation
		System.out.println(c);
		finiteStreamOfStrings = Stream.of("Dinesh", "Ramesh", "Umesh", "Anoop", "Dinker");
		long count = finiteStreamOfStrings.filter(s -> s.contains("es")).peek(System.out::println).count();

		System.out.println("count:" + count);
		finiteStreamOfStrings = Stream.of("Dinesh", "Ramesh", "Umesh", "Anoop", "Dinker");
		finiteStreamOfStrings.peek(System.out::println).skip(4).forEach(System.out::println); // Peek
																								// with
																								// intermediate
																								// and
																								// Terminal
																								// operation

		List<String> stringList = Arrays.asList("1", "1", "2", "3", "4");

		stringList.stream().limit(2).peek(System.out::println);

		List<Integer> numbers = new ArrayList<Integer>();
		List<Character> chars = new ArrayList<Character>();
		numbers.add(1);
		chars.add('a');

		Stream<List<?>> mixedFiniteStream = Stream.of(numbers, chars);
		mixedFiniteStream.peek(l -> l.remove(0)).forEach(System.out::println); // Bad
																				// use
																				// of
																				// peek
	}

	public static void testOptional() {
		Optional<Double> opt1 = Operation.average();
		System.out.println(opt1.orElse((double) 0));
		System.out.println(opt1.orElseGet(() -> Math.random()));

		Optional<Double> opt2 = Operation.average(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		opt2.ifPresent(System.out::println);
		opt2.ifPresent((s) -> System.out.println(s));

		Optional<Double> opt3 = Optional.empty();
		try {
			System.out.println(opt3.orElseThrow(Exception::new));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Tests what all variables are accessible in a Lambda expression
	 */
	public static void testLambdaAndVariables() {
		GorillaFamily g = new GorillaFamily();
		g.everyonePlay(true);
	}

	/*
	 * Test Built in Functional Interfaces
	 */
	public static void testFunctionalInterfaces() {

		// Test Supplier for LocalDate and ArrayList
		Supplier<LocalDate> s1 = LocalDate::now; // Method Refrence
		Supplier<LocalDate> s2 = () -> LocalDate.now(); // Lambda expression
		System.out.println(s1 + " " + s1.get());
		System.out.println(s2 + " " + s2.get());
		System.out.println(LocalDate.now());

		Supplier<ArrayList<String>> sList = ArrayList<String>::new; // Constructor
																	// method
																	// Refrences.
		Supplier<ArrayList<String>> sList2 = () -> new ArrayList<String>();
		System.out.println(sList.get() + " " + sList2.get());

		// Consumer and BiConsumer
		Consumer<String> c1 = System.out::println; // Method refrence
		c1.accept("Consumer Dinesh");
		Consumer<String> c2 = s -> System.out.println(s);
		c2.accept("This is a test consumer");

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		BiConsumer<String, Integer> bConsumer = map::put; // instance methods
															// refrence
		bConsumer.accept("Dinesh", 1);
		bConsumer.accept("Ramesh", 2);
		System.out.println(map);

		// Predicate and BiPredicate
		Predicate<String> p1 = String::isEmpty;
		Predicate<String> p2 = s -> s.isEmpty();
		System.out.println("Is empty p1" + p1.test(""));
		System.out.println("Is empty p2" + p2.test("Dinesh"));

		BiPredicate<String, String> bPredicate1 = String::startsWith;
		BiPredicate<String, String> bPredicate2 = (ss1, ss2) -> ss1.startsWith(ss2);

		System.out.println(bPredicate1.test("Dinesh", "Din"));
		System.out.println(bPredicate2.test("Din", "Dinesh"));

		// Function and BiFunction
		Function<String, Integer> f1 = s -> s.length();
		Function<String, Integer> f2 = String::length;
		System.out.println(f1.apply("This is a test String"));
		System.out.println(f2.apply("Sachin"));

		BiFunction<String, Integer, String> bFunction1 = String::substring;
		BiFunction<String, Integer, String> bFunction2 = (ss1, ss2) -> ss1.substring(ss2);
		System.out.println(bFunction1.apply("I am loving it", 2));
		System.out.println(bFunction2.apply("Good Bye", 5));

		Consumer<String> c = System.out::println;
		c.accept("Consumer and BiFunction :" + bFunction2.apply("Good Bye", 5));
		// Unary and Binary Operator
		UnaryOperator<String> u1 = String::toUpperCase;
		UnaryOperator<String> u2 = s -> s.toLowerCase();
		System.out.println(u1.apply("I am loving it"));
		System.out.println(u2.apply(u1.apply("I am loving it")));

		BinaryOperator<Integer> addition = (a, b) -> a + b;
		BinaryOperator<Integer> multiplication = (a, b) -> a + b;
		System.out.println("Addition " + addition.apply(2, 5));
		System.out.println("Multiplication " + multiplication.apply(10, 5));
	}

	public static void testPrimitiveStreams() {

		// Int Stream
		Stream<String> stream = Stream.empty();
		IntStream is = stream.mapToInt(Integer::parseInt);

		IntStream intStream = IntStream.empty(); // Creating empty IntStream
		System.out.println("reduce : " + intStream.reduce(0, (a, b) -> a + b));

		intStream = IntStream.of(1, 2, 3, 4); // Creating IntStream from Array
		intStream.forEach(System.out::println);

		IntSupplier intSupplier = () -> 3;
		intStream = IntStream.generate(intSupplier); // generating infinite
														// IntStream
		intStream.limit(10).average().ifPresent(System.out::println);

		intStream = IntStream.iterate(0, n -> n + 2); // generating infinite
														// IntStream
		System.out.println("Sum :" + intStream.limit(10).skip(5).sum());

		Stream<Integer> s = Stream.of(1, 2, 3);
		intStream = s.mapToInt(x -> x);
		OptionalDouble avg = intStream.average();
		System.out.println("Int Average:" + avg.orElse(0.0));
		s = Stream.of(1, 2, 3);
		intStream = s.mapToInt(x -> x);
		System.out.println("Int Sum: " + intStream.sum());

		intStream = IntStream.of(1, 2, 3);
		DoubleStream doubleStream = intStream.mapToDouble(d -> d);
		System.out.println("Int to Double Sum: " + doubleStream.sum());

		intStream = IntStream.range(1, 50);
		intStream.forEach(System.out::print);

		intStream = IntStream.of(1, 2, 3);
		LongStream longStream = intStream.mapToLong(l -> l);
		System.out.println("Int to Long Sum: " + longStream.sum());

		// intStream = IntStream.generate(paramIntSupplier);

		// Double Stream
		Stream<Double> sDouble = Stream.of(1.1, 2.7, 3.6);
		doubleStream = sDouble.mapToDouble(x -> x);
		System.out.println("Double Max:" + doubleStream.max().getAsDouble());

		// Using statistics
		intStream = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		IntSummaryStatistics statistics = intStream.summaryStatistics();
		System.out.println("Average:" + statistics.getAverage() + " Count:" + statistics.getCount() + " Max:"
				+ statistics.getMax() + " Min:" + statistics.getMin() + " Sum:" + statistics.getSum());

	}

	public static void testAdvancedStreamConcepts() {
		List<String> list = new ArrayList<String>();
		list.add("Apple");
		Stream<String> listStream = list.stream();
		list.add("WaterMelon");
		list.add("Papaya");
		listStream.forEach(System.out::println);
		list.add("Banana");
		threeDigitWithoutFunctionalProgramming(Optional.empty());
		threeDigitWithoutFunctionalProgramming(Optional.of(0));
		threeDigitWithoutFunctionalProgramming(Optional.of(325245245));
		threeDigitWithoutFunctionalProgramming(Optional.of(123));
		threeDigitWithFunctionalProgramming(Optional.empty());
		threeDigitWithFunctionalProgramming(Optional.of(0));
		threeDigitWithFunctionalProgramming(Optional.of(325245245));
		threeDigitWithFunctionalProgramming(Optional.of(123));

	}

	public static void testCollectingResultsPredefinedCollectors() {
		Stream<String> finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys");

		// Convert a Stream of Strings in a Single String
		// 1. By using reduce function
		String s = finiteStreamOfStrings.reduce("", (a, b) -> a + b + ",");
		s = s.substring(0, s.lastIndexOf(","));
		System.out.println("reduction : " + s);

		// 2. By using predefined collector
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys");
		s = finiteStreamOfStrings.collect(Collectors.joining());
		System.out.println("predefined collector joining : " + s);

		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys");
		s = finiteStreamOfStrings.collect(Collectors.joining(","));
		System.out.println("predefined collector joining ,: " + s);

		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys");
		s = finiteStreamOfStrings.collect(Collectors.joining(",", "-", ":"));
		System.out.println("predefined collector joining ,: " + s);

		// Calculate average length for Strings present in a Stream.
		// 1. Using IntStream
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys");
		Stream<Integer> lenthOfStrings = finiteStreamOfStrings.map(String::length);
		IntStream intStream = lenthOfStrings.mapToInt(i -> i);
		System.out.println("IntStream Average: " + intStream.average().getAsDouble());

		// 2. Using predefined collector
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys");

		System.out.println(
				"Collector Average: " + finiteStreamOfStrings.collect(Collectors.averagingInt(String::length)));
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys");
		System.out.println(
				"Collector Average: " + finiteStreamOfStrings.collect(Collectors.averagingDouble(String::length)));
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys");
		System.out.println(
				"Collector Average: " + finiteStreamOfStrings.collect(Collectors.averagingLong(String::length)));

		// Converting Stream elements in a collection
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys");
		ArrayList<String> listFilteredStrings = finiteStreamOfStrings.filter(a -> a.endsWith("rs"))
				.collect(Collectors.toCollection(ArrayList::new));
		System.out.println(listFilteredStrings);

		Stream<Item> finiteStreamOfObjects = Stream.of(new Item("Biscuit", 10.5, 1), new Item("Soap", 15, 2),
				new Item("Biscuit", 30, 1), new Item("Biscuit", 25, 1));
		ArrayList<Item> listFilteredItems = finiteStreamOfObjects.filter(a -> a.getItemName().equals("Biscuit"))
				.collect(Collectors.toCollection(ArrayList::new));
		System.out.println(listFilteredItems);

		// Counting number Of elements in a Stream.
		// 1. Using Terminal Operation
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys");
		System.out.println("Finite Stream count : " + finiteStreamOfStrings.count());

		// 2. Using predefined collector
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys");
		System.out.println("Collector count : " + finiteStreamOfStrings.collect(Collectors.counting()));

		// Min element from Stream.
		// 1. Using Terminal operation
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys");
		System.out.println(finiteStreamOfStrings.min((s1, s2) -> s1.length() - s2.length()));

		// 2. Using predefined Collector
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys");

		Optional optional = finiteStreamOfStrings
				.collect(Collectors.minBy((String s1, String s2) -> s1.length() - s2.length()));
		System.out.println(optional + " " + optional.get());

		// Max element from Stream
		// 1. Using Terminal operation
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys");
		System.out.println(finiteStreamOfStrings.max((s1, s2) -> s1.length() - s2.length()));
		// 2. Using predefined Collector
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys");
		System.out.println(
				finiteStreamOfStrings.collect(Collectors.maxBy((String s1, String s2) -> s1.length() - s2.length())));

		// Sum
		// 1. mapToInput Sum
		Stream<Integer> finiteStreamOfIntegers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		System.out.println("mapTOInt Sum: " + finiteStreamOfIntegers.mapToInt(i -> i).sum());
		// 2. using collector
		finiteStreamOfIntegers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		System.out.println("collect Sum: " + finiteStreamOfIntegers.collect(Collectors.summingInt(i -> (Integer) i)));

		// Summarizing on integer content
		// 1. Using stream and summaryStatistics
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys");
		intStream = finiteStreamOfStrings.mapToInt(String::length);
		IntSummaryStatistics intSummaryStatistics = intStream.summaryStatistics();
		System.out.println("IntSummaryStatistics Average:" + intSummaryStatistics.getAverage() + " Count:"
				+ intSummaryStatistics.getCount() + " Max:" + intSummaryStatistics.getMax() + " min:"
				+ intSummaryStatistics.getMin() + " sum:" + intSummaryStatistics.getSum());

		// 2. Using collector.
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys");
		DoubleSummaryStatistics doubleSummaryStatistics = finiteStreamOfStrings
				.collect(Collectors.summarizingDouble(String::length));
		System.out.println("Average:" + doubleSummaryStatistics.getAverage() + " Count:"
				+ doubleSummaryStatistics.getCount() + " Max:" + doubleSummaryStatistics.getMax() + " min:"
				+ doubleSummaryStatistics.getMin() + " sum:" + doubleSummaryStatistics.getSum());

		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys");
		LongSummaryStatistics longSummaryStatistics = finiteStreamOfStrings
				.collect(Collectors.summarizingLong(String::length));
		System.out.println("Average:" + longSummaryStatistics.getAverage() + " Count:"
				+ longSummaryStatistics.getCount() + " Max:" + longSummaryStatistics.getMax() + " min:"
				+ longSummaryStatistics.getMin() + " sum:" + longSummaryStatistics.getSum());

		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys");
		intSummaryStatistics = finiteStreamOfStrings.collect(Collectors.summarizingInt(String::length));
		System.out.println("Average:" + intSummaryStatistics.getAverage() + " Count:" + intSummaryStatistics.getCount()
				+ " Max:" + intSummaryStatistics.getMax() + " min:" + intSummaryStatistics.getMin() + " sum:"
				+ intSummaryStatistics.getSum());

		// Collecting Stream elements in a List

		// 1. Using Collector
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys", "tigers");
		ArrayList<String> list = (ArrayList<String>) finiteStreamOfStrings.collect(Collectors.toList());
		System.out.println(list);

		// Collecting Stream elements in a Set

		// 1. Using Collector
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys", "tigers");
		HashSet<String> set = (HashSet<String>) finiteStreamOfStrings.collect(Collectors.toSet());
		System.out.println(set);

		// Collecting Stream elements in a Collection
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys", "tigers");
		list = finiteStreamOfStrings.collect(Collectors.toCollection(ArrayList::new));
		System.out.println(list);

		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys", "tigers");
		set = finiteStreamOfStrings.collect(Collectors.toCollection(HashSet::new));
		System.out.println(set);

		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys", "tigers");
		TreeSet<String> treeSet = finiteStreamOfStrings.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(treeSet);

		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys", "tigers");
		ArrayDeque<String> queue = finiteStreamOfStrings.collect(Collectors.toCollection(ArrayDeque::new));
		System.out.println(queue);

		// Collecting stream elements in a Hashmap
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys");
		Map<Object, Integer> map = finiteStreamOfStrings.collect(Collectors.toMap(ss -> ss, String::length));
		System.out.println(map);

		// Collecting stream elements in a Treemap
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys");
		TreeMap<Integer, String> treeMap1 = finiteStreamOfStrings
				.collect(Collectors.toMap(String::length, ss -> ss, (ss1, ss2) -> ss1 + "**" + ss2, TreeMap::new));
		System.out.println(treeMap1);

		// Collecting stream elements in a map .. when we have same keys
		// scenerio
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys");
		Map<Integer, String> map2 = finiteStreamOfStrings
				.collect(Collectors.toMap(String::length, ss -> ss, (String ss1, String ss2) -> ss1 + "," + ss2));
		System.out.println(map2);

		// Grouping elements of a Stream by length and getting a map of length
		// and corresponding list of stream elements.
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys", "lions");
		Map<Integer, List<String>> map3 = finiteStreamOfStrings.collect(Collectors.groupingBy(String::length));
		System.out.println(map3);

		// Grouping elements of a Stream by length and getting a map of length
		// and corresponding set of stream elements in a HashMap.
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys", "lions");
		HashMap<Integer, Set<String>> map4 = (HashMap<Integer, Set<String>>) finiteStreamOfStrings
				.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
		System.out.println(map4);

		// Grouping elements of a Stream by length and corresponding Set of
		// elements in a TreeMap
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys", "lions");
		TreeMap<Integer, Set<String>> map5 = finiteStreamOfStrings
				.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
		System.out.println(map5);

		// Grouping elements of a stream by length and corresponding count of
		// elements in a HashMap
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys", "lions");
		HashMap<Integer, Long> map6 = (HashMap<Integer, Long>) finiteStreamOfStrings
				.collect(Collectors.groupingBy(String::length, Collectors.counting()));
		System.out.println(map6);

		// Partitioning based on length of elements of the Stream
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys", "lions");
		Map<Boolean, List<String>> partition = finiteStreamOfStrings
				.collect(Collectors.partitioningBy(sss -> sss.length() <= 5));
		System.out.println(partition);
		System.out.println(partition.getClass());

		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys", "lions");
		Map<Boolean, TreeSet<String>> partition2 = finiteStreamOfStrings
				.collect(Collectors.partitioningBy(sss -> sss.length() < 7, Collectors.toCollection(TreeSet::new)));
		System.out.println(partition2);
		System.out.println(partition2.getClass());

		// Mapping
		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys", "lions");
		Optional opt = finiteStreamOfStrings
				.collect(Collectors.mapping(ss -> ss.charAt(0), Collectors.minBy(Comparator.naturalOrder())));
		System.out.println(opt + " " + opt.get());

		finiteStreamOfStrings = Stream.of("lions", "tigers", "beers", "monkeys", "lions");
		Map<Integer, Optional<Character>> map8 = finiteStreamOfStrings.collect(Collectors.groupingBy(String::length,
				Collectors.mapping(ss -> ss.charAt(0), Collectors.minBy(Comparator.naturalOrder()))));

		System.out.println(map8);

	}

	public static void threeDigitWithoutFunctionalProgramming(Optional<Integer> optInteger) {
		System.out.print(" " + optInteger.isPresent());
		if (optInteger.isPresent()) {

			Integer num = optInteger.get();
			String s = "";
			s = s + num;
			if (s.length() == 3) {
				System.out.println(num);
			}
		}
	}

	public static void threeDigitWithFunctionalProgramming(Optional<Integer> optInteger) {
		System.out.print(" " + optInteger.isPresent());
		optInteger.map(n -> n + "").filter(s -> s.length() == 3).ifPresent(System.out::println);
		;
	}
}

abstract interface Gorilla {
	public abstract String move();

}

class GorillaFamily {
	private static String title = "Class Family";
	private String name = "Local Gorilla";

	public void everyonePlay(boolean baby) {
		String approach = "amble";
		play(() -> title);// access to class variables
		play(() -> name); // access to instance variables
		play(() -> baby ? "BABY" : "GROWNUP"); // access to passed variable
		play(() -> approach); // access to local variables

	}

	/*
	 * Takes
	 */
	void play(Gorilla g) {
		System.out.println(g.move());
	}
}

class Operation {

	public static Optional<Double> average(int... numbers) {

		if (numbers.length == 0)
			return Optional.empty();

		int sum = 0;
		for (int number : numbers)
			sum += number;
		return Optional.ofNullable((double) (sum / numbers.length));

	}
}

class Item {

	private String itemName;
	private double money;
	private int itemCode;

	public Item(String itemName, double money, int itemCode) {
		this.itemName = itemName;
		this.money = money;
		this.itemCode = itemCode;
	}

	public int getItemCode() {
		System.out.print(itemCode + " ");
		return itemCode;
	}

	public String getItemName() {
		System.out.print(itemName + " ");
		return itemName;
	}

	public double getMoney() {
		System.out.print(money + " ");
		return money;
	}

	@Override
	public String toString() {
		return itemName;
	}

	@Override
	public boolean equals(Object paramObject) {
		System.out.println("Inside equals");
		if (null == paramObject || !(paramObject.getClass().equals(this.getClass())))
			return false;
		if (this == paramObject)
			return true;
		Item other = (Item) paramObject;
		return this.itemCode == other.itemCode;
	}

	@Override
	public int hashCode() {
		System.out.println("Inside hashCode");
		return itemCode;
	}
}

class Averager {
	private int total = 0;
	private int count = 0;

	Averager() {
		System.out.println("Averager constructed");
	}

	public double average() {
		System.out.println("Inside average");
		return count > 0 ? total / count : 0;
	}

	public void accept(int i) {
		System.out.println(this + " Accept : " + total + " count : " + count);
		total += i;
		count++;
	}

	public void combiner(Averager a) {
		System.out.println(this + " Combiner " + a.count + " " + a.total);
		total += a.total;
		count += a.count;
	}
}