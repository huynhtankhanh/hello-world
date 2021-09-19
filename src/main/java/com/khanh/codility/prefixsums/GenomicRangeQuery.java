package com.khanh.codility.prefixsums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GenomicRangeQuery {
	/**
	 * https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
	 * 
	 * @param S
	 * @param P
	 * @param Q
	 * @return
	 */

	// 62%
	public int[] solution(String S, int[] P, int[] Q) {
		int[] result = new int[P.length];

		for (int i = 0; i < P.length; i++) {
			int minImpact = findMinImpact(S, P[i], Q[i]);
			result[i] = minImpact;
		}

		return result;
	}

	// 100%
	public int[] solution1(String S, int[] P, int[] Q) {
		int[][] counters = new int[4][S.length() + 1];
		int a = 0, c = 0, g = 0, t = 0;

		// create 2d array to store how many time the A, C, G or T present in S
		// counters[0][i] => A
		// counters[1][i] => C
		// counters[2][i] => G
		// counters[3][i] => T
		for (int i = 0; i < S.length(); i++) {
			String str = S.substring(i, i + 1);
			if ("A".equals(str)) {
				a++;
			} else if ("C".equals(str)) {
				c++;
			} else if ("G".equals(str)) {
				g++;
			} else if ("T".equals(str)) {
				t++;
			}

			// I + 1 for substring from to index
			counters[0][i + 1] = a;
			counters[1][i + 1] = c;
			counters[2][i + 1] = g;
			counters[3][i + 1] = t;
		}
		// If S= CAGCCTA then counters[][] is
		// for A [0, 0, 1, 1, 1, 1, 1, 2]
		// for C [0, 1, 1, 1, 2, 3, 3, 3]
		// for G [0, 0, 0, 1, 1, 1, 1, 1]
		// for T [0, 0, 0, 0, 0, 0, 1, 1]

		int[] result = new int[P.length];
		for (int i = 0; i < P.length; i++) {
			int startIndex = P[i];
			int endIndex = Q[i] + 1;
			int r = 5;
			// we all know the counters length is 4, loop through counters and compare with
			// the query indexes
			for (int j = 0; j < 4; j++) {
				// if has, just j + 1 then return because we just find the min impact
				if (counters[j][startIndex] != counters[j][endIndex]) {
					r = j + 1;
					break;
				}
			}
			result[i] = r <= 4 ? r : 0;
		}

		return result;
	}

	public static int findMinImpact(String s, int beginIndex, int endIndex) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 1);
		map.put('C', 2);
		map.put('G', 3);
		map.put('T', 4);

		String subString = s.substring(beginIndex, endIndex + 1);
		int minImpact = 5;
		for (int i = 0; i < subString.length(); i++) {
			minImpact = Math.min(minImpact, map.getOrDefault(subString.charAt(i), Integer.MAX_VALUE));
		}
		return minImpact;
	}

	public static void main(String[] args) {
		GenomicRangeQuery g = new GenomicRangeQuery();
		int[] P = new int[] { 2, 5, 0 };
		int[] Q = new int[] { 4, 5, 6 };
		int[] result = g.solution("CAGCCTA ", P, Q);
		System.out.println(Arrays.toString(result));

		result = g.solution1("CAGCCTA", P, Q);
		System.out.println(Arrays.toString(result));

		result = g.solution1("A", new int[] { 0 }, new int[] { 0 });
		System.out.println(Arrays.toString(result));

		result = g.solution1("CAGCCTA", P, Q);
		System.out.println(Arrays.toString(result));

	}
}
