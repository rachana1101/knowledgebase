package com.knowledgebase.company.ebay.list;

public class SingleLinkedList {
    static Node head = null;
    static Node reverseList = null;

    public static void main(String argv[]) {
        for (int i = 0; i < 10; i++) {
            add(i);
        }
        print(head);
        System.out.println();
        reversePrint(head);
        System.out.println();
        reverse();
        print(head);
    }

    public static void add(int i) {
        if (head == null) {
            head = createNode(i);
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(createNode(i));
        }
    }

    private static Node createNode(int value) {
        Node node = new Node();
        node.setValue(value);
        return node;
    }

    private static void print(Node node) {
        Node current = node;
        while (current != null) {
            System.out.print(current.getValue() + "  -->  ");
            current = current.getNext();
        }
    }

    private static void reversePrint(Node current) {
        if (current.getNext() != null) {
            current = current.getNext();
            reversePrint(current);
            System.out.print(current.getValue() + "  -->  ");
        }
    }

    private static void reverse() {
        Node current = head;
        Node first = current;
        Node second = head.getNext();
        do {
            if (first == head) {
                first.setNext(null);
            } else {
                Node third = second.getNext();
                second.setNext(first);
                first = second;
                second = third;
            }
        } while (second.getNext() != null);
        head = second;
        head.setNext(first);
    }
}
