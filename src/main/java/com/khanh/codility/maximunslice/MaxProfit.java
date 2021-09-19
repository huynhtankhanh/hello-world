package com.khanh.codility.maximunslice;

/**
 * https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/
 * 
 * @author DELL
 *
 */
public class MaxProfit {
	public int solution(int[] A) {
		if (A.length == 0) {
			return 0;
		}

		int maxProfit = 0;
		int startPrice = A[0];
		for (int i = 1; i < A.length; i++) {
			int profit = A[i] - startPrice;
			if (profit <= 0) {
				startPrice = A[i];
			}

			maxProfit = Math.max(profit, maxProfit);
		}

		return maxProfit;
	}

	public static void main(String[] args) {
		MaxProfit m = new MaxProfit();
		System.out.println(m.solution(new int[] { 23171, 21011, 21123, 21366, 21013, 21367 }));
	}
}
