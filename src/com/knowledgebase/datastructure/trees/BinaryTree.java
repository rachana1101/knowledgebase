package com.knowledgebase.datastructure.trees;

import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTree {
    public  TreeNode<Integer> root;
    static int ctr = 1;

    public BinaryTree() {
    }

    public void add(int value) {
        if (root == null) {
            root = createNode(value);
        } else {
            TreeNode<Integer> current = root;
            while (current != null) {
                TreeNode<Integer> parent = current;
                if (ctr % 2 == 0) {
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(createNode(value));
                    } else {
                        parent = current;
                    }
                } else {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(createNode(value));
                    } else {
                        parent = current;
                    }
                }
                ctr++;
            }
        }
    }

    private int size(TreeNode<Integer> treeRoot) {
        if (treeRoot == null)
            return 0;
        else
            return 1 + size(treeRoot.getLeft()) + size(treeRoot.getRight());
    }

    public void inOrder(TreeNode<Integer> node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getValue()+", ");
            inOrder(node.getRight());
        }
    }
    
    public void preOrder(TreeNode<Integer> node) {
        if (node != null) {
            System.out.print(node.getValue()+", ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }
    
    public boolean areStructuralySame(TreeNode<Integer> tree1, TreeNode<Integer> tree2) {
        if(tree1 == null && tree2 == null) {
            return true;
        }
        if(tree1 == null || tree2 == null) {
            return false;
        } else return (areStructuralySame(tree1.getLeft(), tree2.getLeft()) && areStructuralySame(tree1.getRight(), tree2.getRight()));
    }
    
    public boolean isMirror(TreeNode<Integer> tree1, TreeNode<Integer> tree2) {
        if(tree1 == null && tree2 == null) {
            return true;
        }
        if(tree1 == null || tree2 == null) {
            return false;
        } else return (areStructuralySame(tree1.getLeft(), tree2.getRight()) && areStructuralySame(tree1.getRight(), tree2.getLeft()));
    }
    
    
    
    public void levelOrder() {
        TreeNode<Integer> temp;
        //Queue
        LinkedList<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        if(this.root == null) {
            return;
        } else {
            queue.add(this.root);
            while(!queue.isEmpty()) {
                temp = (TreeNode<Integer>) queue.remove();
                System.out.print(temp.getValue()+ ", ");
                
                if(temp.getLeft()!=null) {
                    queue.add(temp.getLeft());
                }
                if(temp.getRight()!=null) {
                    queue.add(temp.getRight());
                }
            }
        }
    }
    private TreeNode<Integer> createNode(int value) {
        TreeNode<Integer> node = new TreeNode<>(value);
        return node;
    }

    public static void main(String... argv) {
        BinaryTree binaryTree = new BinaryTree();
        for (Integer value : Arrays.asList(1,2,3,4,5,6,7)) {
            binaryTree.add(value);
        }
        System.out.println(" Size of Tree " + binaryTree.size(binaryTree.root));
        binaryTree.inOrder(binaryTree.root);
        System.out.println();
        binaryTree.preOrder(binaryTree.root);
        System.out.println();
        binaryTree.levelOrder();
        
        BinaryTree b1 = new BinaryTree();
        for (Integer value : Arrays.asList(32, 10, 31, 13)) {
            b1.add(value);
        }
        System.out.println();
        b1.levelOrder();
        System.out.println();
        BinaryTree b2 = new BinaryTree();
        for (Integer value : Arrays.asList(22, 1, 21, 3)) {
            b2.add(value);
        }
        System.out.println();
        b2.levelOrder();
        System.out.println();
        System.out.println(b1.areStructuralySame(b1.root, b2.root));
        System.out.println(b1.isMirror(b1.root, b2.root));
    }
}
