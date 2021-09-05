package com.khanh.java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AtomicData {
	public static void main(String[] args) throws InterruptedException {
		AtomicInteger num = new AtomicInteger(0);

		ExecutorService service = Executors.newFixedThreadPool(50);
		IntStream.range(0, 100).forEach(i -> service.execute(new Task(num)));

		service.shutdown();
		service.awaitTermination(1, TimeUnit.MINUTES);
	}

	static class Task implements Runnable {
		private AtomicInteger num;

		public Task(AtomicInteger num) {
			this.num = num;
		}

		@Override
		public void run() {
			System.out.println(this.num.incrementAndGet() + " ");
		}

	}
}
