package com.khanh.hello_world;

public class JavaLoop {

	public static void main(String[] args) {
		// Java Labeled For Loop
		// Example 1
		aa: for (int i = 1; i <= 3; i++) {
			bb: for (int j = 1; j <= 3; j++) {
				if (i == 2 && j == 2) {
					break aa;
				}
				System.out.println(i + " " + j);
			}
		}

		System.out.println("Start example 2 =============");
		// Example 2 If you use break bb;, it will break inner loop only which is the
		// default behaviour of any loop.
		aa: for (int i = 1; i <= 3; i++) {
			bb: for (int j = 1; j <= 3; j++) {
				if (i == 2 && j == 2) {
					break bb;
				}
				System.out.println(i + " " + j);
			}
		}

		// Java Infinitive for Loop
//		for (;;) {
//			// code to be executed
//		}

		int i = 0;
		do {
			System.out.println("Hey you!");
			i++;
		} while (i < 2);
		System.out.println("i=" + i);
	}
}
