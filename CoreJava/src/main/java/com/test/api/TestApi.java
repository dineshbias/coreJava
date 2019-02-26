/**
 * 
 */
package com.test.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author edinjos
 *
 */
public class TestApi {

	public TestApi() {
		System.out.println("TestApi constructor");
	}

	public static void main(String... varagrs) throws InterruptedException {
		testDateTime();
	}

	public static void testDateTime() throws InterruptedException {
		
		LocalDateTime localDateTime2 = LocalDateTime.now();
		System.out.println(localDateTime2);
		Thread.sleep(1000);
		LocalDate localDate1 = LocalDate.now();
		LocalTime localTime1 = LocalTime.now();
		LocalDateTime localDateTime1 = LocalDateTime.of(localDate1, localTime1);
		System.out.println(localDateTime1);
		Thread.sleep(1000);
		LocalDate localDate2 = LocalDate.of(2018, Month.FEBRUARY, 18);
		LocalTime localTime2 = LocalTime.of(15, 50, 20);
		LocalDateTime localDateTime3 = LocalDateTime.of(localDate2, localTime2);
		System.out.println(localDateTime3);
		localDate2.minusMonths(4);
		localDateTime3 = LocalDateTime.of(localDate2, localTime2);
		System.out.println(localDateTime3);
		
		//Formatters
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss");
		System.out.println(dtf2.format(localTime2));
		
		DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("dd MMM yyyy");
		System.out.println(dtf3.format(localDate2));
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MMMM dd, HH:mm:ss");
		System.out.println(dtf.format(localDateTime3));
		
		
	}

	public static void testArrayList() {
		ArrayList a = new ArrayList();
		a.add("Dinesh");
		a.add(100);
		a.add(234.56);
		a.add(314141389357635698L);

		for (Object o : a) {
			System.out.println(o);
		}

		a.remove(0);
		a.remove(0);
		for (Object o : a) {
			System.out.println(o);
		}

	}

	public static void testArrays() {
		long[] i = { 10L, -2L, 100L };
		int j[] = new int[2];
		for (long a : i) {
			System.out.print(a);
			System.out.print(" ");
		}
		System.out.println();
		Arrays.sort(i);
		;
		for (long a : i) {
			System.out.print(a);
			System.out.print(" ");
		}
		System.out.println();
		for (int z = 0; z < j.length; z++) {
			System.out.println(j[z]);

		}

		List l = Arrays.asList(i);
		l.remove(0);
	}

	public static void testStrings() {
		String abc = "Dinesh";
		String xyz = new String("Dinesh");

		if (abc == xyz) {
			System.out.println("==");
		}

		if (abc.equals(xyz)) {
			System.out.println("equals");
		}

		StringBuilder sb = new StringBuilder(5);
		sb.append("test");
		sb.append(" fdf");
		System.out.println(sb + " " + sb.capacity());
		sb.insert(8, "-");
		System.out.println(sb + " " + sb.capacity());
		sb.delete(1, 100);
		System.out.println(sb + " " + sb.capacity() + sb.length());
	}
}
