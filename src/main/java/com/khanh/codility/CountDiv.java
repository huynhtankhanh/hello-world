package com.khanh.codility;

public class CountDiv {

	/**
	 * https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
	 * 
	 * @param A
	 * @param B
	 * @param K
	 * @return
	 */
	// 25%
//	public int solution(int A, int B, int K) {
//		int count = 0;
//		for (int i = A; i <= B; i++) {
//			if (i % 2 == 0) {
//				count++;
//			}
//		}
//		return count;
//	}

//	public int solution(int A, int B, int K) {
//		int base = (int) Math.ceil((double) A / K);
//		base *= K;
//		B -= base;
//		int count = (int) Math.floor((double) B / K);
//		count++;
//		return count;
//	}

	public int solution(int A, int B, int K) {
		int min = (int) Math.ceil((double) A / K);
		int max = (int) Math.floor((double) B / K);
		return (max - min) + 1;
	}

	public static void main(String[] args) {
		CountDiv c = new CountDiv();
		int result = c.solution(4, 11, 2);
		System.out.println(result);
	}
}
