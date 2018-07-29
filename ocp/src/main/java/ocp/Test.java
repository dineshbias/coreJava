package ocp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import ocp.oops.SampleA;

public class Test {
	public static void calculateFuture(int seed) {
		// IMPLEMENTATION OMITTED
	}

	public static void seeFuture(Future<?> f) {

		SampleA test = new SampleA();
		System.out.println(test.sPublic);

		try {
			Object obj = f.get(100, TimeUnit.DAYS);

			System.out.println(obj); // i1
		} catch (Exception e) {
			System.out.println("Problem");
		}
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newSingleThreadExecutor();
		final List<Future<?>> results = new ArrayList<>();
		IntStream.range(10, 15).forEach(i -> results.add(service.submit(() -> calculateFuture(i)))); // i2
		results.stream().forEach(f -> seeFuture(f));
		service.shutdown();
	}
}

class X extends SampleA {

	public void testAccess() {
		// System.out.println(sDefault);
		System.out.println(sProtected);
		System.out.println(sPublic);
	}

}