package com.datastructure.problems.amazon.problems;

public class Maxheap {
	public static void main(String argv[]) {
		Integer[] list = new Integer[]{6,7,5,2,8,9};
		MaxHeapCreator heapCreator = new MaxHeapCreator();
		MHNode root = heapCreator.setRootNode(1);
		for(Integer data: list) {
			heapCreator.add(root,data);
			
		}
		printInOrder(root);
	}
	
	public static void printInOrder(MHNode node) {
		if(node!=null) {
			printInOrder(node.left);
			System.out.print(node.getData()+" ");
			printInOrder(node.right);
		}
	}
}

class MHNode {
	Integer data;
	MHNode left;
	MHNode right;
	public MHNode(Integer data) {
		this.data = data;
	}
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public MHNode getLeft() {
		return left;
	}
	public void setLeft(MHNode left) {
		this.left = left;
	}
	public MHNode getRight() {
		return right;
	}
	public void setRight(MHNode right) {
		this.right = right;
	}
	
}

class MaxHeapCreator {
	MHNode root = null;
	MHNode current = null;
	MHNode previous = null;
	public void add(MHNode current,Integer data) {
			System.out.println(data);
			
			if(current.getLeft()!=null && current.getRight()!=null){
				if(previous==null) {
					current = current.getLeft();
				} else {
					if(previous.getRight()!=null) {
						current = current.getLeft();
					} else {
						current = current.getRight();
					}
				}
				previous = current;
				add(current, data);
				return;
			}
			if(current.getLeft()==null) {
				current.setLeft(new MHNode(data));
				if(data>current.getData()) {
					MHNode temp = current;
					current = new MHNode(data);
					current.setLeft(temp);
				} else {
					current.setLeft(new MHNode(data));
				}
				
				return;
			}
			if(current.getLeft()!=null && current.getRight()==null) {
				if(data>current.getData()) {
					MHNode temp = current;
					current = new MHNode(data);
					current.setRight(temp);
				} else {
					current.setRight(new MHNode(data));
				}
				return;
			}
			
			
	}
	
	public MHNode setRootNode(Integer data) {
		MHNode node = new MHNode(data);
		if(root == null) {
			root = node;
			current = root;
			return current;
		}
		return null;
	}
}