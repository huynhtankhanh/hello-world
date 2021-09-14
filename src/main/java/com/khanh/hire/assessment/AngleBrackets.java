package com.khanh.hire.assessment;

import java.util.Stack;

public class AngleBrackets {

	public static String solution(String angles) {
		int openCount = 0;
		int additionalOpenTags = 0;
		for (int i = 0; i < angles.length(); i++) {
			char c = angles.charAt(i);
			System.err.println("char at " + i + " = " + c);
			if (c == '>') {
				if (openCount == 0) {
					additionalOpenTags++;
				} else {
					openCount--;
				}
			} else {
				openCount++;
			}
		}

		StringBuilder openingTags = new StringBuilder();
		for (int i = 0; i < additionalOpenTags; i++) {
			openingTags.append("<");
		}

		StringBuilder closingTags = new StringBuilder();
		for (int i = 0; i < openCount; i++) {
			closingTags.append(">");
		}

		StringBuilder result = new StringBuilder();
		result.append(openingTags).append(angles).append(closingTags);
		return result.toString();
	}

	public static String solution1(String angles) {
		Stack<Character> openStack = new Stack<>();
		Stack<Character> closingstack = new Stack<>();

		for (int i = 0; i < angles.length(); i++) {
			char c = angles.charAt(i);
			if (c == '>') {
				openStack.push('<');
				if (!closingstack.isEmpty()) {
					closingstack.pop();
				}
			} else {
				closingstack.push('>');
//				if (!openStack.isEmpty()) {
//					openStack.pop();
//				}
			}
		}

		return angles;
	}

	public static void main(String[] args) {
		System.out.println(AngleBrackets.solution(">><<><"));
		System.out.println(AngleBrackets.solution1(">><<><"));
	}
}
