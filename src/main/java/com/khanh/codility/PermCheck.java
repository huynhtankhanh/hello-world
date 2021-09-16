package com.khanh.codility;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {
	/**
	 * https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
	 * 
	 * @param A
	 * @return
	 */
	// 100%
	public static int solution(int[] A) {
		int max = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < A.length; i++) {
			if (A[i] > max) {
				max = A[i];
			}
			set.add(A[i]);
		}
		if (set.size() < A.length) {
			return 0;
		}
		if (max > A.length) {
			return 0;
		}

		int sum = 0;
		int countIndex = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			countIndex += (i + 1);
		}
		return sum == countIndex ? 1 : 0;
	}

	public static void main(String[] args) {
		int result = PermCheck.solution(new int[] { 4, 1, 3, 2 });
		System.out.println(result);

		result = PermCheck.solution(new int[] { 4, 1, 3 });
		System.out.println(result);
	}
}
