package com.khanh.hackerrank;

public class Staircase {
	public static void staircase(int n) {
		int i, j;
		for (i = 0; i < n; i++) {
			// print space
			// inner loop work for space
			for (j = (n - i); j > 1; j--) {
				// prints space between two stars
				System.out.print(" ");
			}
			// print star
			for (j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void rightStaircase(int n) {
		int i, j;
		for (i = 1; i <= n; i++) {
			// print star
			for (j = 0; j < i; j++) {
				System.out.print("*");
			}
			for (j = (n - i); j > 0; j--) {
				// prints space between two stars
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void pyramid(int n) {
		int i, j;
		for (i = 0; i < n; i++) {
			for (j = n - i; j > 0; j--) {
				System.out.print(" ");
			}
			// inner loop for columns
			for (j = 0; j <= i; j++) {
				// prints star
				System.out.print("* ");
			}
			// throws the cursor in a new line after printing each line
			System.out.println();
		}

	}

	public static void main(String[] args) {
		Staircase.staircase(3);
		Staircase.rightStaircase(3);
		Staircase.pyramid(6);
	}
}
