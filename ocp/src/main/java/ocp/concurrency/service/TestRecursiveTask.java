/**
 * 
 */
package ocp.concurrency.service;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author edinjos
 *
 */
public class TestRecursiveTask {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Double[] weights = new Double[10];
		WeighAnimalTask task = new WeighAnimalTask(weights, 0,
				weights.length);
		
		ForkJoinPool pool = new ForkJoinPool();
		Double sum = pool.invoke(task);
		System.out.println("***********SUM : " + sum);
	}

}

class WeighAnimalTask extends RecursiveTask<Double> {

	private int start;
	private int end;
	private Double[] weights;

	WeighAnimalTask(Double[] weights, int start, int end) {
		System.out.println("WeighAnimalTask constructed..." + start + " " + end );
		this.weights = weights;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Double compute() {
		System.out.println(Thread.currentThread().getName()
				+ " WeighAnimalTask compute...");

		if (end - start < 3) {
			double sum = 0;
			for (int i = start; i < end; i++) {
				weights[i] = (double) new Random().nextInt(100);
				System.out.println("Animal weighed: " + weights[i]);
				sum += weights[i];
			}
			return sum;
		} else {
			int middle = start + ((end - start) / 2);
			System.out.println("start:" + start + " middle:" + middle + " end:"
					+ end);

			WeighAnimalTask task = new WeighAnimalTask(weights, start, middle);
			task.fork();
			return new WeighAnimalTask(weights, middle, end).compute() + task.join();
		}

	}

}