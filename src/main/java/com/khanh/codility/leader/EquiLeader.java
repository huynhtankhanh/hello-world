package com.khanh.codility.leader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://app.codility.com/programmers/lessons/8-leader/equi_leader/
 * 
 * @author DELL
 *
 */
public class EquiLeader {

	// 55%
	public int solution(int[] A) {
		List<Integer> leftPart = new ArrayList<>();
		List<Integer> rightPart = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {
			rightPart.add(A[i]);
		}

		int count = 0;
		for (int i = 0; i < A.length; i++) {
			leftPart.add(A[i]);
			rightPart.set(i, -1);

			int leftLeader = findDominatingValue(leftPart);
			int rightLeader = findDominatingValue(rightPart);
			if (leftLeader == rightLeader && leftLeader != -1) {
				count++;
			}
		}

		return count;
	}

	public int findDominatingValue(List<Integer> A) {
		A = A.stream().filter(item -> item != -1).collect(Collectors.toList());
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.size(); i++) {
			int num = A.get(i);
			if (!count.containsKey(num)) {
				count.put(num, 1);
			} else {
				count.put(num, count.get(num) + 1);
			}
			if (count.get(num) > (A.size() / 2)) {
				return A.get(i);
			}
		}

		return -1;
	}

	// 100%
	public int solution1(int[] A) {
		if (A.length == 0) {
			return 0;
		}

		// find leader of array, if array has leader then check sub leader next step
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int leaderValue = A[0];
		int leaderCount = 0;
		for (int i = 0; i < A.length; i++) {
			int num = A[i];
			if (!map.containsKey(num)) {
				map.put(A[i], 1);
			} else {
				map.put(num, map.get(num) + 1);
			}
			if (map.get(num) > A.length / 2) {
				leaderCount = map.get(num);
				leaderValue = num;
			}
		}

		// if no leader, then return 0
		if (leaderCount == 0 || leaderCount <= A.length / 2) {
			return 0;
		}

		// if having leader in array, then comparing leader left and right
		int totalLeaderCount = 0;
		int leftLeaderCount = 0;
		for (int i = 0; i < A.length; i++) {
			int num = A[i];
			if (num == leaderValue) {
				leftLeaderCount++;
			}
			if (leftLeaderCount > (i + 1) / 2) {
				int rightLeaderCount = leaderCount - leftLeaderCount;
				if (rightLeaderCount > (A.length - 1 - i) / 2) {
					totalLeaderCount++;
				}
			}
		}
		return totalLeaderCount;
	}

	public static void main(String[] args) {
		EquiLeader e = new EquiLeader();
		System.out.println(e.solution(new int[] { 4, 3, 4, 4, 4, 2 }));

		System.out.println(e.solution1(new int[] { 4, 3, 4, 4, 4, 2 }));
	}
}
