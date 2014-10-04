package com.datastructure.sorting;

public class HeapSort {
	public static void main(String argv[]) {
		Integer[] list = new Integer[] { 35, 45, 111, 4, 7, 3, 89 };
		System.out.println(" Input String ");
		System.out.print(12 + " ");
		for (Integer d : list) {
			System.out.print(d + " ");
		}
		Tree t = new Tree();
		BNode node = t.setRootNode(12);
		for (Integer value : list) {
			t.addToTree(node, value);
		}
		System.out.println("\n");
		printInOrder(node);
		System.out.println("\n");
		postorderTraversal(node);
		System.out.println("\n");
		preorderTraversal(node);

	}

	public static void printInOrder(BNode node) {
		if (node != null) {
			printInOrder(node.left);
			System.out.print(node.data + " ");
			printInOrder(node.right);
		}
	}

	private static void postorderTraversal(BNode node) {
		if (node != null) {
			postorderTraversal(node.getLeft());
			postorderTraversal(node.getRight());
			System.out.print(node.getData() + " ");
		}
	}

	public static void preorderTraversal(BNode node) {
		if (node != null) {
			System.out.print(node.getData() + " ");
			preorderTraversal(node.getLeft());
			preorderTraversal(node.getRight());
		}
	}

}

class BNode {
	Integer data = null;
	BNode left = null;
	BNode right = null;

	BNode(Integer data) {
		this.data = data;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public BNode getLeft() {
		return left;
	}

	public void setLeft(BNode left) {
		this.left = left;
	}

	public BNode getRight() {
		return right;
	}

	public void setRight(BNode right) {
		this.right = right;
	}
}

class Tree {
	BNode root = null;
	BNode current = null;

	public void addToTree(BNode current, Integer data) {
		boolean isLeftSet = false;

		if (data < current.data) {
			if (current.getLeft() == null) {
				current.left = new BNode(data);
				isLeftSet = true;
				return;
			} else if (current.getRight() != null) {
				current = current.left;
				addToTree(current, data);
				return;
			}
			if (current.getRight() == null && isLeftSet == false) {
				current.right = new BNode(data);
				isLeftSet = false;
				return;
			} else {
				current = current.right;
				addToTree(current, data);
				return;
			}
		} else {
			BNode temp = root;
			root = current;
			addToTree(temp, temp.data);
			return;
		}
	}

	public BNode setRootNode(Integer data) {
		BNode node = new BNode(data);
		if (root == null) {
			root = node;
			current = root;
			return current;
		}
		return null;
	}

}
