package com.khanh.hackerrank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class PlusMinus {

	public static void plusMinus(List<Integer> arr) {
		int size = arr.size();
		long posCount = arr.stream().filter(item -> item > 0).count();
		System.out.println(new BigDecimal(posCount).divide(new BigDecimal(size), 6, RoundingMode.HALF_UP));

		long negCount = arr.stream().filter(item -> item < 0).count();
		System.out.println(new BigDecimal(negCount).divide(new BigDecimal(size), 6, RoundingMode.HALF_UP));

		long zeroCount = arr.stream().filter(item -> item == 0).count();
		System.out.println(new BigDecimal(zeroCount).divide(new BigDecimal(size), 6, RoundingMode.HALF_UP));
	}

	public static void main(String[] args) {
		PlusMinus.plusMinus(Arrays.asList(-4, 3, -9, 0, 4, 1));
	}
}
