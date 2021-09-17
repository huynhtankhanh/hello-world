package com.khanh.codility.sorting;

import java.util.HashSet;
import java.util.Set;

public class Distinct {

	/**
	 * https://app.codility.com/programmers/lessons/6-sorting/distinct/
	 * 
	 * @param A
	 * @return
	 */
	// 100%
	public int solution(int[] A) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < A.length; i++) {
			set.add(A[i]);
		}
		return set.size();
	}

	public static void main(String[] args) {
		Distinct d = new Distinct();
		int result = d.solution(new int[] { 2, 1, 1, 2, 3, 1 });
		System.out.println(result);
	}
}
