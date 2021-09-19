package com.khanh.codility.maximunslice;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/
 * 
 * @author htkhanh
 *
 */
public class MaxDoubleSliceSum {

	// 100%
	public int solution(int[] A) {
		int sumLeft[] = new int[A.length];
		int sumRight[] = new int[A.length];

		// find sum left is the sum ending at index i ( < 1 and > 0), ignore index = 0
		for (int i = 1; i < sumRight.length; i++) {
			sumLeft[i] = Math.max(0, sumLeft[i - 1] + A[i]);
		}

		// find sum right is the sum starting at index i (> i and < length - 1), ignore
		// index at length - 1
		for (int i = A.length - 2; i >= 0; i--) {
			sumRight[i] = Math.max(0, sumRight[i + 1] + A[i]);
		}
		System.out.println("sumL: " + Arrays.toString(sumLeft));
		System.out.println("sumR: " + Arrays.toString(sumRight));

		// find the maximum of sumLeft + sumRight up to index i
		int maxDoubleSlice = 0;
		for (int i = 1; i < A.length - 1; i++) {
			if (sumLeft[i - 1] + sumRight[i + 1] > maxDoubleSlice) {
				maxDoubleSlice = sumLeft[i - 1] + sumRight[i + 1];
			}
		}
		return maxDoubleSlice;
	}

	public static void main(String[] args) {
		MaxDoubleSliceSum m = new MaxDoubleSliceSum();
		System.out.println(m.solution(new int[] { 3, 2, 6, -1, 4, 5, -1, 2 }));
	}
}
