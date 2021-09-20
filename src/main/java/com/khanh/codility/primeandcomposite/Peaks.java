package com.khanh.codility.primeandcomposite;

import java.util.ArrayList;
import java.util.List;

public class Peaks {

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
		if (peaks.size() == 0) {
			return 0;
		}

		for (int blockLength = 3; blockLength <= A.length / 2; blockLength++) {
			if (A.length % blockLength != 0) {
				continue;
			}

			int currentPeak = 0;
			boolean ok = true;
			for (int blockStart = 0; blockStart < A.length; blockStart += blockLength) {
				boolean foundPeak = false;
				while (currentPeak < peaks.size()) {
					if (peaks.get(currentPeak) < blockStart + blockLength) {
						foundPeak = true;
						currentPeak++;
					} else if (peaks.get(currentPeak) >= blockStart + blockLength) {
						break;
					}
				}
				if (!foundPeak) {
					ok = false;
					break;
				}
			}

			if (ok) {
				return A.length / blockLength;
			}
		}
		return 1;
	}

	public int solution1(int[] A) {
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
		if (peaks.size() == 0) {
			return 0;
		}

		// strategy: each block should have at least one peak
		for (int blockLength = 3; blockLength <= A.length / 2; blockLength++) {
			if (A.length % blockLength != 0) {
				continue;
			}

			int numOfBlock = A.length / blockLength;
			System.out.println("numOfBlock: " + numOfBlock);
			int currentPeak = 0;
			for (int blockStart = 0; blockStart < A.length; blockStart += blockLength) {
				boolean foundPeak = false;
				while(currentPeak < peaks.size()) {
					System.out.println("currentPeak: " + currentPeak);
					currentPeak ++;
				}
			}
			System.out.println("---");
		}

		return 1;
	}

	public static void main(String[] args) {
		Peaks p = new Peaks();
		System.out.println("Flags: " + p.solution1(new int[] { 1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 }));
	}
}
