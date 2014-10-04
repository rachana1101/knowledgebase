package com.knowledgebase.company.samsung;

import java.util.LinkedList;

public class AVLTree {
    public Node<Integer> root;

    public Node<Integer> insert(Integer value) {
        if (root == null) {
            root = new Node<Integer>(value, 0, null, null);
        } else {
            Node<Integer> current = root;
            while (current != null) {
                Node<Integer> parent = current;
                if (value < parent.value) {
                    current = current.left;
                    if (height(parent.left) - height(parent.right) == 2) {
                        if (value < parent.left.value) {
                            parent = singleRotateLeft(parent);
                        } else {
                            parent = singleRotateLeft(parent);
                            parent = singleRotateRight(parent);
                        }
                    }
                } else if (value > parent.value) {
                    current = current.right;
                    if (height(parent.right) - height(parent.left) == 2) {
                        if (value > parent.right.value) {
                            parent = singleRotateRight(parent);
                            // singleRotateLeft
                        } else {
                            parent = singleRotateRight(parent);
                            parent = singleRotateLeft(parent);
                        }
                    }
                } else {
                    parent = current;
                }
            }
        }
        root.height = Math.max(height(root.left), height(root.right) + 1);
        return root;
    }

    public Node<Integer> singleRotateLeft(Node<Integer> node) {
        Node<Integer> temp = node;
        Node<Integer> tempLeft = node.left;
        Node<Integer> tempRight = node.right;
        Node<Integer> tempTempLeft = temp.left;
        Node<Integer> tempTempRight = temp.right;
        node = new Node<Integer>(temp.value, temp.height, tempLeft, tempTempLeft);
        tempRight = new Node<Integer>(tempRight.value, tempRight.height, node, tempTempRight);
        return tempRight;
    }

    public Node<Integer> singleRotateRight(Node<Integer> node) {
        Node<Integer> temp = node;
        Node<Integer> tempLeft = node.left;
        Node<Integer> tempRight = node.right;
        Node<Integer> tempTempLeft = temp.left;
        Node<Integer> tempTempRight = temp.right;
        node = new Node<Integer>(temp.value, temp.height, tempRight, tempTempRight);
        tempLeft = new Node<Integer>(tempLeft.value, tempLeft.height, tempTempLeft, node);
        return tempLeft;
    }

    int height(Node<Integer> node) {
        if (root == null)
            return -1;
        else
            return root.height;
    }

    public void levelOrder(Node<Integer> node) {
        LinkedList<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        Node<Integer> temp = null;
        if (this.root == null) {
            return;
        } else {
            queue.add(root);
            while (!queue.isEmpty()) {
                temp = queue.poll();
                System.out.print(temp.value + ", ");
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
    }

    public static void main(String argv[]) {
        AVLTree tree = new AVLTree();
        for (int i = 1; i <= 7; i++) {
            tree.insert(new Integer(i));
            tree.levelOrder(tree.root);
        }
    }
}

class Node<E> {
    public E value;
    public int height;
    public Node<E> left;
    public Node<E> right;

    public Node(E value, int height, Node<E> left, Node<E> right) {
        super();
        this.value = value;
        this.height = height;
        this.left = left;
        this.right = right;
    }
}