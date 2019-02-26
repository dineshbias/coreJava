/**
 * 
 */
package com.test.basic;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

/**
 * @author edinjos
 *
 */
class TestBasics {

	/**
	 * 
	 */
	private TestBasics() {
		
		System.out.println("Cons ");
		new TestBasics(1);
	}
	
	private TestBasics(int i) {
		System.out.println("Cons ");
	}

	public static void main(String args) {
		int i = 1;

	}
	
	public static void moreE(int values, int... nums) {}
	/**
	 * @param args
	 * @throws Exception
	 */
	
	public static void main(String[] args) throws Exception {
		
		moreE(1, new int[2]);
		LocalDateTime d = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
		Period p = Period.of(1, 2, 3);
		d = d.minus(p);
		DateTimeFormatter f = DateTimeFormatter
				.ofLocalizedTime(FormatStyle.SHORT);
		System.out.println(d.format(f));

		P aa = new AA();
		aa.play();
		((AA) aa).print();

		System.exit(0);
		main("");
		new TestBasics();
		Rope rope = new Rope();
		rope.play();
		Rope rope2 = null;
		rope2.play();

		String[] s = new String[2];
		int[] i = new int[1];
		moreG(s, i);
		testLocalDateTime();

		int[] a = { 1, 2 };
		int[] b = { 1, 2 };

		if (a.equals(b)) {
			System.out.println("array is equal");
		}

		ArrayList x = new ArrayList();

		ArrayList y = new ArrayList();

		x.add(1);
		y.add(1);
		if (x.equals(y)) {
			System.out.println("arrayList is equal");
		}
		testStringConcatenation();
		int count = 0;
		ROW_LOOP: for (int row = 1; row <= 3; row++)

			for (int col = 1; col <= 3; col++) {
				if (row * col % 2 == 0)
					continue ROW_LOOP;

				count++;
			}
		System.out.println("count " + count);
	}

	public static void testLocalDateTime() {

		LocalDateTime d = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
		Period p = Period.of(1, 2, 3);
		d = d.minus(p);
		System.out.println(d);
	}

	public static void testStringConcatenation() {
		StringBuilder puzzle = new StringBuilder("Java");
		// puzzle.reverse();
		// puzzle.append("vaJ$").substring(0, 4);
		puzzle.append("vaJ$").delete(0, 3).deleteCharAt(puzzle.length() - 1);

		System.out.println(puzzle);
		String a = "";
		a += 2;
		a += 3L;
		a += 10.1f;
		a += 2.2;
		a += false;
		a += 'c';
		a += (byte) 127;
		System.out.println(a);
	}

	public void testInfiniteLoop() {
		for (int i = 0; i < 10;) {
			i = i++;
			System.out.println("Hello World " + i);
		}
	}

	public static void moreG(String[] values, int[] nums) {

		for (int i = 0; i < values.length; ++i) {
			System.out.print(values[i] + " ");
		}

		for (int i = 0; i < nums.length; ++i) {
			System.out.println(nums[i] + " ");
		}
	}
}

class Rope {
	public static void swing() {
		System.out.print("swing ");
	}

	public void climb() {
		System.out.print("climb ");
	}

	public static void play() {
		swing();
	}
}

interface P {
	default void play() throws Exception {
		System.out.println("P play");
	}

	static void print() throws Exception {
		System.out.println("P print");
	}
}

abstract class Q {
	protected void play() throws Exception {
		System.out.println("Q play");
	}

	static void print() throws Exception {
		System.out.println("Q print");
	}
}

interface R {
	default void play() throws Exception {
		System.out.println("R play");
	}

	static void print() throws Exception {
		System.out.println("R print");
	}
}

class AA extends Q implements P, R {

	public void play() throws Exception {
		System.out.println("AA play");

	}

	static void print2() throws Exception {
		System.out.println("AA print");
	}
}

