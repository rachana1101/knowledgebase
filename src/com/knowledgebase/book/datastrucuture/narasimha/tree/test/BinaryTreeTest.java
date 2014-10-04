package com.knowledgebase.book.datastrucuture.narasimha.tree.test;

import org.junit.Test;

import com.knowledgebase.book.datastrucuture.narasimha.tree.BinaryTree;
import com.knowledgebase.book.datastrucuture.narasimha.tree.Node;

public class BinaryTreeTest {
    BinaryTree tree;
    
    @Test
    public void add() {
        createTree(); 
    }
    
    @Test
    public void addWithArray() {
        BinaryTree tree = new BinaryTree();
        tree.add(new int[]{7, 3, 9, 2, 4, 8, 10});
        System.out.println("Inorder");
        tree.levelOrder(tree.root);
    }
    
    @Test 
    public void inorder() {
        createTree();
        System.out.println("Inorder");
        this.tree.inorderR(tree.root);
        System.out.println();
        this.tree.inorder(tree.root);
    }
    
    @Test 
    public void postorder() {
        createTree();
        System.out.println("Post Order");
        this.tree.postorderR(tree.root);
        System.out.println();
        this.tree.postorder(tree.root);
        
    }
    
    @Test 
    public void preorder() {
        createTree();
        System.out.println("Preorder");
        this.tree.preorderR(tree.root);
        System.out.println();
        this.tree.preorderR(tree.root);
    }
    
    @Test
    public void levelOrder() {
        createTree();
        System.out.println("Level Order");
        this.tree.levelOrder(tree.root);
        System.out.println();
    }
    
    @Test
    public void size() {
        createTree();
        int size = this.tree.size(tree.root);
        System.out.println("size "+size);
    }
    
    @Test
    public void sum() {
        createTree();
        int sum = this.tree.sum(tree.root);
        System.out.println("sum "+sum);
        
        sum = this.tree.sumR(tree.root);
        System.out.println(" sum R "+sum);
    }
    
    @Test
    public void max() {
        createTree();
        int max = this.tree.max();
        System.out.println(max);
    }
    
    @Test
    public void find() {
        createTree(); 
        System.out.println(this.tree.find(5));
        System.out.println(this.tree.find(15));
    }
    
    @Test 
    public void postOrderWithOutR() {
        createTree();
        this.tree.postorder();
    }
    
    @Test
    public void reverseInOrder() {
        createTree();
        this.tree.reverseInOrder();
    }
    
    @Test
    public void height() {
        createTree();
        System.out.println(this.tree.height());
    }
    
    @Test
    public void deepest() {
        tree = new BinaryTree();
        for(int i =0;i<6;i++) {
            tree.add(i+1);
        }
        System.out.println(this.tree.deepest());
    }
    
    @Test
    public void leafs() {
        tree = new BinaryTree();
        for(int i =0;i<6;i++) {
            tree.add(i+1);
        }
        //createTree();
        System.out.println(this.tree.leafs());
    }
    
    @Test
    public void fullnodes() {
        createTree();
        System.out.println(this.tree.fullnodes());
    }
    
    @Test
    public void halfnodes() {
        tree = new BinaryTree();
        for(int i =0;i<4;i++) {
            tree.add(i+1);
        }
        System.out.println(this.tree.halfnodes());
    }
    
    @Test
    public void areStructurallyIdentical() {
        tree = new BinaryTree();
        for(int i =0;i<6;i++) {
            tree.add(i+1);
        }
        
        BinaryTree tree1 = new BinaryTree();
        for(int i =0;i<6;i++) {
            tree1.add(i+100);
        }
        
        System.out.println(this.tree.areStructurallyIdentical(this.tree.root, tree1.root));
    }

    @Test
    public void levels() {
        createTree();
        System.out.println(this.tree.levels());
        
        BinaryTree tree1 = new BinaryTree();
        for(int i =0;i<20;i++) {
            tree1.add(i+100);
        }
        System.out.println(tree1.levels());
    }
    
    @Test
    public void maxSumInLevel() {
        BinaryTree tree1 = new BinaryTree();
        tree1.add(1000);
        tree1.add(45);
        tree1.add(2);
        tree1.add(4);
        tree1.add(54);
       
        System.out.println(tree1.findLevelWithMaxSum());
    }
    
    @Test
    public void printPath() {
        createTree();
        tree.printPath(this.tree.root, new int[5], 0);
    }
    
    @Test
    public void convertToMirror() {
        createTree();
        this.tree.levelOrder(this.tree.root);
        this.tree.convertToMirror();
        System.out.println();
        this.tree.levelOrder(this.tree.root);
        
        BinaryTree tree1 = this.tree;
        createTree();
        System.out.println(this.tree.isMirror(tree1.root, this.tree.root));
    }
    
    @Test
    public void constructFromTraversal() {
       Node<Integer> tree =  new BinaryTree().buildTree(new int[]{4,2,5,1,6,3}, new int[]{1,2,4,5,3,6});
       BinaryTree tree1 = new BinaryTree();
       tree1.root = tree;
       tree1.levelOrder(tree1.root);
    }
    
    @Test
    public void findAncestors() {
        createTree();
        this.tree.findAncestors(this.tree.root, 9);
    }
    
    @Test
    public void LCA() {
        createTree();
        Node<Integer> node1 = new Node<Integer>(8);
        Node<Integer> node2 = new Node<Integer>(19);
        Node<Integer> result = this.tree.lowestCommonAncestor(this.tree.root, node1, node2);
        if(result!=null) {
            System.out.println(result.getValue());
        }
        /*Node<Integer> result = this.tree.LCA(this.tree.root, node1, node2);
        if(result!=null) {
            System.out.println(result.getValue());
        }*/
    }
    
    @Test
    public void findDupes() {
        BinaryTree tree = new BinaryTree();
        tree.add(1);
        tree.add(1);
        tree.add(1);
        tree.add(4);
        tree.add(4);
        tree.add(6);
        
       
        System.out.println(tree.countDuplicates(tree.root.getLeft(), tree.root));
    }
    
    @Test
    public void findPathForSum() {
        createTree();
        System.out.println(this.tree.findPathWithSum(this.tree.root, 11));
    }
    
    @Test
    public void bubbleUpLeast() {
        BinaryTree tree1 = new BinaryTree();
        tree1.add(10);
        tree1.add(9);
        tree1.add(8);
        tree1.add(5);
        tree1.add(40);
        tree1.add(100);
        
        Node<Integer> node = tree1.bubbleUpLeast(tree1.root);
        System.out.println(node.getValue());
    }
    
    @Test 
    public void findR() {
        createTree();
        System.out.println(tree.findR(this.tree.root, 3));
    }
        
    
    @Test 
    public void getDiameter() {
        createTree();
        System.out.println(tree.diameter(this.tree.root));
        System.out.println(tree.diameter(this.tree.root, 0));
    }
    
    @Test 
    public void isBalance() {
        BinaryTree tree1 = new BinaryTree();
        Node treeNode = new Node(5);
        treeNode.setLeft(new Node(3));
        treeNode.setRight(new Node(4));

        System.out.println(tree1.isBalance(treeNode));
    }
    
    private void createTree() {
        tree = new BinaryTree();
        for(int i =0;i<10;i++) {
            tree.add(i+1);
        }
    }
}
