package com.knowledgebase.company.ebay;

/**
 * Merge N sorted linked list of integers Constraint was : min comparison and no
 * extra memory(i given a solution with min heap, they told heap will take O(N)
 * memory. so cant use it).
 * 
 */
public class MergeNSortedLinkedList {
    public static void main(String argv[]) {

        SingleLinkedList list1 = new SingleLinkedList();
        list1.add(1);
        list1.add(8);
        list1.add(9);

        SingleLinkedList list2 = new SingleLinkedList();
        list2.add(2);
        list2.add(6);

        SingleLinkedList list3 = new SingleLinkedList();
        list3.add(3);
        list3.add(7);
        
       // print(new SingleLinkedList(MergeLists(list1.head, list2.head)).head);
        print(merge(list1, list2).head);
    }

    public static SingleLinkedList merge(SingleLinkedList list1, SingleLinkedList list2) {
        Node list1current = list1.head;
        Node list2current = list2.head;
        do {
            if (list2current.getValue() < list1current.getValue()) {
                Node temp = list2current.getNext();
                list2current.setNext(list1current);
                list1current.setNext(temp);
                list2current = list2current.getNext();
                System.out.println(list1current.getValue());
            } else {
                Node temp = list1current.getNext();
                list1current.setNext(createNode(list2current.getValue()));
                list1current.getNext().setNext(temp);
                list2current = list2current.getNext();
                list1current = list1current.getNext();
                System.out.println(list1current.getValue());
            }
        }while (list1current.getNext() != null || list2current.getNext() != null);
        return new SingleLinkedList(list1current);
    }
    
    public static Node MergeLists(Node list1, Node list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.getValue() < list2.getValue()) {
          list1.next = MergeLists(list1.next, list2);
          return list1;
        } else {
          list2.next = MergeLists(list2.next, list1);
          return list2;
        }
      }
    private static void print(Node node) {
        Node current = node;
        while (current != null) {
            System.out.print(current.getValue() + "  -->  ");
            current = current.getNext();
        }
    }
    private static Node createNode(int value) {
        Node node = new Node();
        node.setValue(value);
        return node;
    }
}

class Node {
    int value;
    Node next;

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * @return the next
     */
    public Node getNext() {
        return next;
    }

    /**
     * @param next
     *            the next to set
     */
    public void setNext(Node next) {
        this.next = next;
    }
}

class SingleLinkedList {
    public Node head;
    
    public SingleLinkedList(Node head) {
        this.head = head;
    }
    
    public SingleLinkedList() {
    }

    public void add(int n) {
        if (head == null) {
            head = createNode(n);
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(createNode(n));
        }
    }

    private static Node createNode(int value) {
        Node node = new Node();
        node.setValue(value);
        return node;
    }

   
}