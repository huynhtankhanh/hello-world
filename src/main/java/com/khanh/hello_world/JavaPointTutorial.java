package com.khanh.hello_world;

import java.util.HashSet;
import java.util.Set;

public class JavaPointTutorial implements Cloneable {
	int data = 50;

	public void change(int data) {
		data = data + 100;// changes will be in the local variable only
		System.out.println("Data on change: " + data);
	}
	
	// ONLY use in class
	private void eat() {
		System.out.println("dog is eating...");
	}

	public static void main(int[] args) {
		System.out.println("Main with int");
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		JavaPointTutorial solution = new JavaPointTutorial();
		solution.eat();

		System.out.println("before change " + solution.data);
		solution.change(500);
		System.out.println("after change " + solution.data);

		JavaPointTutorial a2 = (JavaPointTutorial) solution.clone();
		a2.eat();

		System.out.println("Logarithm of 28 is: " + Math.log(28));
		System.out.println("Logarithm of 4 is: " + Math.log(4));

		System.out.println("log10 of 100 is: " + Math.log10(100));
		System.out.println("log10 of 4 is: " + Math.log10(4));

		// Program to find the frequency of each element in the array
		System.out.println("Program to find the frequency of each element in the array");
		solution.frequencyElement(new int[] { 1, 2, 8, 3, 2, 2, 2, 5, 1 });

		// Program to left rotate the elements of an array
		System.out.println("Program to left rotate the elements of an array");
		solution.leftRotateEelement(new int[] { 1, 2, 3, 4, 5, 6 }, 3);

		// Program to print the duplicate elements of an array
		System.out.println();
		System.out.println("Program to print the duplicate elements of an array");
		solution.dupplicatedElement(new int[] { 1, 2, 3, 4, 5, 2, 4, 5 });
	}

	public void dupplicatedElement(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (!set.add(nums[i])) {
				System.out.println(nums[i]);
			}
		}
	}

	public void frequencyElement(int[] nums) {
		int[] fr = new int[nums.length];
		int visited = -1;
		for (int i = 0; i < nums.length; i++) {
			int count = 1;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					count++;
					// To avoid counting same element again
					fr[j] = visited;
				}
			}
			if (fr[i] != visited) {
				fr[i] = count;
			}
		}

		for (int i = 0; i < fr.length; i++) {
			if (fr[i] != visited)
				System.out.println("    " + nums[i] + "    |    " + fr[i]);
		}
		System.out.println("----------------------------------------");
	}

	/*
	 * [1, 2, 3, 4 ,5] with times 3 -> [4, 5, 1, 2, 3]
	 */
	public void leftRotateEelement(int[] nums, int times) {
		System.out.println("Original array: ");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}

		// Rotate the given array by n times toward left
		for (int i = 0; i < times; i++) {
			int j, first;
			first = nums[0];
			for (j = 0; j < nums.length - 1; j++) {
				// Shift element of array by one
				nums[j] = nums[j + 1];
			}
			// First element of array will be added to the end
			nums[j] = first;
		}

		System.out.println();
		// Displays resulting array after rotation
		System.out.println("Array after left rotation: ");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}

	}
}
