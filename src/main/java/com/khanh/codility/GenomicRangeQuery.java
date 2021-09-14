package com.khanh.codility;

public class GenomicRangeQuery {
	/**
	 * https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
	 * @param S
	 * @param P
	 * @param Q
	 * @return
	 */
	public int[] solution(String S, int[] P, int[] Q) {
		return Q;
	}

	public static void main(String[] args) {
		GenomicRangeQuery g = new GenomicRangeQuery();
		int[] P = new int[] { 2, 5, 0 };
		int[] Q = new int[] { 4, 5, 60 };
		g.solution("CAGCCTA ", P, Q);
	}
}
