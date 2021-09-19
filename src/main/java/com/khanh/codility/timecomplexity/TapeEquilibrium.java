package com.khanh.codility.timecomplexity;

public class TapeEquilibrium {

	/**
	 * A non-empty array A consisting of N integers is given. Array A represents
	 * numbers on a tape.
	 * 
	 * Any integer P, such that 0 < P < N, splits this tape into two non-empty
	 * parts: A[0], A[1], ..., A[P minus 1] and A[P], A[P + 1], ..., A[N minus 1].
	 * 
	 * The difference between the two parts is the value of: |(A[0] + A[1] + ... +
	 * A[P minus 1]) minus (A[P] + A[P + 1] + ... + A[N minus 1])|
	 * 
	 * In other words, it is the absolute difference between the sum of the first
	 * part and the sum of the second part.
	 * 
	 * For example, consider array A such that:
	 * 
	 * A[0] = 3 A[1] = 1 A[2] = 2 A[3] = 4 A[4] = 3 We can split this tape in four
	 * places:
	 * 
	 * P = 1, difference = |3 minus 10| = 7 P = 2, difference = |4 minus 9| = 5 P =
	 * 3, difference = |6 minus 7| = 1 P = 4, difference = |10 minus 3| = 7 Write a
	 * function:
	 * 
	 * class Solution { public int solution(int[] A); }
	 * 
	 * that, given a non-empty array A of N integers, returns the minimal difference
	 * that can be achieved.
	 * 
	 * For example, given:
	 * 
	 * A[0] = 3 A[1] = 1 A[2] = 2 A[3] = 4 A[4] = 3 the function should return 1, as
	 * explained above.
	 * 
	 * Write an efficient algorithm for the following assumptions:
	 * 
	 * N is an integer within the range [2..100,000]; each element of array A is an
	 * integer within the range [minus 1,000..1,000].
	 */
	public int solution(int[] A) { // 84%
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}

		int minTape = Integer.MAX_VALUE;
		int sumPart1 = 0;
		int sumPart2 = 0;
		for (int i = 0; i <= A.length - 1; i++) {
			sumPart1 += A[i];
			sumPart2 = sum - sumPart1;
			int tape = sumPart1 - sumPart2;
			if (tape < 0) {
				tape = -tape;
			}
			minTape = Math.min(minTape, tape);
		}
		return minTape;
	}

	// 100%
	public int solution1(int[] A) {
		int sumRight = 0;
		for (int i = 0; i < A.length; i++) {
			sumRight += A[i];
		}

		int minTape = Integer.MAX_VALUE;
		int sumLeft = 0;
		for (int i = 0; i < A.length - 1; i++) {
			sumRight -= A[i];
			sumLeft += A[i];
			int tape = sumLeft - sumRight;
			if (tape < 0) {
				tape = -tape;
			}
			minTape = Math.min(tape, minTape);
		}
		return minTape;
	}

	public static void main(String[] args) {
		TapeEquilibrium t = new TapeEquilibrium();
		System.out.println("minTape: " + t.solution(new int[] { 3, 1, 2, 4, 3 }));
	}
}
