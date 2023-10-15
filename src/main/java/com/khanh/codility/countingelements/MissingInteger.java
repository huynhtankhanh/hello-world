package com.khanh.codility.countingelements;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingInteger {

	/**
	 * https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
	 * 
	 * @param A
	 * @return
	 */
	// 100%
	public int solution(int[] A) {
		Arrays.sort(A);
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < A.length; i++) {
			set.add(A[i]);
		}

		int max = A[A.length - 1];
		for (int i = 1; i <= max+1; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}

		return 1;
	}

	public static void main(String[] args) {
		MissingInteger m = new MissingInteger();
		int result = m.solution(new int[] {-1, 1, 3, 5, 4, 1, 2 });
		System.out.println(result);
	}
}
