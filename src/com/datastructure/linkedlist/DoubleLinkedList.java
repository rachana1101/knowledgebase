package com.datastructure.linkedlist;

public class DoubleLinkedList {
	public static void main(String argc[]) {
		DLinkedList list = new DLinkedList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.addAtIndex(2, "2.5");
		list.addAtIndex(5, "3.5");
		list.print();
		list.removeAtIndex(4);
		list.print();
		list.printReverse();
	}
}

class DNode {
	String data = null;
	DNode previous = null;
	DNode next = null;
	public DNode(String data) {
		this.data = data;
	}
	public DNode getPrevious() {
		return previous;
	}
	public void setPrevious(DNode previous) {
		this.previous = previous;
	}
	public DNode getNext() {
		return next;
	}
	public void setNext(DNode next) {
		this.next = next;
	}
}

class DLinkedList {
	DNode head = null;
	DNode current = null;
	public void add(String data) {
		current = head;
		DNode temp = new DNode(data);
		if(head==null) {
			head = new DNode(data);
		} else {
			while(current.getNext()!=null) {
				current = current.getNext();
			}
			temp.setPrevious(current);
			current.setNext(temp);
		}
	}
	
	public void addAtIndex(int index, String data) {
		DNode current = head;
		int ctr =1;
		while(ctr != index) {
			current = current.getNext();
			ctr++;
		}
		
		DNode newNode = new DNode(data);
		newNode.setNext(current.getNext());
		newNode.setPrevious(current);
		current.setNext(newNode);
	}
	
	public void removeAtIndex(int index) {
		DNode current = head;
		int ctr =1;
		while(ctr != index) {
			current = current.getNext();
			ctr++;
		}
		DNode toBeRemove = current.getNext();
		current.setNext(toBeRemove.getNext());
		toBeRemove.getNext().setPrevious(current);
	}
	
	public void print() {
		DNode current = head;
		while(current!=null) {
			System.out.println(current.data);
			current = current.getNext();
		}
		System.out.println("\n===============\n");
	}
	
	public void printReverse() {
		DNode current = head;
		while(current.getNext()!=null) {
			current = current.getNext();
		}
		while(current!=null) {
			System.out.println(current.data);
			current = current.getPrevious();
		}
	}
}