package com.khanh.codility.countingelements;

import java.util.Arrays;

public class MaxCounters {

	/**
	 * https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
	 * 
	 * @param N
	 * @param A
	 * @return
	 */
	//77%
	public int[] solution(int N, int[] A) { // TODO
		int[] counters = new int[N];
		int maxValue = 0;
		for (int i = 0; i < A.length; i++) {
			int operation = A[i];
			if (operation == N + 1) {
				// max counter
				for (int j = 0; j < counters.length; j++) {
					counters[j] = maxValue;
				}
			} else {
				operation--;
				counters[operation]++;
				maxValue = Math.max(maxValue, counters[operation]);
			}
		}
		return counters;
	}

	public static void main(String[] args) {
		MaxCounters c = new MaxCounters();

		int[] result = c.solution(5, new int[] { 3, 4, 4, 6, 1, 4, 4 });
		System.out.println(Arrays.toString(result));
	}
}
