package com.khanh.codility;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MinAvgTwoSlice {

	/**
	 * https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
	 * 
	 * @param A
	 * @return
	 */
	// we just need to compare min avg of 2 and miv avg of 3, because 4 will combine
	// many min number in number of min avg of 2, so no need to care
	// 100%
	public int solution(int[] A) {
		int indexMinOf2 = -1;
		int minSumOf2 = Integer.MAX_VALUE;

		int indexMinOf3 = -1;
		int minSumOf3 = Integer.MAX_VALUE;
		for (int i = 0; i < A.length - 1; i++) {
			int val1 = A[i];
			int val2 = A[i + 1];
			int sumOf2 = val1 + val2;
			if (sumOf2 < minSumOf2) {
				minSumOf2 = sumOf2;
				indexMinOf2 = i;
			}

			if (i < A.length - 2) {
				val1 = A[i];
				val2 = A[i + 1];
				int val3 = A[i + 2];
				int sumOf3 = val1 + val2 + val3;
				if (sumOf3 < minSumOf3) {
					minSumOf3 = sumOf3;
					indexMinOf3 = i;
				}
			}

		}
		if (indexMinOf3 == -1) {
			return indexMinOf2;
		}

		BigDecimal avg2 = new BigDecimal(minSumOf2).divide(new BigDecimal(2), 5, RoundingMode.UP);
		BigDecimal avg3 = new BigDecimal(minSumOf3).divide(new BigDecimal(3), 5, RoundingMode.UP);
		if (avg2.compareTo(avg3) <= 0) {
			return indexMinOf2;
		}
		return indexMinOf3;
	}

	public static void main(String[] args) {
		MinAvgTwoSlice m = new MinAvgTwoSlice();
		System.out.println(m.solution(new int[] { 4, 2, 2, 5, 1, 5, 8 }));
	}
}
