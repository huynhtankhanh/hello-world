package com.khanh.codility.stack;

import java.util.Stack;

public class Nesting {
	/**
	 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/
	 * 
	 * @param S
	 * @return
	 */
	// 100%
	public int solution(String S) {
		Stack<Character> stack = new Stack<Character>();
		for (Character c : S.toCharArray()) {
			if (!stack.isEmpty() && isValid(stack.peek(), c)) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty() ? 1 : 0;
	}

	private static boolean isValid(char left, char right) {
		return (left == '(' && right == ')');
	}

	public static void main(String[] args) {
		Nesting n = new Nesting();
		System.out.println(n.solution("(()(())())"));
		System.out.println(n.solution("())"));
	}
}
