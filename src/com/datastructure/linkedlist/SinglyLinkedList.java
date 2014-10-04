package com.datastructure.linkedlist;

public class SinglyLinkedList {
	public static void main(String argv[]) {
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(7);
		//list.printList();
		
		list.add(8,2);
		list.add(5,1);
		//list.printList();
		list.add(3,4);
		list.printList();
		
		//list.reverseList();
		//list.printList();
		
		//list.countNodes();
		//list.makeItCyclic();
		//list.countNoCyclic();
		
		//list.sort();
		list.printList();
	}
}

class Node<E> implements Comparable{
	E data;
	public Node next;
	
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node(E data) {
		this.data = data;
	}
	public int compareTo(Object arg0) {
		return 0;
	}
}

class LinkedList<E> {
	Node head = null;
	Node current = null;
	static int ctr = 0;
	public LinkedList() {
	}
	public void add(Integer data) {
		Node temp = new Node(data);
		if(ctr==0) {
			head = temp;
			current = head;
		} else {
			while(current.getNext()!=null) {
				current = current.getNext();
			}
			current.setNext(temp);
		}
		ctr++;
	}
	
	public void add(Integer data, int index) {
		Node newNode = new Node(data);
		if(index==1) {
			newNode.setNext(head);
			head = newNode;
		} else if (index==ctr) {
			head.setNext(newNode);
		} else {
			for(int i=0;i<index-2;i++) {
				current = current.getNext();
			}
			newNode.setNext(current.getNext());
			current.setNext(newNode);
		}
		ctr++;
	}
	
	public void printList() {
		Node current = head;
		String output = "";
		while(current != null)
		{
			output += "[" + current.data.toString() + "]";
			current = current.getNext();
		}
		System.out.println(output);
	}
	
	public void reverseList() {
		Node temp = head;
		Node temp2 = head.getNext();
		do {
			if(temp == head) {temp.setNext(null);}
			Node temp3 = temp2.getNext();
			temp2.setNext(temp);
			temp = temp2;
			temp2 = temp3;
			//temp3 = temp3.getNext();
		}while(temp2.getNext()!=null);
		
		head = temp2;
		head.setNext(temp);
	}
	
	public void countNodes() {
		int ctr = 1;
		Node current = head;
		while(current.next!=null) {
			ctr++;
			current = current.next;
		}
		System.out.println(ctr);
	}
	
	public void makeItCyclic() {
		Node current = head;
		while(current.next!=null) {
			current = current.next;
		}
		current.setNext(head);
		int ctr = 1;
		while(current.getNext()!=null){
			current = current.next;
			System.out.println(current.data);
			ctr++;
		}
	}
	
	public void countNoCyclic() {
		Node current = head.getNext();
		Node nextToNext = current.getNext();
		do {
			current = current.getNext();
			nextToNext = nextToNext.getNext();
		}while(current!=nextToNext);
	}
	
	/*public void insertionSort() {
		current = head;
		Node temp = head;
		for(int i=1;i<6;i++) {
			int j = 0;
			while(j<=i && temp!=null) {
				if(temp.data > temp.getNext().data) {
					Node temp1  = temp;
					temp = temp.getNext();
					temp.getNext().setNext(temp1);
				}
				temp = temp.getNext();
				j++;
			}
		}
	}*/
	
	/*public void sort() {
		current = head;
		Node position = head;
		Node previous = null;
		Node a = null;
		while(position.getNext()!=null) {
			current = position.getNext();
			previous = position;
			a = current.getNext();
			while(a!=null) {
				if(a.data < current.data) {
					Node temp = a.next;
					a.next = previous.next;
					previous.next = current.next;
					current.next = temp;
					previous = a;
					a  = temp;
				} else {
					a = a.getNext();
					current = current.getNext();
					previous = previous.getNext();
				}
				
			}
			position = position.getNext();
		}
		head = head.getNext();
	}*/
	
	/**
	 * public ListNode Reverse(ListNode list)
{
    if (list == null) return null; // first question

    if (list.next == null) return list; // second question

    // third question - in Lisp this is easy, but we don't have cons
    // so we grab the second element (which will be the last after we reverse it)

    ListNode secondElem = list.next;

    // bug fix - need to unlink list from the rest or you will get a cycle
    list.next = null;

    // then we reverse everything from the second element on
    ListNode reverseRest = Reverse(secondElem);

    // then we join the two lists
    secondElem.Next = list;

    return reverseRest;
}
	 */
}