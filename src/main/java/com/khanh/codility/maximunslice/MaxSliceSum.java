package com.khanh.codility.maximunslice;

/**
 * https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/
 * 
 * @author htkhanh
 *
 */
public class MaxSliceSum {

	// 100%
	public int solution(int[] A) {
		long maxSum = Integer.MIN_VALUE, maxSlideSum = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			maxSlideSum = Math.max(A[i], maxSlideSum + A[i]);
			maxSum = Math.max(maxSlideSum, maxSum);

		}
		return (int) maxSum;
	}

	public static void main(String[] args) {
		MaxSliceSum m = new MaxSliceSum();
		System.out.println(m.solution(new int[] { 3, 2, -6, 4, 0 }));
		System.out.println(m.solution(new int[] { -10 }));
	}
}
