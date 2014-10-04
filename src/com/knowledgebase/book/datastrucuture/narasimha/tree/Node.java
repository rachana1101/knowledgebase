package com.knowledgebase.book.datastrucuture.narasimha.tree;

public class Node<E> {
    private E value;
    private Node<E> left;
    private Node<E> right;
    
    public Node(E value) {
        this.value = value;
    }
    /**
     * @return the data
     */
    public E getValue() {
        return value;
    }
    /**
     * @param data the data to set
     */
    public void setData(E value) {
        this.value = value;
    }
    /**
     * @return the left
     */
    public Node<E> getLeft() {
        return left;
    }
    /**
     * @param left the left to set
     */
    public void setLeft(Node<E> left) {
        this.left = left;
    }
    /**
     * @return the right
     */
    public Node<E> getRight() {
        return right;
    }
    /**
     * @param right the right to set
     */
    public void setRight(Node<E> right) {
        this.right = right;
    }
}
