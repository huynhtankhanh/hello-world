package com.khanh.codility.leader;

import java.util.HashMap;
import java.util.Map;

public class Dominator {

	/**
	 * https://app.codility.com/programmers/lessons/8-leader/dominator/
	 * 
	 * @param A
	 * @return
	 */
	// 100%
	public int solution(int[] A) {
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			int num = A[i];
			if (!count.containsKey(num)) {
				count.put(num, 1);
			} else {
				count.put(num, count.get(num) + 1);
			}
			if (count.get(num) > (A.length / 2)) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		Dominator d = new Dominator();
		System.out.println(d.solution(new int[] { 3, 4, 3, 2, 3, -1, 3, 3 }));
	}
}
