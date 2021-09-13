package com.khanh.hello_world;

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
	}
}

class Tree {
	TreeNode root;

	public void addNode(int key) {
		TreeNode newNode = new TreeNode(key);
		if (root == null) {
			root = newNode;
		} else {
			// Set root as the Node we will start with as we traverse the tree
			TreeNode focusNode = root;

			// Future parent for our new Node
			TreeNode parent;
			while (true) {
				parent = focusNode;
				// Check if the new node should go on the left side of the parent node
				if (key < parent.val) {
					focusNode = focusNode.left;

					if (focusNode == null) {
						parent.left = newNode;
						return;
					}

				} else {
					focusNode = focusNode.right;
					if (focusNode == null) {
						parent.right = newNode;
						return;
					}
				}
			}

		}
	}

	public TreeNode initTree(int[] arrays) {
		for (int i = 0; i < arrays.length; i++) {
			addNode(arrays[i]);
		}

		return root;
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.addNode(3);
		tree.addNode(6);
		tree.addNode(2);
		tree.addNode(5);
		tree.addNode(9);
		tree.addNode(-1);
		tree.addNode(10);
	}
}
