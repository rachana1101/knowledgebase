package com.knowledgebase.book.datastrucuture.narasimha.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 1) Test if a binary tree is balanced or not 2) Find k-unbalanced nodes 3)
 * Test if a binary tree is symmetric 4) Compute the LCA in a binary tree 5)
 * Compute the LCA when nodes have parent pointers 6) Sum the leaves in a binary
 * tree endcoding integers 7) find a root to leaf path with specified sum 8)
 * Compute the k-th node in an inorder traversal
 * 
 * @author rachana
 * 
 */
public class BinaryTree {
    public Node<Integer> root;
    int ctr = 1;

    public void add(int value) {
        LinkedList<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        Node<Integer> temp = null;
        if (root == null) {
            root = createNode(value);
        } else {
            queue.add(root);
            while (!queue.isEmpty()) {
                temp = queue.poll();
                // System.out.print(temp.getValue()+", ");
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                } else {
                    temp.setLeft(createNode(value));
                    break;
                }
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                } else {
                    temp.setRight(createNode(value));
                    break;
                }
            }
        }
    }

    public void add(int values[]) {
        for (int i = 0; i < values.length; i++) {
            this.add(values[i]);
        }
    }

    /**
     * Inorder with recursion
     * 
     * @param node
     */
    public void inorderR(Node<Integer> node) {
        if (node != null) {
            inorderR(node.getLeft());
            System.out.print(node.getValue() + ", ");
            inorderR(node.getRight());
        }
    }

    /**
     * code for pre / in / post are almost same Inorder without recursion
     */
    public void inorder(Node<Integer> root) {
        if (root == null)
            return;
        Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            }
            root = (Node<Integer>) stack.pop();
            System.out.print(root.getValue() + ", ");
            root = root.getRight();
        }
        return;
    }

    /**
     * Preorder
     * 
     * @param node
     */
    public void preorderR(Node<Integer> node) {
        if (node != null) {
            System.out.print(node.getValue() + ", ");
            preorderR(node.getLeft());
            preorderR(node.getRight());
        }
    }

    public void preorder(Node<Integer> root) {
        if (root == null)
            return;
        Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
        while (true) {
            while (root != null) {
                System.out.print(root.getValue() + ", ");
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            }
            root = (Node<Integer>) stack.pop();
            root = root.getRight();
        }
        return;
    }

    /**
     * Postorder
     * 
     * @param node
     */
    public void postorderR(Node<Integer> node) {
        if (node != null) {
            postorderR(node.getLeft());
            postorderR(node.getRight());
            System.out.print(node.getValue() + ", ");
        }
    }

    public void postorder(Node<Integer> root) {
        if (root == null)
            return;
        Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            }
            root = (Node<Integer>) stack.pop();
            root = root.getRight();
        }
        return;
    }

    public void postorder() {
        Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
        if (this.root == null) {
            return;
        } else {
            Node<Integer> current = root;
            while (current.getLeft() != null && current.getRight() != null) {
                if (current.getLeft() != null) {
                    stack.add(current.getLeft());
                    current = current.getLeft();
                }
                if (current.getRight() != null) {
                    stack.add(current.getRight());
                    current = current.getRight();
                }
            }
            while (!stack.isEmpty()) {
                System.out.println(stack.pop().getValue());
            }
        }
    }

    /**
     * print the tree in reverse order
     */
    public void reverseInOrder() {
        Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
        LinkedList<Node<Integer>> queue = new LinkedList<Node<Integer>>();

        Node<Integer> temp = null;
        if (this.root == null) {
            return;
        } else {
            queue.add(root);
            while (!queue.isEmpty()) {
                temp = queue.poll();
                System.out.print(temp.getValue() + ", ");
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                }
                stack.add(temp);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().getValue());
        }
    }

    /**
     * get height
     * 
     * @return
     */
    public int height() {
        LinkedList<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        Node<Integer> temp = null;
        int height = 0;
        if (this.root == null) {
            return 0;
        } else {
            queue.add(root);
            while (!queue.isEmpty()) {

                temp = queue.poll();
                if (temp == null) {
                    if (!queue.isEmpty()) {
                        queue.add(null);
                    }
                    height++;
                } else {
                    if (temp.getLeft() != null) {
                        queue.add(temp.getLeft());
                    }
                    if (temp.getRight() != null) {
                        queue.add(temp.getRight());
                    }
                }
            }
        }
        return height;
    }

    public int deepest() {
        LinkedList<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        Node<Integer> temp = null;
        if (this.root == null) {
            return 0;
        } else {
            queue.add(root);
            while (!queue.isEmpty()) {
                temp = queue.poll();
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                }
            }
            return temp.getValue();
        }
    }

    /**
     * find number of leafs
     * 
     * @return
     */
    public int leafs() {
        LinkedList<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        int leafs = 0;
        Node<Integer> temp = null;
        if (this.root == null) {
            return 0;
        } else {
            queue.add(root);
            while (!queue.isEmpty()) {
                temp = queue.poll();
                if (temp.getLeft() == null && temp.getRight() == null) {
                    leafs++;
                }
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                }

            }
        }
        return leafs;
    }

    /**
     * having both left and right nodes
     * 
     * @return
     */
    public int fullnodes() {
        LinkedList<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        int fullnodes = 0;
        Node<Integer> temp = null;
        if (this.root == null) {
            return 0;
        } else {
            queue.add(root);
            while (!queue.isEmpty()) {
                temp = queue.poll();
                if (temp.getLeft() != null && temp.getRight() != null) {
                    fullnodes++;
                }
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                }

            }
        }
        return fullnodes;
    }

    /**
     * having only one child
     * 
     * @return
     */
    public int halfnodes() {
        LinkedList<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        int fullnodes = 0;
        Node<Integer> temp = null;
        if (this.root == null) {
            return 0;
        } else {
            queue.add(root);
            while (!queue.isEmpty()) {
                temp = queue.poll();
                if ((temp.getLeft() == null && temp.getLeft() != null)
                        || (temp.getRight() != null && temp.getRight() != null)) {
                    fullnodes++;
                }
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                }
            }
        }
        return fullnodes;
    }

    /**
     * is structurally identical
     * 
     * @param root1
     * @param root2
     * @return
     */
    public boolean areStructurallyIdentical(Node<Integer> root1,
            Node<Integer> root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return (areStructurallyIdentical(root1.getLeft(), root2.getLeft()) && areStructurallyIdentical(
                root1.getRight(), root2.getRight()));
    }

    /**
     * is mirror
     * 
     * @param root1
     * @param root2
     * @return
     */
    public boolean isMirror(Node<Integer> root1, Node<Integer> root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return (isMirror(root1.getLeft(), root2.getRight()) && isMirror(
                root1.getLeft(), root2.getRight()));
    }
    
    public int countDuplicates(Node<Integer> prev, Node<Integer> current) {
        int duplicates =0;
        if(prev == null) {
            return 0;
        }
        if(prev!=null && prev!=current && current!=null ) {
            duplicates += countDuplicates(current, current.getLeft());
            if(prev.getValue() == current.getValue()) {
                duplicates ++;
            }
            duplicates += countDuplicates(current, current.getRight());
        }
        return duplicates;
    }

    public int diameter(Node<Integer> root) {
        LinkedList<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        int diameter = 0;
        int maxDia = 0;
        Node<Integer> temp;
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()) {
            temp = queue.pop();
            if(temp==null) {
                if(diameter> maxDia) {
                    maxDia = diameter;
                }
                if(!queue.isEmpty()) {
                    queue.add(null);
                    diameter=0;
                }
            } else { 
                diameter++;
                if(temp.getLeft()!=null) {
                    queue.add(temp.getLeft());
                }
                if(temp.getRight()!=null) {
                    queue.add(temp.getRight());
                }
            }
        }
        return maxDia;
    }
    
    public int diameter(Node<Integer> root, int diameter) {
        int left = diameter(root.getLeft(), diameter);
        int right = diameter(root.getRight(), diameter);
        if(left+right > diameter) {
            diameter = left + right;
        }
        return diameter+1;
    }

    /**
     * if you have tree like 1 / \ 2 3 / \ / \ 4 5 6 7
     * 
     * queue: [1][null][2][3][null][4][5][6][7][null]
     * 
     * @return
     */
    public int levels() {
        LinkedList<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        int level = 1;
        Node<Integer> temp = null;
        if (this.root == null) {
            return 0;
        } else {
            queue.add(root);
            queue.add(null); // level 1
            while (!queue.isEmpty()) {
                temp = queue.poll();
                if (temp == null) {
                    if (!queue.isEmpty()) {
                        queue.add(null);
                    }
                    level++;
                } else {
                    if (temp.getLeft() != null) {
                        queue.add(temp.getLeft());
                    }
                    if (temp.getRight() != null) {
                        queue.add(temp.getRight());
                    }
                }
            }
        }
        return level;
    }

    public int findLevelWithMaxSum() {
        LinkedList<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        int maxSum = 0;
        int sum = 0;
        Node<Integer> temp = null;
        if (this.root == null) {
            return 0;
        } else {
            queue.add(root);
            queue.add(null); // mark it end of level 1
            maxSum = root.getValue();
            while (!queue.isEmpty()) {
                temp = queue.pop();
                if (temp == null) {
                    if (sum > maxSum) {
                        maxSum = sum;
                    }
                    if (!queue.isEmpty()) {
                        queue.add(null);
                    }
                } else {
                    sum += temp.getValue();
                    if (temp.getLeft() != null) {
                        queue.add(temp.getLeft());
                    }
                    if (temp.getRight() != null) {
                        queue.add(temp.getRight());
                    }
                }
            }
        }
        return maxSum;
    }

    public void printPath(Node<Integer> root, int[] path, int length) {
        if (root == null) {
            return;
        } else {
            path[length] = root.getValue();
            length++;
            if (root.getLeft() == null && root.getRight() == null) {
                printArray(path, length);
                path = new int[5];
            } else {
                printPath(root.getLeft(), path, length);
                printPath(root.getRight(), path, length);
            }
        }
    }

    public void printArray(int[] path, int length) {
        for (int i = 0; i < path.length; i++) {
            System.out.println(path[i]);
        }
    }

    /**
     * http://stackoverflow.com/questions/4214859/binary-tree-haspathsum-
     * implementation
     * 
     * @param root
     * @param requestSum
     * @return
     */
    public boolean findPathWithSum(Node<Integer> root, int requestSum) {
        if (root == null) {
            return (requestSum == 0);
        } else if (root.getLeft() == null && root.getRight() == null) { // leaf
            return (requestSum == root.getValue());
        } else if (requestSum <= root.getValue()) { // sum used up
            return false;
        } else {
            int subsum = requestSum - root.getValue();
            return (findPathWithSum(root.getLeft(), subsum) || findPathWithSum(
                    root.getRight(), subsum));
        }
    }

    /**
     * Convert in to mirror
     */
    public void convertToMirror() {
        LinkedList<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        Node<Integer> temp;
        if (root == null) {
            return;
        } else {
            queue.add(root);
            while (!queue.isEmpty()) {
                temp = queue.poll();
                if (temp.getLeft() != null && temp.getRight() != null) {
                    Node<Integer> swap = temp.getLeft();
                    temp.setLeft(temp.getRight());
                    temp.setRight(swap);
                } else if (temp.getLeft() != null && temp.getRight() == null) {
                    temp.setRight(temp.getLeft());
                    queue.add(temp);
                } else if (temp.getRight() != null && temp.getLeft() == null) {
                    temp.setLeft(temp.getRight());
                    queue.add(temp);
                }
            }
        }
    }

    /**
     * print the tree in level order
     * 
     * @param node
     */
    public void levelOrder(Node<Integer> node) {
        LinkedList<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        Node<Integer> temp = null;
        if (this.root == null) {
            return;
        } else {
            queue.add(root);
            while (!queue.isEmpty()) {
                temp = queue.poll();
                System.out.print(temp.getValue() + ", ");
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                }
            }
        }
    }

    /**
     * To find the size of the tree
     * 
     * @param node
     * @return
     */
    public int size(Node<Integer> node) {
        if (node != null) {
            return size(node.getLeft()) + 1 + size(node.getRight());
        } else {
            return 0;
        }
    }

    /**
     * find the sum of all the elements
     * 
     * @param root2
     * @return
     */
    public int sum(Node<Integer> root2) {
        LinkedList<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        int sum = 0;
        if (root2 == null) {
            return 0;
        } else {
            queue.add(root2);
            while (!queue.isEmpty()) {
                Node<Integer> temp = queue.poll();
                sum += temp.getValue();
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                }
            }
        }
        queue.removeAll(null);
        return sum;
    }

    public int sumR(Node<Integer> root) {
        if (root != null) {
            return root.getValue() + sumR(root.getLeft())
                    + sumR(root.getRight());
        } else {
            return 0;
        }
    }

    /**
     * find the max of the elements
     * 
     * @return
     */
    public int max() {
        LinkedList<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        int max = 0;
        if (root == null) {
            return 0;
        } else {
            queue.add(root);
            while (!queue.isEmpty()) {
                Node<Integer> temp = queue.poll();
                if (temp.getValue() > max) {
                    max = temp.getValue();
                }
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                }
            }
        }
        return max;
    }

    /**
     * Find the needle
     * 
     * @param needle
     * @return
     */
    public boolean find(int needle) {
        LinkedList<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        if (root == null) {
            return false;
        } else {
            queue.add(root);
            while (!queue.isEmpty()) {
                Node<Integer> temp = queue.poll();
                if (temp.getValue() == needle) {
                    return true;
                }
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                }
            }
        }
        return false;
    }

    /**
     * inorder sequence : D B E A F C preorder sequence : A B D E C F
     */
    public Node<Integer> buildTree(int inorder[], int preorder[]) {
        if (preorder.length == 0 || inorder.length == 0
                || preorder.length != inorder.length)
            return null;
        int rootVal = preorder[0];
        Node<Integer> node = createNode(rootVal);
        int numLeftCh = getIndexInInOrder(inorder, rootVal);
        int numRightCh = inorder.length - numLeftCh - 1;

        if (numLeftCh > 0) {
            node.setLeft(buildTree(
                    Arrays.copyOfRange(preorder, 1, numLeftCh + 1),
                    Arrays.copyOfRange(inorder, 0, numLeftCh)));
        }
        if (numRightCh > 0) {
            node.setRight(buildTree(
                    Arrays.copyOfRange(preorder, numLeftCh + 1,
                    preorder.length),
                    Arrays.copyOfRange(inorder,
                    numLeftCh + 1, inorder.length)));
        }
        return node;
    }

    public boolean findAncestors(Node<Integer> root, int ancestorOf) {
        if (root == null) {
            return false;
        }
        if (root.getLeft().getValue() == ancestorOf
                || root.getRight().getValue() == ancestorOf
                || findAncestors(root.getLeft(), ancestorOf)
                || findAncestors(root.getRight(), ancestorOf)) {
            System.out.println(root.getValue());
            return true;
        } else {
            return false;
        }
    }

    public Node<Integer> lowestCommonAncestor(Node<Integer> root,
            Node<Integer> a, Node<Integer> b) {
        if (root == null) {
            return null;
        }
        if (root.getValue().equals(a.getValue()) || root.getValue().equals(b.getValue())) {
            // if at least one matched, no need to continue
            // this is the LCA for this root
            return root;
        }

        Node<Integer> l = lowestCommonAncestor(root.getLeft(), a, b);
        Node<Integer> r = lowestCommonAncestor(root.getRight(), a, b);

        if (l != null && r != null) {
            return root; // nodes are each on a seaparate branch
        }

        // either one node is on one branch,
        // or none was found in any of the branches
        return l != null ? l : r;
    }

    private int getIndexInInOrder(int inOrder[], int data) {
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == data) {
                return i;
            }
        }
        return 0;
    }

    public boolean findPathForSum(Node<Integer> root, int sum) {
        if (root == null) {
            return false;
        } else {
            int subSum = sum - root.getValue();
            System.out.println(root.getValue());
            return (findPathForSum(root.getLeft(), subSum) || findPathForSum(
                    root.getRight(), subSum));
        }
    }
    
    /*
     *Dealt with sort algorithms and their complexity/big O analysis. Also was asked about heap sort and how heaps in general work. Then asked to come to an official interview on campus.
     *
     *Interview Question – Write code for a binary tree who find the lowest node and bubbles it up to the root.
     */
    public Node<Integer> bubbleUpLeast(Node<Integer> root) {
        LinkedList<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        queue.add(root);
        Node<Integer> previous = null;
        Node<Integer> temp = null;
        while(!queue.isEmpty()) {
            previous = root;
            temp = queue.pop();
            if(previous.getValue() > temp.getValue()) {
                int value = temp.getValue();
                temp.setData(previous.getValue());
                previous.setData(value);
            }
            if(temp.getLeft()!=null) {
                queue.add(temp.getLeft());
            }
            if(temp.getRight()!=null) {
                queue.add(temp.getRight());
            }
        }
        return root;
    }
    
    public boolean isBalance(Node<Integer> root) {
        LinkedList<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        queue.add(root);
        Node<Integer> temp = null;
        while(!queue.isEmpty()) {
            temp = queue.pop();
            if(temp.getLeft().getLeft()!=null && temp.getRight()==null) {
                return false;
            }
            if(temp.getLeft().getRight()!=null && temp.getRight()==null) {
                return false;
            }
            if(temp.getRight().getLeft()!=null && temp.getLeft()==null) {
                return false;
            }
            if(temp.getRight().getRight()!=null && temp.getLeft()==null) {
                return false;
            }
            if(temp.getLeft()!=null) {
                queue.add(temp.getLeft());
            }
            if(temp.getRight()!=null) {
                queue.add(temp.getRight());
            }
        }
        return true;
        
    }

    /**
     * @param value
     * @return
     */
    private Node<Integer> createNode(Integer value) {
        return new Node<Integer>(value);
    }
    
    public boolean findR(Node<Integer> root, int data) {
        boolean temp;
        if(root == null) {
            return false;
        } else {
            if(root.getValue() == data) {
                return true;
            } else {
                temp = findR(root.getLeft(), data);
                if(temp != true) {
                    return temp;
                } else {
                    return findR(root.getRight(), data);
                }
            }
            
        }
    }

}
