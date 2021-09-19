package com.khanh.codility.sorting;

import java.util.Arrays;

public class NumberOfDiscIntersections {
	public int solution(int[] A) {
		int[] starts = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			int radius = A[i];
			int startPos = i - radius;
			if (startPos < 0) {
				startPos = 0;
			}
			starts[startPos]++;
		}

		int intersection = 0;
		for (int i = 0; i < starts.length; i++) {
			if (starts[i] > 0) {
				intersection += (starts[i]);
			}
		}

		int total = 0;
		for (int i = 0; i < starts.length; i++) {
			total += starts[i];
			starts[i] = total;
		}
		return intersection;
	}

	/**
	 * Strategy: Storing all lower and upper of the disc if upper point >= lower
	 * point => intersections ++
	 * 
	 * @param A
	 * @return
	 */

	// 100%
	public int solution1(int[] A) {
		// use long for big number condition
		long[] lower = new long[A.length];
		long[] upper = new long[A.length];
		for (int i = 0; i < A.length; i++) {
			lower[i] = i - (long) A[i];
			upper[i] = i + (long) A[i];
		}

		// "sort" the "lower points" and "upper points"
		Arrays.sort(upper);
		Arrays.sort(lower);
		int intersection = 0;
		int j = 0;
		for (int i = 0; i < A.length - 1; i++) {
			while (j < A.length && upper[i] >= lower[j]) {
				intersection += j; // add j intersection
				intersection -= i; // minus i - avoid double count
				j++;
			}
		}

		if (intersection > 10000000) {
			return -1;
		}
		return intersection;
	}

	public static void main(String[] args) {
		NumberOfDiscIntersections n = new NumberOfDiscIntersections();
		int result = n.solution(new int[] { 1, 5, 2, 1, 4, 0 });
		System.out.println(result);

		result = n.solution1(new int[] { 1, 5, 2, 1, 4, 0 });
		System.out.println(result);
	}
}
