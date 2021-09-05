package com.khanh.java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Easiest way to restrict or manage access to constrained resources.
 * 
 * @author DELL
 * @since 10/12/1988
 *
 */
public class SemaphoreExample {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(50);
//		IntStream.of(1000).forEach(i -> service.execute(new Task()));
//		service.shutdown();
//		service.awaitTermination(1, TimeUnit.MINUTES);

		// semaphore
		// Only 3 threads can acquire permission at a time
		Semaphore semaphore = new Semaphore(3);
		IntStream.range(0, 100).forEach(i -> service.execute(new TaskSemaphore(semaphore, i)));

		service.shutdown();
		service.awaitTermination(1, TimeUnit.MINUTES);
	}

	static class TaskSemaphore implements Runnable {
		private Semaphore semaphore;
		private int index;

		public TaskSemaphore(Semaphore semaphore, int index) {
			this.semaphore = semaphore;
			this.index = index;
		}

		@Override
		public void run() {
			semaphore.acquireUninterruptibly(); // 4th concurrent thread will be block here
			System.out.println("Task running with semaphore pattern at index: " + this.index);
			semaphore.release();
		}
	}

	static class Task implements Runnable {

		@Override
		public void run() {
			System.out.println("run");
		}
	}
}
