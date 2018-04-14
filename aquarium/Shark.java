package aquarium;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Shark {
	static int numFins;
	static Water water;

	public static void main(String[] args) {

		D c = new E();
		System.out.println("static a "+c.a);
		A a = c;
		((E)c).a='z';
		System.out.println("static E "+E.a);
		System.out.println("static D "+D.a);
		
		List<String> list = Arrays.asList("a", "B", "d", "c");
		Collections.sort(list);
		String[] array = list.toArray(new String[4]);
		for (String string : array)
			System.out.print(string);

		String numbers = "2468";
		int total = 0;
		total += numbers.indexOf("6");
		total += numbers.indexOf("9");
		char ch = numbers.charAt(3);
		System.out.println(total + " " + ch);

		String year = "Senior";
		switch (year) {
		case "Freshman":
		default:
		case "Sophomore":
		case "Junior":
			System.out.print("See you next year");
			break;
		case "Senior":
			System.out.print("Congratulations");
		}

		LocalDateTime d = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
		Period p = Period.of(1, 2, 3);
		d = d.minus(p);
		DateTimeFormatter f = DateTimeFormatter
				.ofLocalizedDateTime(FormatStyle.SHORT);
		System.out.println(d.format(f));

		LocalDate date = LocalDate.of(2018, Month.APRIL, 30).plusMonths(-1)
				.plusYears(20);
		System.out.println(date.getYear() + " " + date.getMonth() + " "
				+ date.getDayOfMonth());

		int num1 = 8;
		int num2 = 8;
		for (int i = 0; i < 3; i++)
			if (num1 == num2)
				try {
					System.out.println("t");
				} catch (Exception e) {
					System.out.println("c");
				}

	}

}

interface A {
	public static char a='A';
	public default int print() {
		System.out.println("A print");
		return new Integer(1);
	}
}

interface B extends A {
	final char a='B';
	public default int print() {
		System.out.println("B print");
		return new Integer(1);
	}
}

abstract class C implements B {
	public static char a='C';
	public int print() {
		System.out.println("C print");
		return new Integer(1);
	}
	public static int print2() {
		System.out.println("C print2");
		return new Integer(1);
	}
}

abstract class D extends C {
	public static char a='D';
}

class E extends D {
	public static char a='E';
	public int print() {
		System.out.println("E print");
		return new Integer(1);
	}
	public static int print2() {
		System.out.println("E print2");
		return new Integer(1);
	}
}