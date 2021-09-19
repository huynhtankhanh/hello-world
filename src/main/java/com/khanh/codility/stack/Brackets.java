package com.khanh.codility.stack;

import java.util.Stack;

public class Brackets {
	public int brackets(String S) {
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
		return (left == '{' && right == '}') || (left == '(' && right == ')') || (left == '[' && right == ']');
	}

	public static void main(String[] args) {
		Brackets solution = new Brackets();
		System.out.println("{[()]} => " + solution.brackets("{[()]}")); // => 1
		System.out.println("([)()] => " + solution.brackets("([)()]")); // => 0
	}
}
