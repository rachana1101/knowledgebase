package com.knowledgebase.book.datastrucuture.narasimha.linkedlist;
/**
 * Book - Data Structure and algorithms made easy in java
 * Author - Narashimha Karumanchi
 * Chapter - 3 Linked List 
 * Problem 1 - Implement stack using linkedList 
 *
 * @author rachana
 *
 */
public class LinkedListStack {
    public Node<Integer> head;
    private int size = 0;
    
    /**
     * To add the value at the beginning of the list 
     * @param node
     */
    public void push(Integer value) {
        if(head==null) {
            head = new Node<Integer>(value, null);
        } else {
            Node<Integer> temp = head;
            Node<Integer> newNode = createNode(value);
            newNode.setNext(temp); //assign the next of head to the next of newNode
            head = newNode; //now assign the new node to the head's next
        }
        size++;
    }
    /**
     * Remove the element from the front of the list
     * @return
     */
    public Node<Integer> pop() {
        if(head == null) {
            return null;
        } else {
            Node<Integer> current = head;
            Node<Integer> temp = current.getNext();
            head = temp;
            current.setNext(null);
            size--;
            return current;
        }
    }
    
    private Node<Integer> createNode(Integer value) {
        return new Node<Integer>(value, null);
    }
    
    public int size() {
        return size; 
    }
    public void print() {
        Node<Integer> current = head;
        while(current!=null) {
            System.out.print("[" + current.getValue() + "]  ");
            current = current.getNext();
        }
    }
}
