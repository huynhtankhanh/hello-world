package com.khanh.hire.assessment;

import java.util.ArrayList;
import java.util.List;


public class TestTree {
	Node root;

	// Tree Node
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	// Function to insert nodes in level order
	public Node insertLevelOrder(int[] arr, Node root, int i) {
		if (i < arr.length && arr[i] > 0) {
			Node temp = new Node(arr[i]);
			root = temp;

			// insert left child
			int indexLeft = 2 * i + 1;
			root.left = insertLevelOrder(arr, root.left, indexLeft);

			// insert right child
			int indexRight = 2 * i + 2;
			root.right = insertLevelOrder(arr, root.right, indexRight);
		}
		return root;
	}

	public List<Integer> traversalNodeValue(Node node) {
		List<Integer> leftValues = new ArrayList<>();
		if (node == null) {
			return leftValues;
		}
		leftValues.add(node.data);
		leftValues.addAll(traversalNodeValue(node.left));
		leftValues.addAll(traversalNodeValue(node.right));
		return leftValues;
	}


	public int sumLeftNode(Node node) {
		List<Integer> left = traversalNodeValue(node.left);
		return left.stream().reduce(0, (a, b) -> (a + b));
	}

	public int sumRightNode(Node node) {
		List<Integer> left = traversalNodeValue(node.right);
		return left.stream().reduce(0, (a, b) -> (a + b));
	}

	// Driver program to test above function
	public static void main(String args[]) {
		TestTree t2 = new TestTree();
		int arr[] = { 3, 6, 2, 9, -1, 10 };
		t2.root = t2.insertLevelOrder(arr, t2.root, 0);

		System.out.println(t2.sumLeftNode(t2.root));
		System.out.println(t2.sumRightNode(t2.root));
	}
}