/**
 * 
 */
package ocp.concurrency.service;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author edinjos
 *
 */
public class TestRecursiveAction {

	public static void main(String... args) {
		Double[] weights = new Double[10];
		WeighAnimalAction action = new WeighAnimalAction(weights, 0,
				weights.length);

		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(action);
	}

}

class WeighAnimalAction extends RecursiveAction {
	private int start;
	private int end;
	private Double[] weights;

	public WeighAnimalAction(Double[] weights, int start, int end) {
		System.out.println("TestWeighAnimalAction constructed...");
		this.weights = weights;
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {
		System.out.println("TestWeighAnimalAction compute...");
		if (end - start < 3) {
			for (int i = start; i < end; i++) {
				weights[i] = (double) new Random().nextInt(100);
				System.out.println(Thread.currentThread().getName()
						+ " Animal weighed:" + i);
			}
		} else {
			int middle = start + (end - start) / 2;
			System.out.println(Thread.currentThread().getName() + " start:"
					+ start + " middle:" + middle + " end:" + end);
			invokeAll(new WeighAnimalAction(weights, start, middle),
					new WeighAnimalAction(weights, middle, end));

		}

	}

}
