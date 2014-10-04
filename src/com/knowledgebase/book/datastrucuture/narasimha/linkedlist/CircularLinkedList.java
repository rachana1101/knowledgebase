package com.knowledgebase.book.datastrucuture.narasimha.linkedlist;

public class CircularLinkedList {
    public Node<Integer> head;
    private int size = 0;

    // To add the nodes in the list
    /**
     * To add the value at the end of the list
     * 
     * @param value
     */
    public void add(Integer value) {
        if (head == null) {
            head = new Node<Integer>(value, null);
            head.setNext(head);
        } else {
            Node<Integer> current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            } // take it to the end
            Node<Integer> newNode = createNode(value);
            newNode.setNext(head);
            current.setNext(newNode);
        }
        size++;
    }
    /**
     * Adding at the end of the is similiar to add
     * @param value
     */
    public void addAtEnd(Integer value) {
        if (head == null) {
            head = new Node<Integer>(value, null);
            head.setNext(head);
        } else {
            Node<Integer> current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            Node<Integer> newNode = createNode(value);
            newNode.setNext(head);
            current.setNext(newNode);
        }
        size++;
    }
    /**
     * Adding at the front 
     */
    public void addAtFront(Integer value) {
        if (head == null) {
            head = new Node<Integer>(value, null);
            head.setNext(head);
        } else {
            Node<Integer> current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            Node<Integer> newNode = createNode(value);
            newNode.setNext(head);
            current.setNext(newNode);
            //only change from the addToEnd is 
            head = newNode;
        }
        size++;
    }
    /**
     * Delete the node from the front
     * @return {@link Node}
     */
    public Node<Integer> deleteFromFront() {
        if(head == null) {
            return null;
        } else {
            Node<Integer> current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            Node<Integer> temp = head.getNext();
            Node<Integer> toReturn = head;
            head = temp;
            current.setNext(temp);
            toReturn.setNext(null);
            size--;
            return toReturn;
        }
    }
    
    /**
     * Delete the node from the end
     * @return {@link Node}
     */
    public Node<Integer> deleteFromEnd() {
        if(head == null) {
            return null;
        } else {
            Node<Integer> current = head;
            while (current.getNext().getNext() != head) {
                current = current.getNext();
            }
            Node<Integer> temp = current.getNext();
            current.setNext(head);
            size--;
            return temp;
        }
    }

    private Node<Integer> createNode(Integer value) {
        return new Node<Integer>(value, null);
    }

    public int size() {
        return size;
    }

    /**
     * TODO implementation
     * <ul>
     *      <li>Book - Data Structure and algorithms made easy in java</li>
     *      <li>Author - Narashimha Karumanchi</li>
     *      <li>Chapter - 3 Linked List</li>
     *      <li>Problem 36 - Split the circular linked list in to two equal parts  </li>
     * </ul>
     */
    public void splitList() {
        if(head!=null && size>0) {
            if(size % 2 ==0 ) {
                Node<Integer> current = head;
                int ctr = 0;
                while(current.getNext() != head && ctr < (size/2)-1) {
                    current = current.getNext();
                    ctr++;
                }
                //take the next of the end for the starting of the other end
                Node<Integer> temp = current.getNext();
                current.setNext(head);
                
                //print
                System.out.println();
                this.print(head);
                
                Node<Integer> head2 = temp;
                Node<Integer> heas2Current = head2;
                
                while(heas2Current.getNext()!= head) {
                    heas2Current = heas2Current.getNext();
                    
                }
                heas2Current.setNext(head2);
                //print
                System.out.println();
                this.print(head2);
            }
        }
    }
    
    /**
     * <ul>
     * <li>Book - Data Structure and algorithms made easy in java</li>
     * <li>Author - Narashimha Karumanchi</li>
     * <li>Chapter - 3 Linked List</li>
     * <li>Problem 41 - JosephusCircle - N people have decided to elect a leader
     * by arranging themselves in a circle elimination every Mth person around
     * the circle, closing ranks as search person drops out. Find which person
     * will be the last one remaining ( with rank 1)</li>
     * </ul>
     */
    public Node<Integer> getJosephusCircle(int N, //no of nodes 
                                           int M //M to be deleted 
                                           ) {
        Node<Integer> current = head;
        for(int count = N; count > 1; --count) {
            for(int i = 0;i<M-1;++i) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
        return current;

    }

    
    public void print() {
        Node<Integer> current = head;
        while (current.getNext() != head) {
            System.out.print("[" + current.getValue() + "]  ");
            current = current.getNext();
        }
        System.out.print("[" + current.getValue() + "]  ");
    }
    
    public void print(Node<Integer> start) {
        Node<Integer> current = start;
        while (current.getNext() != start) {
            System.out.print("[" + current.getValue() + "]  ");
            current = current.getNext();
        }
        System.out.print("[" + current.getValue() + "]  ");
    }

}
