package ch.klara.hello_world;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class CodilitySolution {

	/**
	 * Easy way
	 */
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

	public int solutionJumpingFrog(int X, int Y, int D) {
		int distance = Y - X;
		return new BigDecimal(distance).divide(new BigDecimal(D), RoundingMode.UP).intValue();
	}

	public int solutionBrackets(String S) {
		Stack<Character> stack = new Stack<Character>();
		for (Character c : S.toCharArray()) {
			if (stack.isEmpty()) {
				stack.push(c);
			} else if (isValid(stack.peek(), c)) {
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
		CodilitySolution solution = new CodilitySolution();

		// Binary Gap
		System.out.println("// Binary Gap");
		System.out.println(solution.solutionBinaryGap(5)); // 101 -> 1
		System.out.println(solution.solutionBinaryGap(9)); // 1001 -> 2
		System.out.println(solution.solutionBinaryGap(8)); // 1000 -> 0
		System.out.println(solution.solutionBinaryGap(33)); // 100001 -> 4
		System.out.println(solution.solutionBinaryGap(32)); // 100000 -> 0

		// Jumping frog
		System.out.println("Jumping frog");
		System.out.println(solution.solutionJumpingFrog(10, 85, 30));

		// brackets
		System.out.println("{[()]} => " + solution.solutionBrackets("{[()]}")); // => 1
		System.out.println("([)()] => " + solution.solutionBrackets("([)()]")); // => 0
	}
}
