package ocp.design;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ocp.design.pool.Sample;

public class TestObjectPool {

	public static void main(String args[]) {

		ExecutorService es = null;
		try {
			es = Executors.newFixedThreadPool(20);

			for (int i = 0; i < 100; i++) {
				Sample s = new Sample(i);
				es.submit(() -> s.processRequest());
			}
		} finally {
			if (null != es) {
				es.shutdown();
			}

		}
	}
}
