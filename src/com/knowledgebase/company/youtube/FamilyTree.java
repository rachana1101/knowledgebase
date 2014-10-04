package com.knowledgebase.company.youtube;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FamilyTree {

    public static void main(String... argv) {
        Family family = new Family();
        family.insert("a", "b");
        family.insert("a", "c");
        family.insert("a", "d");
        family.insert("b", "bb");
        family.insert("c", "cc");
        family.insert("c", "cc1");
        family.insert("d", "dd");
        family.insert("b", "bb1");
        family.insert("b", "bb2");
        family.insert("bb", "oo");
        System.out.println(" ======== family tree ========");
        family.printFamilyTree();
    }
}

class Family {
    Node root;

    public void insert(String parent, String child) {
        if (root == null) {
            root = new Node(parent);
            root.addChild(child);
        } else {
            Node parentNode = findParentNode(root, parent, child);
            parentNode.addChild(child);
        }
    }

    public Node findParentNode(Node node, String parent, String child) {
        if (node == null) {
            return null;
        }
        if (node.name.equals(parent)) {
            return node;
        } else {
            LinkedList<Node> queue = new LinkedList<Node>();
            queue.add(node);
            while (!queue.isEmpty()) {
                Node temp = queue.pop();
                if (temp.hasChild()) {
                    for (Node n : temp.children) {
                        if (n.name.equals(parent)) {
                            return n;
                        } else {
                            queue.add(n);
                        }
                    }
                }
            }

        }
        return node;
    }

    public void printFamilyTree() {
        LinkedList<Node> queue = new LinkedList<Node>();
        Node temp = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = queue.pop();
            System.out.print(temp.name);
            if (temp.hasChild()) {

                for (Node child : temp.children) {
                    System.out.println("-");
                    queue.add(child);
                }
            }
        }
    }
}

class Node {
    String name;
    List<Node> children;

    public Node(String name) {
        this.name = name;
        children = new ArrayList<Node>();
    }

    public boolean hasChild() {
        if (children.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addChild(String child) {
        children.add(new Node(child));
    }
}