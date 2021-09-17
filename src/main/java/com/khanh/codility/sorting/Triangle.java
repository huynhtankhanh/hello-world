package com.khanh.codility.sorting;

import java.util.Arrays;

public class Triangle {

	/**
	 * https://app.codility.com/programmers/lessons/6-sorting/triangle/
	 * 
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {
		if (A.length < 3) {
			return 0;
		}

		Arrays.sort(A);
		for (int i = 0; i < A.length - 2; i++) {
			if ((long) A[i] + A[i + 1] > A[i + 2]) {
				return 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Triangle t = new Triangle();
		int result = t.solution(new int[] { 10, 2, 5, 1, 8, 20 });
		System.out.println(result);

		result = t.solution(new int[] { 10, 50, 5, 1 });
		System.out.println(result);
	}
}
