package com.khanh.codility.primeandcomposite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/flags/
 * 
 * @author DELL
 *
 */
public class Flags {

	// 13%
//	public int solution(int[] A) {
//		if (A.length < 3) {
//			return 0;
//		}
//		int count = 0;
//		Map<Integer, Integer> peaks = new HashMap<>();
//		for (int i = 1; i < A.length; i++) {
//			int prev = A[i - 1];
//			int curr = A[i];
//			int next = Integer.MIN_VALUE;
//			if (i != A.length - 1) {
//				next = A[i + 1];
//			}
//
//			if (curr > prev && curr > next) {
//				peaks.put(i, curr);
//			}
//		}
//
//		if (peaks.size() == 0) {
//			return 0;
//		}
//		int previousPeak = Integer.MIN_VALUE;
//		for (Map.Entry<Integer, Integer> peak : peaks.entrySet()) {
//			if (peak.getValue() != previousPeak) {
//				count++;
//			}
//			previousPeak = peak.getValue();
//		}
//
//		return count;
//	}

	// 100%
	public int solution(int[] A) {
		if (A.length < 3) {
			return 0;
		}
		List<Integer> peaks = new ArrayList<>();
		for (int i = 1; i < A.length - 1; i++) {
			int prev = A[i - 1];
			int curr = A[i];
			int next = A[i + 1];
			if (curr > prev && curr > next) {
				peaks.add(i);
			}
		}
		if (peaks.size() <= 1) {
			return peaks.size();
		}

		int maxFlags = (int) Math.ceil(Math.sqrt(peaks.get(peaks.size() - 1) - peaks.get(0)));
		for (int flags = maxFlags; maxFlags > 1; flags--) {
			int startIndex = 0;
			int endIndex = peaks.size() - 1;

			int startFlag = peaks.get(startIndex);
			int endFlag = peaks.get(endIndex);

			int flagPlaced = 2;
			while (startIndex < endIndex) {
				startIndex++;
				endIndex--;
				if (peaks.get(startIndex) >= startFlag + flags) {
					if (peaks.get(startIndex) <= endFlag - flags) {
						flagPlaced++;
						startFlag = peaks.get(startIndex);
					}
				}
				if (peaks.get(endIndex) >= startFlag + flags) {
					if (peaks.get(endIndex) <= endFlag - flags) {
						flagPlaced++;
						endFlag = peaks.get(endIndex);
					}
				}
				if (flagPlaced == flags) {
					return flags;
				}

			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Flags f = new Flags();
		System.out.println("Flags: " + f.solution(new int[] { 1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 }));
		System.out.println("Flags: " + f.solution(new int[] { 3, 2, 1 }));
		System.out.println("Flags: " + f.solution(new int[] { 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 }));
		System.out.println("Flags: " + f.solution(new int[] { 1, 2, 3, 4, 5, 6 }));
	}
}
