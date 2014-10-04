package com.datastructure.problems.amazon.problems;

import java.util.Vector;



/*
 * Link even and odd level nodes of a Binary tree

    Given a binary tree, write code which will create two linked list, 
    one with all the nodes linked at odd level and another one from even level.
 */
public class BinaryTree {
	
	public static void main(String argv[]) {
		Integer[] list = new Integer[]{35,45,111,4,7,3,89,1,150};
		System.out.println(" Input String ");
		System.out.print(12 +" ");
		for(Integer d: list) {
			System.out.print(d + " ");
		}

		BTree t = new BTree();
		BNode root = t.setRootNode(12);
		for(Integer value: list) {
			t.addToTree(root, value);
		}
		System.out.println("\n Inorder \n");
		printInOrder(root);
		System.out.println("\n Post order \n");
		postorderTraversal(root);
		System.out.println("\n  Preorder \n");
		preorderTraversal(root);
		System.out.println("\n Zig Zag \n");
		printZigZag(root,1);
		
		t.findFurhterst();
		t.contains(t.root, 35);
		t.contains(t.root, 0);
		
		//System.out.println(t.findTotal(t.valueOfLargest(35, root),0));
		System.out.println("No of nodes "+sum(root));
		System.out.println("total "+totalOfNodes(root));
		System.out.println("depth "+findDepth(root, 0));
		BFS(root);
	}
	
	public static void printInOrder(BNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(" " + node.data);
            printInOrder(node.right);
        }
    }
	
	public static int sum(BNode node) {
        if (node == null) {
        	return 0;
        } else {	
        	return sum(node.getLeft())+sum(node.getRight())+1;
        }
    }
	
	public static int totalOfNodes(BNode node) {
        if (node == null) {
        	return 0;
        } else {	
        	return node.data + totalOfNodes(node.getLeft())+totalOfNodes(node.getRight());
        }
    }
	
	public static int findDepth(BNode node, int depth) {
		if(node == null) {
			return 0;
		} else {
			return 1+(node.getLeft()==null?0:findDepth(node.getLeft(),0)+ (node.getRight()==null?0:findDepth(node.getRight(),0)));
		}
	}
	
	public static void BFS(BNode node) {
		if(node == null) {
			return ;
		} else {
			if(node.getLeft()!=null) {
				System.out.println(node.getData());
			} 
				BFS(node.getLeft());
			if(node.getRight()!=null) {
				System.out.println(node.getData());
			}	
				BFS(node.getRight());
			
		}
	}
	
	private static void postorderTraversal(BNode node) {
	    if (node != null) {
	        postorderTraversal(node.getLeft());
	        postorderTraversal(node.getRight());
	        System.out.print(node.getData() + " ");
	    }
	}
	
	public static void preorderTraversal(BNode node) {
	    if (node != null) {
	        System.out.print(node.getData() + " ");
	        preorderTraversal(node.getLeft());
	        preorderTraversal(node.getRight());            
	    }
	}
	
	public static void printZigZag(BNode node, int level) {
		
		if(node!=null) {
			if(level%2==1) {
				printZigZag(node.left,level );
	            System.out.print(" " + node.data);
	            printZigZag(node.right,level);
	            level++;
			} else {
				printZigZag(node.right,level);
	            System.out.print(" " + node.data);
	            printZigZag(node.left,level);
	            level++;
			}
		}
	}


}

class BNode {
	Integer data = null;
	BNode left = null;
	BNode right = null;
	BNode(Integer data) {
		this.data = data;
	}
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public BNode getLeft() {
		return left;
	}
	public void setLeft(BNode left) {
		this.left = left;
	}
	public BNode getRight() {
		return right;
	}
	public void setRight(BNode right) {
		this.right = right;
	}
	
	
}

class BTree {
	BNode root = null;
	BNode current = null;
	public void addToTree(BNode node,Integer data) {
		current = node;
		if(data <current.getData()) {
			if(current.getLeft()==null) {
				current.setLeft(new BNode(data));
				return;
			} else {
				current = current.getLeft();
				addToTree(current, data);
				return;
			}
		}
		if(data > current.getData()) {
			if(current.getRight() ==null) {
				current.setRight(new BNode(data));
				return;
			} else {
				current = current.getRight();
				addToTree(current, data);
				return;
			}
		}
	}
	
	public void addMultiple(Vector<BNode> datalist) {
		for(BNode node: datalist) {
			addToTree(root, node.getData());
		}
	}
	
	public void contains(BNode node, Integer data) {
		if(node!=null) {
		contains(node.getLeft(),data);
		if(data == node.getData()) {
			System.out.println("founds");
		}
		contains(node.getRight(),data);
		}
	}
	
	public BNode setRootNode(Integer data) {
		BNode node = new BNode(data);
		if(root == null) {
			root = node;
			current = root;
			return current;
		}
		return null;
	}
	
	public void findFurhterst() {
		current = root;
		while(current.getLeft()!=null) {
			current = current.getLeft();
		}
		System.out.println(" left most "+current.getData());
		current = root;
		while(current.getRight()!=null) {
			current = current.getRight();
		}
		System.out.println("right most "+current.getData());
	}
}
