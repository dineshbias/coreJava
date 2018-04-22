/**
 * 
 */
package com.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import com.test.classdesign.Lion;

/**
 * @author edinjos
 *
 */
abstract class TestMain {
	static int i = 0;

	public static void fly(int... lenth) {
		System.out.println(Arrays.toString(lenth));
	}

	public static void test(Long l) {
		System.out.println("long :" + l);
	}

	public static void test(Byte l) {
		System.out.println("Byte :" + l);
	}

	/**
	 * 
	 */
	public TestMain() {
		System.out.println("Constructor");
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Path path1 = Paths.get("/bats/night", "../")
				.resolve(Paths.get("./sleep.txt")).normalize();
		Path path2 = new File("../sleep.txt").toPath().toRealPath();

		System.out.print(Files.isSameFile(path1, path2));
		System.out.print(" " + path1.equals(path2));

		String letters = "abcdef";
		System.out.println(letters.length());
		System.out.println(letters.charAt(3));
		System.out.println(letters.charAt(6));
		Lion lion = new Lion();
		lion.publicTemp = 1;

	}

	public static void testDate() {

		// Dates created prior to Java 8.
		Date oldDate = new Date();
		System.out.println(oldDate);

		Calendar c = Calendar.getInstance();
		c.set(2000, 0, 17);
		Date oldDate2 = c.getTime();
		System.out.println(oldDate2);

		// Dates created with Java 8
		LocalDateTime newDateTime = LocalDateTime.now();
		LocalDate newDate = LocalDate.now();
		LocalTime newTime = LocalTime.now();
		System.out.println(newTime);

		newDateTime = LocalDateTime.of(newDate, newTime);
		System.out.println(newDateTime);

		LocalDateTime newDateTime1 = LocalDateTime.of(2015, 12, 1, 10, 2, 3, 4);
		System.out.println(newDateTime1);

		newDateTime1 = newDateTime1.plusYears(1);
		System.out.println(newDateTime1);

		DateTimeFormatter dtf = DateTimeFormatter
				.ofLocalizedDateTime(FormatStyle.SHORT);
		System.out.println(dtf.format(newDateTime1));
		dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		System.out.println(dtf.format(newDateTime1));

		dtf = DateTimeFormatter.ofPattern("MMMM dd yyyy, hh:mm:ss");
		System.out.println(dtf.format(newDateTime1));
	}

	public static void testString() {
		String abcStringPool = "DINESH";
		String xyzHeap = new String("DINESH");
		String tempHEAP = new String("DINESH");

		System.out.println(abcStringPool == xyzHeap);
		System.out.println(abcStringPool.equals(xyzHeap));

		System.out.println(tempHEAP == xyzHeap);
		System.out.println(tempHEAP.equals(xyzHeap));
	}

	public static void concatNumbersA(int n) {
		StringBuffer s = new StringBuffer("");
		for (int i = 0; i < n; i++) {
			s.append(i);
		}
		System.out.println(s.toString());
	}

	public static void concatNumbersB(int n) {
		String s = new String();
		for (int i = 0; i < n; i++) {
			s += i;
		}
		System.out.println(s);
	}

	public static void testArrays() {
		int[] intArray1 = new int[4], intArray2 = { 1, 2, 3, 4 };
		System.out.println("intArray1:" + intArray1.length + " intArray2:"
				+ intArray2.length);

		String[] stringArray1 = new String[9], stringArray2 = { "cricket",
				"beetle", "ladybug" };
		System.out.println("stringArray1:" + stringArray1.length
				+ " stringArray2:" + stringArray2.length + " "
				+ Arrays.toString(stringArray2));
		Object[] objectArray = stringArray2;
		objectArray[0] = new String();
	}

	public static void testArrayList() {
		ArrayList al1 = new ArrayList(2);
		ArrayList al2 = new ArrayList<>();
		ArrayList al3 = new ArrayList<String>();
		ArrayList<String> al4 = new ArrayList<String>();

		System.out.println(al1.toString());
		al1.add("1");
		al1.add(2);
		al1.add(3.0);
		al1.add("abc");
		System.out.println(al1.toString());
		for (Object o : al1) {
			System.out.println(o + " ");
		}

		al2.add("One");
		System.out.println("Size:" + al2.size() + al2);
		al2.add(al1);
		System.out.println("Size:" + al2.size() + al2);

	}

	public static void testEquals() {

		String abc = "Dinesh";
		String xyz = "Dinesh";
		System.out.println(abc.toString() + ":" + xyz.toString()
				+ abc.equals(xyz) + ":" + (abc == xyz));

		String tmpS = new String("Dinesh");
		String tmp2S = new String("Dinesh");
		System.out.println(tmpS.toString() + ":" + tmp2S.toString()
				+ tmpS.equals(tmp2S) + ":" + (tmpS == tmp2S));

		StringBuilder tmpSB = new StringBuilder("Dinesh");
		StringBuilder tmpSB2 = new StringBuilder("Dinesh");
		System.out.println(tmpSB.toString() + ":" + tmpSB2.toString()
				+ tmpSB2.equals(tmpSB) + ":" + (tmpSB == tmpSB2));

		String tmpS10 = tmpSB.toString();
		String tmpS11 = tmpSB2.toString();
		System.out.println(tmpS10.toString() + ":" + tmpS11.toString()
				+ tmpS11.equals(tmpS10) + ":" + (tmpS10 == tmpS11));
	}

	public static void testStringBuilder() {
		StringBuilder sb = new StringBuilder("animals");
		System.out.println(sb);
		sb.insert(7, "-");
		sb.insert(1, "-");
		sb.insert(4, "-89898--");
		System.out.print(sb);

	}

	public static void testMultiDimensionalArray() {
		int[][] myComplexArray = { { 1 }, { 2, 3 }, { 4, 5, 6 }, { 1, 2, 1 },
				{ 3, 4, 1 }, { 5, 6, 1 } };
		OUTER_LOOP: for (int[] mySimpleArray : myComplexArray) {
			INNER_LOOP: for (int i = 0; i < mySimpleArray.length; i++) {
				System.out.print(mySimpleArray[i] + "\t");
			}
			System.out.println();
		}
		System.out.println("**********");
		int[][] twoDimensionalArray = new int[3][2];
		for (int i = 0; i < twoDimensionalArray.length; i++) {
			int[] tempArray = twoDimensionalArray[i];
			for (int j = 0; j < tempArray.length; j++) {
				twoDimensionalArray[i][j] = i + j;
				System.out.print(i + j + " ");
			}
		}

		System.out.println("\n" + "2d:" + twoDimensionalArray.length);
		for (int[] tempArray : twoDimensionalArray) {
			for (int temp : tempArray) {
				System.out.print(temp + " ");
			}
			System.out.println();
		}
	}

	public static void testStatementContinue() {

		OUTER_LOOP: for (int a = 1; a <= 4; a++) {
			for (char x = 'a'; x <= 'c'; x++) {
				if (a == 2 || x == 'b')
					continue OUTER_LOOP;
				System.out.println(a + " " + x);
			}

		}

	}

	private class xyz {
		/**
		 * 
		 */
		public xyz() {
		}

		private String i = "";
		int n = 1_00_000 * 1111111111;

		public void print() {

		}

		public void print(String a) {
			a = "";
		}

		public void print(short s) {
			s = 1;
		}

		public void print(int a) {
			a = 1;
		}

		public void print(long l) {
			l = 1;
		}

		public void print(float f) {
			f = 10.0f;
		}

		public void print(double d) {
			d = 1.34;
		}

		public void findAnswer(boolean check) {
			int answer;
			int onlyOneBranch;
			if (check) {
				answer = 1;
				onlyOneBranch = 2;
			} else {
				answer = 2;
			}
			System.out.println(answer);

		}

		protected void finalize() {
			System.out.println("finalize : " + TestMain.i);
		}

	}

}
