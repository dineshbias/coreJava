package ocp;

import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Sorted implements Comparable<Sorted>, Comparator<Sorted> {
	private int num;
	private String text;

	Sorted(int n, String t) {
		this.num = n;
		this.text = t;
	}

	public String toString() {
		return "" + num;
	}

	public int compareTo(Sorted s) {
		return text.compareTo(s.text);
	}

	public int compare(Sorted s1, Sorted s2) {
		return s1.num - s2.num;
	}

	public static void main(String[] args) {
		Period p = Period.ofDays(1);
		System.out.println(p);
		p = Period.ofYears(1);
		System.out.println(p);
		p = Period.ofMonths(1);
		System.out.println(p);
		System.out.println(p.ofDays(100).ofMonths(10).ofWeeks(12).ofYears(3));
		System.out.println(p.of(100, 45, 10));

		Stream.generate(() -> "1").limit(10).peek(System.out::println).count();

		Predicate<? super String> predicate = s -> s.length() > 3;
		Stream<String> stream = Stream.iterate("-", (s) -> s + s);
		boolean b = stream.peek(System.out::println).noneMatch(predicate);

		Sorted s1 = new Sorted(88, "a");
		Sorted s2 = new Sorted(55, "b");
		TreeSet<Sorted> t1 = new TreeSet<>();
		t1.add(s1);
		t1.add(s2);
		TreeSet<Sorted> t2 = new TreeSet<>(s1);
		t2.add(s1);
		t2.add(s2);
		System.out.println(t1 + " " + t2);
	}
	
	public static <T extends Set> T work(T t) {
		   return t;
		}
	
	public static void add(List<? super Number> list) {
		//HashSet set = work(new HashSet());
		Set set = work(new HashSet());
		list.add(123);

		List<? super Number> a = new ArrayList<>();
		a.add(123);
	}

}