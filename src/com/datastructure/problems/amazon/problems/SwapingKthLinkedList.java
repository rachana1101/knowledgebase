package com.datastructure.problems.amazon.problems;

public class SwapingKthLinkedList {
	public static void main(String argc[]) {
		LinkedList list = new LinkedList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("8");
		list.add("9");
		list.add("10");
		list.print();
		
		list.shiftkthelement(3);
		list.print();
	}
}

class Node {
	String data;
	Node next;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node(String data) {
		this.data = data;
	}
}

class LinkedList {
	Node head = null;
	
	public void add(String data) {
		//first node
		Node current = head;
		Node temp = new Node(data);
		if(head == null) {
			head = new Node(data);
			current = head;
		} else {
			while(current.getNext()!=null) {
				current = current.getNext();
			}
			current.setNext(temp);
		}
	}
	
	public void print() {
		Node current = head;
		while(current!=null) {
			System.out.println(current.getData());
			current = current.getNext();
		}
	}
	
	public void shiftkthelement(int kth) {
		Node current = head;
		int ctr =1;
		while(current.getNext() !=null) {
			current = current.getNext();
			ctr++;
		}
		Node end = current;
		Node kthFromStart = head;
		Node beforeStart = head;
		for(int i=0;i<kth;i++) {
			beforeStart = kthFromStart;
			kthFromStart = kthFromStart.getNext();
			
		}
		//finding the kth element from end using 2 pointers
		Node endNode = kthFromStart;
		Node kthFromEnd = head;
		Node beforeKthFromEnd = head;
		while(endNode.getNext() != null) {
			endNode = endNode.getNext();
			beforeKthFromEnd = kthFromEnd;
			kthFromEnd = kthFromEnd.getNext();
			
		}
		System.out.println(">>"+beforeStart.getData());
		System.out.println(">>"+kthFromStart.getData());
		System.out.println(">>"+beforeKthFromEnd.getData());
		System.out.println(">>"+kthFromEnd.getData());

		Node temp = kthFromEnd.getNext();
		Node temp1 = kthFromStart.getNext();
		beforeStart.setNext(kthFromEnd);
		beforeKthFromEnd.setNext(kthFromStart);
		
		kthFromStart.setNext(temp);
		kthFromEnd.setNext(temp1);
		
		
		
		//now swapping 
		/*Node temp = kthFromStart;
		Node temp1 = kthFromEnd;
		kthFromEnd.setNext(temp.getNext());
		kthFromStart = temp1;


		kthFromStart.setNext(temp1.getNext());
		kthFromEnd = temp;*/
		//kthFromStart.setNext(kthFromEnd.getNext());
		//kthFromEnd.setNext(kthFromStart);

	}
}