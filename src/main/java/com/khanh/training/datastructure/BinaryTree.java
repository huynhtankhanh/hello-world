package com.khanh.training.datastructure;

public class BinaryTree {
	Node root;

	@Override
	public String toString() {
		return "BinaryTree [root=" + root + "]";
	}

	public void addNode(int key, String name) {
		Node newNode = new Node(key, name);
		if (root == null) {
			root = newNode;
		} else {
			// Set root as the Node we will start with as we traverse the tree
			Node focusNode = root;

			// Future parent for our new Node
			Node parent;
			while (true) {
				parent = focusNode;
				// Check if the new node should go on the left side of the parent node
				if (key < parent.key) {
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

	// All nodes are visited in ascending order
	// Recursion is used to go to one node and
	// then go to its child nodes and so forth
	public void inOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			inOrderTraverseTree(focusNode.left);
			System.out.println(focusNode);
			inOrderTraverseTree(focusNode.right);
		}
	}

	public void preorderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			System.out.println(focusNode);
			preorderTraverseTree(focusNode.left);
			preorderTraverseTree(focusNode.right);
		}
	}

	public void postOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			postOrderTraverseTree(focusNode.left);
			postOrderTraverseTree(focusNode.right);
			System.out.println(focusNode);
		}
	}

	public Node findNode(int key) {
		Node focusNode = root;
		while (focusNode.key != key) {
			if (key < focusNode.key) {
				focusNode = focusNode.left;

			} else {
				focusNode = focusNode.right;
			}

			if (focusNode == null) {
				return null;
			}

		}
		return focusNode;

	}

	public int maxDepth(Node root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
		}
	}

	public static void main(String[] args) {
		/**
		 * 3 2 6 -1 5 9 10
		 */
		BinaryTree theTree = new BinaryTree();
		theTree.addNode(3, "root");
		theTree.addNode(6, "6");
		theTree.addNode(2, "2");
		theTree.addNode(5, "5");
		theTree.addNode(9, "9");
		theTree.addNode(-1, "-1");
		theTree.addNode(10, "10");
		System.out.println(theTree);

		System.out.println("inOrderTraverseTree=====");
		theTree.inOrderTraverseTree(theTree.root);

		System.out.println("preorderTraverseTree=====");
		theTree.preorderTraverseTree(theTree.root);

		System.out.println("postOrderTraverseTree=====");
		theTree.postOrderTraverseTree(theTree.root);

		System.out.println("=====Find node");
		System.out.println(theTree.findNode(9));
		
		System.out.println("Max Depth");
		int maxDepth = theTree.maxDepth(theTree.root);
		System.out.println(maxDepth);

	}
}

class Node {
	int key;
	String name;

	Node left;
	Node right;

	Node(int key, String name) {
		this.key = key;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Node [key=" + key + ", name=" + name + "]";
	}
}

//Pre-order Traversal
//Pre-order traversal is to visit the root first. Then traverse the left subtree. Finally, traverse the right subtree.

//In-order Traversal
//In-order traversal is to traverse the left subtree first. Then visit the root. Finally, traverse the right subtree.

//Post-order Traversal
//Post-order traversal is to traverse the left subtree first. Then traverse the right subtree. Finally, visit the root.