package com.knowledgebase.datastructure.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree {
    TreeNode<Integer> node;

    public boolean set(int value) {
        System.out.println(" value " + value);
        if (node == null) {
            // its a root node
            node = new TreeNode<Integer>(value);
            System.out.println(" Root : " + value);
        } else {
            TreeNode<Integer> current = node;
            while (current != null) {
                TreeNode<Integer> parent = current;
                if (value > current.getValue()) { // get it to right
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(new TreeNode<Integer>(value));
                    } else {
                        parent = current;
                    }
                } else {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(new TreeNode<Integer>(value));
                    } else {
                        parent = current;
                    }
                }
            }
            current = new TreeNode<Integer>(value);
        }
        return true;
    }

    /**
     * InOrder
     * 
     * @param node
     */
    public void inorder(TreeNode<Integer> node) {
        if (node != null) {
            inorder(node.getLeft());
            System.out.print(node.getValue() + ", ");
            inorder(node.getRight());
        }
    }

    public List<Integer> inorderToList(TreeNode<Integer> node, List<Integer> list) {
        if(node == null) {
            return list;
        } 
        if (node != null) {
            list = inorderToList(node.getLeft(), list);
            list.add(node.getValue());
            list = inorderToList(node.getRight(), list);
        }
        return list;
    }

    public void inorderWithStack(TreeNode<Integer> node) {
        Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
        while (true) {
            while (node != null) {
                stack.add(node);
                node = node.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            }
            node = (TreeNode<Integer>) stack.pop();
            System.out.print(node.getValue() + ", ");
            node = node.getRight();
        }
        return;
    }

    public void postOrderWithStack(TreeNode<Integer> node) {

    }

    public void preOrderWithStack(TreeNode<Integer> node) {

    }

    /**
     * PostOrder
     * 
     * @param node
     */
    public void postorder(TreeNode<Integer> node) {
        if (node != null) {
            postorder(node.getLeft());
            postorder(node.getRight());
            System.out.print(node.getValue() + ", ");
        }
    }

    /**
     * PreOrder
     * 
     * @param node
     */
    public void preorder(TreeNode<Integer> node) {
        if (node != null) {
            System.out.print(node.getValue() + ", ");
            preorder(node.getLeft());
            preorder(node.getRight());
        }
    }
    
    

    private int getSize(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + getSize(root.getLeft()) + getSize(root.getRight());
        }
    }

    private int findMax(TreeNode<Integer> root) {
        TreeNode<Integer> current = root;
        if (current == null) {
            return 0;
        } else {
            while (current.getRight() != null) {
                current = current.getRight();
            }
            return (int) current.getValue();
        }
    }

    private int findMin(TreeNode<Integer> root) {
        TreeNode<Integer> current = root;
        if (current == null) {
            return 0;
        } else {
            while (current.getLeft() != null) {
                current = current.getLeft();
            }
            return (int) current.getValue();
        }
    }

    private boolean findElement(TreeNode<Integer> root, int data) {
        if (root == null) {
            return false;
        } else {
            TreeNode<Integer> current = root;
            while (current != null) {
                if (current.getValue() == data) {
                    return true;
                } else if (data < current.getValue()) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
            }
            return false;
        }
    }

    private int findLeastCommonParent(TreeNode<Integer> root, int child1,
            int child2) {
        if (root == null) {
            return 0;
        } else {
            TreeNode<Integer> current = root;
            TreeNode<Integer> parent = current;
            while (current != null) {
                if (child1 < current.getValue() && child2 < current.getValue()) {
                    parent = current;
                    current = current.getLeft();

                } else if (child1 > current.getValue()
                        && child2 > current.getValue()) {
                    parent = current;
                    current = current.getRight();
                } else {
                    return parent.getValue();
                }
            }
        }
        return 0;
    }

    public void levelOrder(TreeNode<Integer> node) {
        TreeNode<Integer> temp;
        // Queue
        LinkedList<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        if (node == null) {
            return;
        } else {
            queue.add(node);
            while (!queue.isEmpty()) {
                temp = (TreeNode<Integer>) queue.remove();
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

    public int findSize(TreeNode<Integer> root) {
        TreeNode<Integer> temp;
        // Queue
        LinkedList<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        int ctr = 0;
        if (root == null) {
            return ctr;
        } else {
            queue.add(root);
            while (!queue.isEmpty()) {
                temp = queue.poll();
                ctr++;
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                }
            }
        }
        return ctr;
    }

    public void reverseLevelOrder(TreeNode<Integer> root) {
        LinkedList<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
        if (root == null) {
            return;
        } else {
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode<Integer> temp = queue.poll();
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                }
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                }
                stack.push(temp);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().getValue() + ", ");
        }
    }

    // TODO
    public int findHeight(TreeNode<Integer> root) {
        LinkedList<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        int ctr = 0;
        if (root == null) {
            return ctr;
        } else {
            queue.add(root);
            queue.add(null);
            while (!queue.isEmpty()) {
                root = queue.poll();
                if (root == null) {
                    if (!queue.isEmpty()) {
                        queue.add(null);
                    }
                    ctr++;
                }
                if (root.getRight() != null) {
                    queue.add(root.getRight());
                }
                if (root.getLeft() != null) {
                    queue.add(root.getLeft());
                }
            }
        }
        return ctr;
    }

    public TreeNode<Integer> getDeepest(TreeNode<Integer> root) {
        LinkedList<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        TreeNode<Integer> temp = null;
        if (root == null) {
            return null;
        } else {
            queue.add(root);
            while (!queue.isEmpty()) {
                temp = queue.pop();
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                }
            }
            return temp;
        }
    }

    public int findFullNodes(TreeNode<Integer> root) {
        LinkedList<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        int ctr = 0;
        if (root == null) {
            return 0;
        } else {
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode<Integer> temp = queue.poll();
                if (temp.getLeft() != null && temp.getRight() != null) {
                    ctr++;
                }
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                }
            }
        }
        queue.removeAll(null);
        return ctr;
    }

    public int findHalfNodes(TreeNode<Integer> root) {
        LinkedList<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        int ctr = 0;
        if (root == null) {
            return 0;
        } else {
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode<Integer> temp = queue.poll();
                if ((temp.getLeft() != null && temp.getRight() == null)
                        && (temp.getLeft() == null && temp.getRight() != null)) {
                    ctr++;
                }
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                }
            }
        }
        queue.removeAll(null);
        return ctr;
    }

    public boolean areIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        LinkedList<TreeNode<Integer>> queue1 = new LinkedList<TreeNode<Integer>>();
        LinkedList<TreeNode<Integer>> queue2 = new LinkedList<TreeNode<Integer>>();
        boolean flag = false;
        if (root1 == null && root2 == null) {
            return false;
        } else {
            queue1.add(root1);
            queue2.add(root2);
            while (!queue1.isEmpty() && !queue2.isEmpty()) {
                TreeNode<Integer> temp1 = queue1.poll();
                TreeNode<Integer> temp2 = queue2.poll();
                if (temp1 != null && temp2 != null) {
                    if (temp1.getValue() == temp2.getValue()) {
                        flag = true;
                    } else {
                        return false;
                    }
                }
                if (temp1.getLeft() != null) {
                    queue1.add(temp1.getLeft());
                }
                if (temp2.getLeft() != null) {
                    queue2.add(temp2.getLeft());
                }
                if (temp1.getRight() != null) {
                    queue1.add(temp1.getRight());
                }
                if (temp2.getRight() != null) {
                    queue2.add(temp2.getRight());
                }
            }
        }
        return flag;
    }

    public int findLevelHavingMaxSum(TreeNode<Integer> root) {
        LinkedList<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        int max = 0;
        int sum = 0;
        int maxSumLevel = 0;
        int level = 0;
        if (root == null) {
            return 0;
        } else {
            queue.add(root);
            queue.add(null); // marking end of level 1
            while (!queue.isEmpty()) {
                TreeNode<Integer> temp = queue.poll();
                if (temp == null) {
                    if (max < sum) {
                        max = sum;
                        maxSumLevel = level;
                    }
                    sum = 0;
                    level++;
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
        System.out.println(" total sum " + max);
        return maxSumLevel;
    }

    public int findTotalSum(TreeNode<Integer> root) {
        LinkedList<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        int sum = 0;
        if (root == null) {
            return 0;
        } else {
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode<Integer> temp = queue.poll();
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

    public void createMirror(TreeNode<Integer> root) {
        LinkedList<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        if (root == null) {
            return;
        } else {
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode<Integer> temp = queue.poll();
                System.out.print(temp.getValue() + ", ");
                if (temp != null) {
                    TreeNode<Integer> temp1 = temp.getLeft();
                    temp.setLeft(temp.getRight());
                    temp.setRight(temp1);
                }
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                }
            }
        }
        queue.removeAll(null);
    }

    public boolean isMirror(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        LinkedList<TreeNode<Integer>> queue1 = new LinkedList<TreeNode<Integer>>();
        LinkedList<TreeNode<Integer>> queue2 = new LinkedList<TreeNode<Integer>>();
        boolean flag = false;
        if (root1 == null && root2 == null) {
            return false;
        } else {
            queue1.add(root1);
            queue2.add(root2);
            while (!queue1.isEmpty() && !queue2.isEmpty()) {
                TreeNode<Integer> temp1 = queue1.poll();
                TreeNode<Integer> temp2 = queue2.poll();
                if (temp1 != null && temp2 != null) {
                    if (temp1.getValue() == temp2.getValue()) {
                        flag = true;
                    } else {
                        return false;
                    }
                }
                if (temp1.getLeft() != null) {
                    queue1.add(temp1.getLeft());
                }
                if (temp2.getRight() != null) {
                    queue2.add(temp2.getRight());
                }

                if (temp1.getRight() != null) {
                    queue1.add(temp1.getRight());
                }
                if (temp2.getLeft() != null) {
                    queue2.add(temp2.getLeft());
                }
            }
        }
        return flag;
    }

    public List<Integer> getAllAncestor(TreeNode<Integer> root, int value) {
        List<Integer> ancestor = new ArrayList<Integer>();
        if (root == null) {
            return ancestor;
        } else {
            TreeNode<Integer> current = root;
            while (current != null) {
                if (value < current.getValue()) {
                    ancestor.add(current.getValue());
                    current = current.getLeft();
                } else if (value > current.getValue()) {
                    ancestor.add(current.getValue());
                    current = current.getRight();
                } else {
                    return ancestor;
                }
            }
        }

        return ancestor;
    }

    public void ZigZag(TreeNode<Integer> root) {
        // we are going to use 2 stacks
        TreeNode<Integer> temp;
        int leftToRight = 1;
        Stack<TreeNode<Integer>> currentLevel = new Stack<TreeNode<Integer>>();
        Stack<TreeNode<Integer>> nextLevel = new Stack<TreeNode<Integer>>();
        stackPush(currentLevel, root);
        while (!currentLevel.isEmpty()) {
            temp = stackPop(currentLevel);
            System.out.print(temp.getValue() + ", ");
            if (leftToRight == 1) {
                if (temp.getLeft() != null) {
                    stackPush(nextLevel, temp.getLeft());
                }
                if (temp.getRight() != null) {
                    stackPush(nextLevel, temp.getRight());
                }
            } else {
                if (temp.getRight() != null) {
                    stackPush(nextLevel, temp.getRight());
                }
                if (temp.getLeft() != null) {
                    stackPush(nextLevel, temp.getLeft());
                }
            }
            if (currentLevel.isEmpty()) {
                leftToRight = 1 - leftToRight;
                Stack<TreeNode<Integer>> tempStack = currentLevel;
                currentLevel = nextLevel;
                nextLevel = tempStack;
            }
        }

    }

    private void stackPush(Stack stack, TreeNode<Integer> value) {
        stack.push(value);
    }

    private TreeNode stackPop(Stack stack) {
        if (!stack.isEmpty()) {
            return (TreeNode<Integer>) stack.pop();
        }
        return null;
    }
    
    public void findHeight(TreeNode root, int data) {
        Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
        TreeNode<Integer> temp;
        if(root == null) {
            return;
        } else {
            stack.add(root);
            while(!stack.isEmpty()) {
                temp = stack.pop();
                if(temp.getValue() == data) {
                    break;
                }
                if(temp.getLeft()!=null) {
                    stack.add(temp.getLeft());
                }
                if(temp.getRight()!=null) {
                    stack.add(temp.getRight());
                }
            }
        }
        System.out.println(" Height of the element "+stack.size());
        
    }

    /**
     * Main class
     * 
     * @param argv
     */
    public static void main(String argv[]) {
        List<Integer> ints = Arrays
                .asList(20, 6, 5, 8, 9, 22, 65, 1, 23, 45, 4);
        BinarySearchTree tree = new BinarySearchTree();
        for (Integer integer : ints) {
            tree.set(integer);
        }

        BinarySearchTree tree1 = new BinarySearchTree();
        for (Integer integer : Arrays.asList(20, 6, 5, 8, 9, 22, 65, 1, 23, 45,
                4)) {
            tree1.set(integer);
        }

        boolean flag = tree.areIdentical(tree.node, tree1.node);
        System.out.println(" ================ are identical =================");
        System.out.println(" flag " + flag);

        // traverse the tree
        System.out.println("===================InOrder=======================");
        System.out.println(">>>" + tree.node.getValue());
        tree.inorder(tree.node);
        
        System.out.println(" \n flat the binary search tree to list ");
        System.out.println(tree.inorderToList(tree.node, new ArrayList<Integer>()));

        // traverse the tree
        System.out
                .println("\n===================InOrder - Without Recursion=======================\n");
        tree.inorderWithStack(tree.node);

        System.out
                .println("\n=================PostOrder=========================\n");
        // traverse the tree
        tree.postorder(tree.node);
        System.out
                .println("\n=================PreOrder=========================\n");
        tree.preorder(tree.node);
        System.out.println("\n==========================================\n");
        System.out.println(" Size " + tree.getSize(tree.node));
        System.out.println("\n==========================================\n");
        System.out.println(" Max " + tree.findMax(tree.node));
        System.out.println("\n==========================================\n");
        System.out.println(" Min " + tree.findMin(tree.node));

        System.out.println("\n==========================================\n");
        System.out.println(" find elements -- expected true >>>> "
                + tree.findElement(tree.node, 5));

        System.out.println("\n==========================================\n");
        System.out.println(" find elements -- expected false >>>> "
                + tree.findElement(tree.node, 200));

        System.out
                .println("\n=================Find the least common parent =========================\n");
        System.out.println(" Least common parent "
                + tree.findLeastCommonParent(tree.node, 23, 45));
        System.out
                .println("\n================== Level Order ========================\n");
        tree.levelOrder(tree.node);

        System.out
                .println("\n================== Size without recursin ========================\n");
        System.out.println(tree.findSize(tree.node));

        System.out
                .println("\n================== Level order in reverse order ========================\n");
        tree.reverseLevelOrder(tree.node);

        System.out
                .println("\n================== Height of the tree ========================\n");
        // System.out.println(tree.findHeight(tree.node));

        System.out
                .println("\n================== Deepest node ========================\n");
        System.out.println(tree.getDeepest((tree.node)).getValue());

        System.out
                .println("\n================== No of full node (left and right child both)  ========================\n");
        System.out.println(tree.findFullNodes(tree.node));

        System.out
                .println("\n================== No of half node  ========================\n");
        System.out.println(tree.findHalfNodes(tree.node));

        System.out
                .println("\n================== Level having max sum  ========================\n");
        System.out.println(tree.findLevelHavingMaxSum(tree.node));

        System.out.println("\n ====== Total sum =====");
        System.out.println(tree.findTotalSum(tree.node));

        System.out.println("\n ====== Find Ancestors  =====");
        System.out.println(tree.getAllAncestor(tree.node, 1));

        System.out.println("\n =============== ZigZag ===========");
        tree.ZigZag(tree.node);
        
        System.out.println("\n =============== ZigZag ===========");
       // tree.findHeight(root, data);

        System.out.println("\n ====== Mirror Image  =====");
        tree.createMirror(tree.node);
        
       

    }
}
