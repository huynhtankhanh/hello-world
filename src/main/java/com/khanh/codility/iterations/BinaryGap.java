package com.khanh.codility.iterations;

public class BinaryGap {
	public int solutionBinaryGap(int N) {
		String bStr = Integer.toBinaryString(N);
		System.out.println("bStr: " + bStr);

		boolean started = false;
		int counter = 0, maxCounter = 0;
		for (int i = 0; i < bStr.length(); i++) {
			String c = bStr.substring(i, i + 1);
			if (c.equals("0")) {
				counter++;
			}

			if (c.equals("1")) {
				if (started && counter > maxCounter) {
					maxCounter = counter;
				}
				counter = 0;
				started = true;
			}
		}
		return maxCounter;
	}

	/**
	 * difference way
	 * 
	 * @param N
	 * @return
	 */
//	public int solutionBinaryGap(int N) {
//		int pos = 0;
//		int lastPos = -1;
//		int distance = 0;
//		while (N > 0) {
//			if ((N & 1) == 1) {
//				if (lastPos != -1) {
//					distance = Math.max(distance, pos - lastPos);
//				}
//				lastPos = pos;
//			}
//			N = N >>> 1;
//			pos++;
//		}
//		return distance == 0 ? distance : distance - 1;
//	}
	
	public static void main(String[] args) {
		BinaryGap solution = new BinaryGap();

		// Binary Gap
		System.out.println("// Binary Gap");
		System.out.println(solution.solutionBinaryGap(5)); // 101 -> 1
		System.out.println(solution.solutionBinaryGap(9)); // 1001 -> 2
		System.out.println(solution.solutionBinaryGap(8)); // 1000 -> 0
		System.out.println(solution.solutionBinaryGap(33)); // 100001 -> 4
		System.out.println(solution.solutionBinaryGap(32)); // 100000 -> 0
		System.out.println(solution.solutionBinaryGap(1)); // 0001 -> 0
	}
}
