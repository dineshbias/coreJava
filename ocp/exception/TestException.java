/**
 * 
 */
package ocp.exception;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

/**
 * @author edinjos
 *
 */
public class TestException {

	public static void read() throws SQLException {
	
		 
		
		try {
			readFromDatabase();
		} catch (Exception e) {
			throw e;
		}
	}
	
	static void testExc() throws Exception
	{
		
	}
	
	private static void readFromDatabase() throws SQLException {
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(1, 2, 3);
		List<Integer> l2 = new CopyOnWriteArrayList<>(l1);
		Set<Integer> s3 = new ConcurrentSkipListSet<>();
		s3.addAll(l1);

		for (Integer item : l2)
			l2.add(4); // x1
		for (Integer item : s3)
			s3.add(5); // x2
		System.out.println(l1.size() + " " + l2.size() + " " + s3.size());

		Map<Integer, Integer> s4 = new ConcurrentSkipListMap<>();
		s4.put(1,1);
		s4.forEach( (a,b) -> System.out.println(a + " " + b));
		
		

		AtomicLong value1 = new AtomicLong(0);
		final long[] value2 = { 0 };
		IntStream.iterate(1, i -> 1).limit(100).parallel()
				.forEach(i -> value1.incrementAndGet());
		IntStream.iterate(1, i -> 1).limit(100).parallel()
				.forEach(i -> ++value2[0]);
		System.out.println(value1 + " " + value2[0]);

		try {
			testTryWithResources();
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		try {
			read();
			testTryCatchFinally();
		} catch (RuntimeException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		testAssertion();

		try {
			P.testCatchBolock();
		} catch (NumberFormatException | IOException e1) {
			System.out.println("main catch.......");
		}
		// testTryWithResources1();
		System.out.println("Inside main");
		try {
			testAssertion();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Exiting main");
	}

	public static void testError() throws Error {

		throw new Error();
	}

	public static void testRuntimeException() throws Throwable {

		throw new RuntimeException();
	}

	public static void testException() throws Throwable {
		throw new Exception();
	}

	public static void testUncheckedExceptionOthers() {

		// throw new IllegalFormatException();
		// throw new ArithmeticException();
		// throw new ArrayIndexOutOfBoundsException();
		// throw new ClassCastException();
		// throw new IllegalArgumentException();
		// throw new NullPointerException();
		// throw new NumberFormatException();
		// throw new ArrayStoreException();
		// throw new IllegalStateException();
		// throw new UnsupportedOperationException();
	}

	public static Throwable testCheckedExceptionOthers() {
		System.out.println("Checked Exceptions....");
		try {
			throw new FileNotFoundException();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			throw new IOException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			throw new ParseException("", 1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			throw new NotSerializableException();
		} catch (NotSerializableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			throw new SQLException();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Throwable();
	}

	public static void testTryCatchFinally() throws RuntimeException, Exception {
		System.out.println("Inside testTryCatchFinally");

		try {

			System.out.println("Inside try");
			throw new FileNotFoundException();
		} catch (RuntimeException | FileNotFoundException e) {
			System.out.println("Inside Catch");
		} finally {
			System.out.println("Inside Finally");
		}

		System.out.println("Exiting testTryCatchFinally");
	}

	public static void testCustomException() throws MyException {
		throw new MyException2("*************");
	}

	public static void testTryWithResources() throws Exception {

		try (A a = new A(); B b = new B();) {
			System.out.println("trying....");
			// throwException();
		} catch (Exception e3) {
			System.out.println("Exception caught " + e3);
			e3.printStackTrace();
		} finally {
			System.out.println("finally");
			// throw new Exception("finally exception");
		}
		// throwException();
		// System.out.println("leaving...");
	}

	public static void testTryWithResources1() throws Exception {
		try (A a = new A(); B b = new B();) {
			System.out.println("trying....");
			throwException();
		} catch (Exception e) {
		
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			System.out.println("finally");
			throw new Exception("finally exception");
		}
		// throwException();
		// System.out.println("leaving...");
	}

	public static void throwException() throws Exception {
		throw new Exception("Test Exception");
	}

	public static void testAssertion() {
		assert false : "Sample asset failed";
	}
}

class MyException extends Exception {
	MyException() {
		System.out.println("MyException()");
	}

	MyException(String s) {
		super(s);
		System.out.println("MyException(s)");
	}
}

class MyException2 extends MyException {
	MyException2() {
		System.out.println("MyException2()");
	}

	MyException2(String s) {
		super(s);
		System.out.println("MyException2(s)");
	}
}

class A implements AutoCloseable {

	public A() {
		System.out.println("A constructed");
	}

	@Override
	public void close() throws Exception {
		System.out.println("close A....");
		throw new Exception("A exception");
	}

}

class B implements AutoCloseable {
	public B() {
		System.out.println("B constructed.");
	}

	@Override
	public void close() throws Exception {
		System.out.println("close B....");
		throw new IOException("B exception");
	}

}

abstract class X {
	abstract void method1() throws IOException;

}

class Y extends X {

	@Override
	void method1() throws IOException, NumberFormatException,
			FileNotFoundException {
		System.out.println();

	}

}

class Z {

	public static void test() throws IOException, NumberFormatException,
			FileNotFoundException {
		throw new FileNotFoundException();
	}
}

class P {

	public static void testCatchBolock() throws NumberFormatException,
			IOException {

		try {
			Z.test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
}