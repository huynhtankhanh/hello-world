package com.khanh.hire.assessment;

import java.util.ArrayList;
import java.util.List;

/**
 * In case of do not care about order value
 * @author DELL
 *
 */
public class BinaryTreeCompare {
	public static String solution(long[] arr) {
		if (arr.length == 0) {
			return "";
		}
		Tree tree = new Tree();
		tree.root = tree.insertLevelOrder(arr, tree.root, 0);
		
		List<Long> leftValues = tree.traversalNodeValue(tree.root.left);
		long sumLeft = leftValues.stream().reduce(0l, (a,b) -> {
			return a + b;
		});
		
		List<Long> rightValues = tree.traversalNodeValue(tree.root.right);
		long sumRight = rightValues.stream().reduce(0l, (a,b) -> {
			return a + b;
		});
		if(sumLeft > sumRight) {
			return "Left";
		} else if(sumLeft < sumRight) {
			return "Right";
		}
		return "";
	}

	public static void main(String[] args) {
		long[] arr = { 3l, 6l, 2l, 9l, -1l, 10l};
		System.out.println("length: " + arr.length);
		
		String result = BinaryTreeCompare.solution(arr);
		System.out.println(result);
	}
}

class Tree {
	Node root;

	public Node insertLevelOrder(long[] arr, Node root, int i) {
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
	
	public List<Long> traversalNodeValue(Node node) {
		List<Long> values = new ArrayList<>();
		if (node == null) {
			return values;
		}
		values.add(node.data);
		values.addAll(traversalNodeValue(node.left));
		values.addAll(traversalNodeValue(node.right));
		return values;
	}
}

class Node {
	long data;
	Node left, right;

	Node(long data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
