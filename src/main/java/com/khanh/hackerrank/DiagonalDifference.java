package com.khanh.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalDifference {
	public static int diagonalDifference(List<List<Integer>> arr) {
		int sumMain = 0, sumSub = 0;
		for (int i = 0; i < arr.size(); i++) {
			List<Integer> row = arr.get(i);
			for (int j = 0; j < arr.size(); j++) {
				if (i == j) {
					sumMain += (row.get(j) != null ? row.get(j) : 0);
				}
				if ((i + j) == (arr.size() - 1)) {
					sumSub += (row.get(j) != null ? row.get(j) : 0);
				}
			}
		}
		return Math.abs(sumMain - sumSub);
	}

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();
		l1.add(11);
		l1.add(2);
		l1.add(4);

		List<Integer> l2 = new ArrayList<>();
		l2.add(4);
		l2.add(5);
		l2.add(6);

		List<Integer> l3 = new ArrayList<>();
		l3.add(10);
		l3.add(8);
		l3.add(-12);

		List<List<Integer>> arr = new ArrayList<>(Arrays.asList(l1, l2, l3));

		int result = DiagonalDifference.diagonalDifference(arr);
		System.out.println(result);
	}
}
