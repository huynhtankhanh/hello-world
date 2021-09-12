package com.khanh.hackerrank;

import java.util.Arrays;
import java.util.List;

public class AVeryBigSum {
	public static long aVeryBigSum(List<Long> ar) {
		return ar.stream().reduce(0l, (a, b) -> a + b);

//		long result = 0l;
//		for (int i = 0; i < ar.size(); i++) {
//			result += ar.get(i);
//		}
//		return result;
	}

	public static void main(String[] args) {
		long result = AVeryBigSum
				.aVeryBigSum(Arrays.asList(1000000001l, 1000000002l, 1000000003l, 1000000004l, 1000000005l));
		System.out.println(result);
	}
}
