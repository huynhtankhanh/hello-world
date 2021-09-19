package com.khanh.codility.maximunslice;

public class MaxSumSlideTheory {

	public int solutionON(int[] A) {
		long maxSum = Integer.MIN_VALUE, maxSlideSum = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			maxSlideSum = Math.max(A[i], maxSlideSum + A[i]);
			maxSum = Math.max(maxSlideSum, maxSum);

		}
		return (int) maxSum;
	}

	public static void main(String[] args) {
		MaxSumSlideTheory m = new MaxSumSlideTheory();
		System.out.println(m.solutionON(new int[] { 5, -7, 3, 5, -2, 4, -1 }));
		System.out.println(m.solutionON(new int[] { -10 }));
	}
}
