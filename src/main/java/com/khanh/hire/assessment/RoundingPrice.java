package com.khanh.hire.assessment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class RoundingPrice {
	public static long[] solution(double[] prices) {
		long[] result = new long[prices.length];
		double total = 0d;
		for (int i = 0; i < prices.length; i++) {
			total += prices[i];
		}

		total = BigDecimal.valueOf(total).setScale(2, RoundingMode.HALF_UP).doubleValue();

		for (int i = 0; i < prices.length; i++) {
			long newValue = 0l;
			if (i > 0 && i < prices.length - 1) {
				newValue = (long) Math.floor(total - (total - prices[i]));
			} else {
				newValue = (long) Math.ceil(total - (total - prices[i]));
			}

			result[i] = newValue;
		}
		return result;
	}

	public static void main(String[] args) {
		long[] a = RoundingPrice.solution(new double[] { 5.4d, 3.3d, 5d });
		System.out.println(Arrays.toString(a));
	}
}
