package com.khanh.codility.timecomplexity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PermMissingElem {

	/**
	 * An array A consisting of N different integers is given. The array contains
	 * integers in the range [1..(N + 1)], which means that exactly one element is
	 * missing.
	 * 
	 * Your goal is to find that missing element.
	 * 
	 * Write a function:
	 * 
	 * class Solution { public int solution(int[] A); }
	 * 
	 * that, given an array A, returns the value of the missing element.
	 * 
	 * For example, given array A such that:
	 * 
	 * A[0] = 2 A[1] = 3 A[2] = 1 A[3] = 5 the function should return 4, as it is
	 * the missing element.
	 * 
	 * Write an efficient algorithm for the following assumptions:
	 * 
	 * N is an integer within the range [0..100,000]; the elements of A are all
	 * distinct; each element of array A is an integer within the range [1..(N +
	 * 1)].
	 */

	public int solution(int[] A) {
		Arrays.sort(A);
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < A.length; i++) {
			set.add(A[i]);
		}
		int N = A[A.length - 1];
		for (int i = 1; i <= N + 1; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		PermMissingElem p = new PermMissingElem();
		System.out.println(p.solution(new int[] { 2, 3, 1, 5 }));

	}
}
