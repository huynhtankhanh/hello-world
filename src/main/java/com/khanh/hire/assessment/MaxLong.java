package com.khanh.hire.assessment;

public class MaxLong {
	public static long solution(long[] numbers) {
		if (numbers.length == 0) {
			return 0l;
		}
		long max = 0l;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > max) {
				max = numbers[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		long result = MaxLong.solution(new long[] { 7, 2, 6, 3 });
		System.out.println(result);
	}
}
