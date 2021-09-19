package com.khanh.codility.sieveoferatosthenes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountNonDivisible {

	public int[] solution(int[] A) {
		// map contains how many time the number appears in array
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		for (int a : A) {
			int c = 0;
			if (count.containsKey(a)) {
				c = count.get(a);
			}
			c++;
			count.put(a, c);
		}

		// map tracking how many items that a number can divide in array, if having
		// duplicated divisor numbers in array -> increase that count with duplicated
		// number Ex: [3,1,2,3,6] having 3 time of 3, 6 have 5 as divisor count
		Map<Integer, Integer> divisorCounts = new HashMap<Integer, Integer>();
		for (int n : count.keySet()) {
			int divisorCount = 0;
			double squareRoot = Math.sqrt(n);
			for (int val = 1; val <= squareRoot; val++) {
				if (n % val == 0) {
					if (count.containsKey(val)) {
						divisorCount += count.get(val);
					}
					if (val < squareRoot) {
						int opp = n / val; // find the opposite value of val through square root
						if (count.containsKey(opp)) {
							divisorCount += count.get(opp);
						}
					}
				}
			}
			divisorCounts.put(n, divisorCount);
		}

		int[] nonDivisors = new int[A.length];
		for (int i = 0; i < nonDivisors.length; i++) {
			nonDivisors[i] = A.length - divisorCounts.get(A[i]);
		}
		return nonDivisors;
	}

	public static void main(String[] args) {
		CountNonDivisible c = new CountNonDivisible();
		int[] result = c.solution(new int[] { 3, 1, 2, 3, 6 });
		System.out.println(Arrays.toString(result));
	}
}
