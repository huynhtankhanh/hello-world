package com.khanh.codility.stack;

import java.util.Stack;

public class StoneWall {

	/**
	 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/
	 * 
	 * @param H
	 * @return
	 */
	// Strategy: When new block comming, check checking previous block > current
	// block then remove prev block, otherwise count block.
	public int solution(int[] H) { // 100%
		Stack<Integer> stack = new Stack<>();
		int count = 0;
		for (int i = 0; i < H.length; i++) {
			while (!stack.isEmpty() && stack.peek() > H[i]) {
				stack.pop();
			}
			if (stack.isEmpty() || stack.peek() != H[i]) {
				stack.push(H[i]);
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		StoneWall s = new StoneWall();
		System.out.println(s.solution(new int[] { 8, 8, 5, 7, 9, 8, 7, 4, 8 }));
	}
}
