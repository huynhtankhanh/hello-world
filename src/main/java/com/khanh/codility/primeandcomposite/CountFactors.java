package com.khanh.codility.primeandcomposite;

/**
 * https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/
 * 
 * @author htkhanh
 *
 */
public class CountFactors {

	// 71%
//	public int solution(int N) {
//		int count = 0;
//		for (int i = 1; i <= N; i++) {
//			if (N % i == 0) {
//				count++;
//			}
//		}
//		return count;
//	}

	public int solution(int N) {
		int count = 0;
		double squareRoot = Math.sqrt(N);
		for (int i = 1; i <= squareRoot; i++) {
			if (N % i == 0) {
				if (i < squareRoot) { // there is a opposite value of i so + 2
					count += 2;
				} else {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		CountFactors c = new CountFactors();
		System.out.println(c.solution(24));
		System.out.println(c.solution(16));
	}
}
