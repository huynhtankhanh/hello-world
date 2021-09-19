package com.khanh.codility.stack;

import java.util.Stack;

public class Fish {

	/**
	 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	// 100%
	public int solution(int[] A, int[] B) {
		Stack<Integer> stack = new Stack<>();
		int survivals = 0;
		for (int i = 0; i < A.length; i++) {
			int fish = A[i];
			int direction = B[i];
			if (direction == 0) {
				boolean survive = true;
				while (!stack.isEmpty()) {
					int oppFish = stack.pop();
					if (oppFish > fish) {
						stack.push(oppFish);
						survive = false;
						break;
					}
				}
				if (survive) {
					survivals++;
				}
			} else {
				stack.push(fish);
			}
		}
		survivals += stack.size();
		return survivals;
	}

	// WRONG ANSWER
	public int solution1(int[] A, int[] B) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < A.length; i++) {
			int fish = A[i];
			int direction = B[i];
			if (direction == 0 && !stack.isEmpty()) {
				int oppFish = stack.pop();
				if (oppFish < fish) {
					stack.push(fish);
				}
			} else {
				stack.push(fish);
			}
		}

		return stack.size();
	}

	public static void main(String[] args) {
		Fish f = new Fish();
		System.out.println(f.solution(new int[] { 4, 3, 2, 1, 5 }, new int[] { 0, 1, 0, 0, 0 }));
//		System.out.println(f.solution(new int[] { 4, 3, 2, 1, 0 }, new int[] { 1, 0, 0, 0, 0 }));
	}
}
