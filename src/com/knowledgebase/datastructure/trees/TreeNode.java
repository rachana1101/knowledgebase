package com.knowledgebase.datastructure.trees;

public class TreeNode<E> {
    
    public TreeNode(E value) {
        this.value = value;
    }
    private E value;
    private TreeNode<E> left;
    private TreeNode<E> right;
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
    /**
     * @return the left
     */
    public TreeNode<E> getLeft() {
        return left;
    }
    /**
     * @param left the left to set
     */
    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }
    /**
     * @return the right
     */
    public TreeNode<E> getRight() {
        return right;
    }
    /**
     * @param right the right to set
     */
    public void setRight(TreeNode<E> right) {
        this.right = right;
    }
}
