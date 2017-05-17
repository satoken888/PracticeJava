package practiceJava;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class FibonacciTask extends RecursiveTask<Integer> {

	int n;

	public FibonacciTask(int n) {
		this.n = n;
	}

	@Override
	protected Integer compute() {
		return compute(n);
	}

	int compute(int n) {
		if(n <= 1) {
			return n;
		}
		ForkJoinTask<Integer> f1 = new FibonacciTask(n-2).fork();
		return compute(n-1) + f1.join();
	}

}
