package com.khanh.codility.prefixsums;

public class PassingCars {
	/**
	 * https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/
	 * 
	 * @param A
	 * @return
	 */
	// 50%
//	public int solution(int[] A) {
//		int count = 0;
//		for (int i = 0; i < A.length - 1; i++) {
//			for (int j = i + 1; j < A.length; j++) {
//				if (A[i] == 0 && A[j] == 1) {
//					count++;
//				}
//			}
//		}
//		return count;
//	}

	// 70%
//	public int solution(int[] A) {
//		int passingCars = 0;
//		int carHeadToEasts = 0;
//		for (int i = 0; i < A.length; i++) {
//			if (A[i] == 0) {
//				carHeadToEasts++;
//			} else {
//				passingCars += carHeadToEasts;
//				if (passingCars > Integer.MAX_VALUE) {
//					return -1;
//				}
//			}
//		}
//
//		return passingCars;
//	}

	// 100%
	public int solution(int[] A) {
		int passingCars = 0;
		int carHeadToEasts = 0;
		for (int a : A) {
			if (a == 0) {
				carHeadToEasts++;
			} else {
				passingCars += carHeadToEasts;
				if (passingCars > 1000000000) {
					return -1;
				}
			}
		}

		return passingCars;
	}

	public static void main(String[] args) {
		PassingCars p = new PassingCars();
		int result = p.solution(new int[] { 0, 1, 0, 1, 1, 1 });
		System.out.println(result);

		System.out.println(0 ^ 1);
		System.out.println(1 ^ 0);
		System.out.println(1 ^ 1);
	}
}
