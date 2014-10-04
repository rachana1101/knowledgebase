package com.knowledgebase.book.datastrucuture.narasimha.linkedlist;

public class Node<E> {
    private Node<E> next;
    private E value;
    
    public Node(E value,Node<E> next) {
        this.next = next;
        this.value = value;
    }
    /**
     * @return the next
     */
    public Node<E> getNext() {
        return next;
    }
    /**
     * @param next the next to set
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }
    /**
     * @return the value
     */
    public E getValue() {
        return value;
    }
    /**
     * @param value the value to set
     */
    public void setValue(E value) {
        this.value = value;
    }
}