package com.khanh.hello_world;

import java.util.Iterator;

// Definition for a binary tree node.

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public void testNestedFor() {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (j <= 10) {
					System.out.println("i=" + i + " j=" + j);
//					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		// create a StringBuilder object
		// with a String pass as parameter
		StringBuilder str = new StringBuilder("(]");

		// print string
		System.out.println("String = " + str.toString());

		// reverse the string
		StringBuilder reverseStr = str.reverse();

		// print string
		System.out.println("Reverse String = " + reverseStr.toString());

		TreeNode treeNode = new TreeNode();
		treeNode.testNestedFor();

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();// new line
		}

	}
}
