package com.khanh.leetcode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		List<List<Integer>> result = solution.permute(new int[] { 1, 2, 3 });
		System.out.println(result.toString());
		System.out.println("sqrt: " + Math.sqrt(6));
		solution.testGeneratePermutations();

		System.out.println(Solution.solution1(">><<><"));

		long[] a = Solution.solution(new double[] { 5.4d, 3.3d, 5d });
		System.out.println(Arrays.toString(a));
	}

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

	public static String solution1(String angles) {
		int openCount = 0;
		int additionalOpenTags = 0;
		for (int i = 0; i < angles.length(); i++) {
			char c = angles.charAt(i);
			if (c == '>') {
				if (openCount == 0) {
					additionalOpenTags++;
				} else {
					openCount--;
				}
			} else {
				openCount++;
			}
		}

		StringBuilder openingTags = new StringBuilder();
		for (int i = 0; i < additionalOpenTags; i++) {
			openingTags.append("<");
		}

		StringBuilder closingTags = new StringBuilder();
		for (int i = 0; i < openCount; i++) {
			closingTags.append(">");
		}

		StringBuilder result = new StringBuilder();
		result.append(openingTags).append(angles).append(closingTags);
		return result.toString();
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		helper(nums, 0, result);
		return result;
	}

	private void helper(int[] array, int pos, List<List<Integer>> result) {
		if (pos >= array.length - 1) {
			List<Integer> subResult = new ArrayList<>();

			for (int i = 0; i < array.length - 1; i++) {
				subResult.add(array[i]);
			}
			if (array.length > 0) {
				subResult.add(array[array.length - 1]);
			}
			result.add(subResult);
			return;
		}

		for (int i = pos; i < array.length; i++) {
			int temp = array[pos];
			array[pos] = array[i];
			array[i] = temp;

			helper(array, pos + 1, result);

			temp = array[pos];
			array[pos] = array[i];
			array[i] = temp;
		}
	}

	public static void generatePermutations(List<List<String>> lists, List<List<String>> result, int depth,
			List<String> current) {
		if (depth == lists.size()) {
			result.add(current);
			return;
		}

		for (int i = 0; i < lists.get(depth).size(); i++) {
			List<String> copy = new ArrayList<>(current);
			copy.add(lists.get(depth).get(i));
			generatePermutations(lists, result, depth + 1, copy);
		}
	}

	public void testGeneratePermutations() {
		List<String> l1 = new ArrayList<>(Arrays.asList("A", "B", "C"));
//		List<String> l2 = new ArrayList<>(Arrays.asList("D", "E", "F"));

		List<List<String>> optionCollectors = new ArrayList<>();
		optionCollectors.add(l1);
//		optionCollectors.add(l2);

		List<List<String>> conbinedVariants = new ArrayList<>();
		generatePermutations(optionCollectors, conbinedVariants, 0, new ArrayList<>());
		System.out.println(conbinedVariants);
	}
}
