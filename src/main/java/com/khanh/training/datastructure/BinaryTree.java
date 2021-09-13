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

	public boolean remove(int key) {
		Node focusNode = root;
		Node parent = root;
		boolean isItALeftChild = true;

		while (focusNode.key != key) {
			parent = focusNode;
			if (key < focusNode.key) {
				isItALeftChild = true;
				focusNode = focusNode.left;
			} else {
				isItALeftChild = false;
				focusNode = focusNode.right;
			}

			if (focusNode == null) {
				return false;
			}
		}

		// If Node doesn't have children delete it
		if (focusNode.left == null && focusNode.right == null) {
			// If root delete it
			if (focusNode == root) {
				root = null;
			} else if (isItALeftChild) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if (focusNode.right == null) { // left is not null, right is null
			if (focusNode == root) {
				root = focusNode.right;

				// If focus Node was on the left of parent
				// move the focus Nodes left child up to the parent node
			} else if (isItALeftChild) {
				parent.left = focusNode.right;
			} else {
				parent.right = focusNode.right;

			}
		} else { // both children
			Node replacement = getReplacementNode(focusNode);

			// If the focusNode is root replace root with the replacement
			if (focusNode == root) {
				root = replacement;
			} else if (isItALeftChild) {
				parent.left = replacement;
			} else {
				parent.right = replacement;
			}
			replacement.left = focusNode.left;
		}

		return true;
	}

	public Node getReplacementNode(Node replacedNode) {
		Node replacementParent = replacedNode;
		Node replacement = replacedNode;
		Node focusNode = replacedNode.right;

		// While there are no more left children
		while (focusNode != null) {
			replacementParent = replacement;
			replacement = focusNode;
			focusNode = focusNode.left;
		}

		// If the replacement isn't the right child
		// move the replacement into the parents
		// leftChild slot and move the replaced nodes
		// right child into the replacements rightChild
		if (replacement != replacedNode.right) {
			replacementParent.left = replacement.right;
			replacement.right = replacedNode.right;
		}
		return replacement;
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
		theTree.addNode(8, "8");
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
		
		/**
		 * Original tree
		 * 				3
		 * 			2		6
		 * 		-1		5		9
		 * 					8		10
		 * if Remove 6
		 * 				3
		 * 			2		8
		 * 		-1		5		9
		 * 							10
		 * => Find replacement node of 6 is the right node of 6 is 9
		 * if 9 has left node, then replace node is 8
		 * assign left node of old 6 is 5 to left node of 8
		 */
		boolean isRemoved = theTree.remove(6);
		System.out.println(isRemoved);
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