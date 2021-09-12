package com.khanh.hackerrank;

import java.util.Arrays;
import java.util.List;

public class ReverseArrayDs {
	public static List<Integer> reverseArray(List<Integer> a) {
		int size = a.size();
		for (int i = 0; i < a.size() / 2; i++) {
			int temp = a.get(i);
			a.set(i, a.get(size - i - 1));
			a.set(size - i - 1, temp);
		}
		return a;
	}

	public static void main(String[] args) {
		List<Integer> result = ReverseArrayDs.reverseArray(Arrays.asList(1, 2, 3, 4));
		System.out.println(result.toArray().toString());
	}
}
