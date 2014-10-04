package com.knowledgebase.book.datastrucuture.narasimha.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList implements Iterable<Node<Integer>> {

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
        } else {
            Node<Integer> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            } // take it to the end
            current.setNext(createNode(value));
        }
        size++;
    }

    /**
     * To add the value at the beginning of the list
     * 
     * @param node
     */
    public void addInFront(Integer value) {
        if (head == null) {
            head = new Node<Integer>(value, null);
        } else {
            Node<Integer> temp = head;
            Node<Integer> newNode = createNode(value);
            newNode.setNext(temp); // assign the next of head to the next of
                                   // newNode
            head = newNode; // now assign the new node to the head's next
        }
        size++;
    }

    /**
     * To add the value at the position requested by the user
     * 
     * @param value
     * @param position
     */
    public void addAtIndex(Integer value, Integer position) {
        int ctr = 0;
        if (position > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (head == null) {
            head = new Node<Integer>(value, null);
        } else {
            Node<Integer> current = head;
            Node<Integer> previous = current;
            while (ctr != position && current.getNext() != null) {
                previous = current;
                current = current.getNext();
                ctr++;
            } // take it to the position
            Node<Integer> newNode = createNode(value);
            newNode.setNext(current);
            previous.setNext(newNode);
        }
        size++;
    }

    /**
     * Remove the element from the front of the list
     * 
     * @return
     */
    public Node<Integer> deleteFromFront() {
        if (head == null) {
            return null;
        } else {
            Node<Integer> current = head;
            Node<Integer> temp = current.getNext();
            head = temp;
            current.setNext(null);
            size--;
            return current;
        }
    }

    /**
     * <ul>
     * <li>Book - Data Structure and algorithms made easy in java</li>
     * <li>Author - Narashimha Karumanchi</li>
     * <li>Chapter - 3 Linked List</li>
     * <li>Problem 2 - Find the kth Node from the end</li>
     * </ul>
     * 
     * @param k
     * @return
     */
    public Node<Integer> kthNodeFromEnd(int k) {
        if (head == null) {
            return null;
        }
        if (k > size) {
            return null;
        } else {
            // we will use two pointers
            Node<Integer> pointer1 = head;
            Node<Integer> pointer2 = head;
            // lets move pointer2
            int ctr = 1;
            while (ctr < k && pointer2.getNext() != null) {
                pointer2 = pointer2.getNext();
                ctr++;
            }
            while (pointer2.getNext() != null) {
                pointer1 = pointer1.getNext();
                pointer2 = pointer2.getNext();
            }
            Node<Integer> temp = pointer1;
            return temp;
        }
    }

    /**
     * addLoop - add loop at the given element ----- -------/ \ \ / -----
     * 
     * @param atElement
     */
    public void addLoop(int atElement) {
        if (head != null) {
            Node<Integer> pointer1 = head;
            Node<Integer> pointer2 = head;
            while (pointer2.getNext() != null) {
                pointer2 = pointer2.getNext();
            }
            int ctr = 1;
            while (ctr < atElement) {
                pointer1 = pointer1.getNext();
                ctr++;
            }
            if (pointer2.getNext() == null) {
                pointer2.setNext(pointer1);
            }
        }
    }

    /**
     * This method is called floyd method - one slow and one faster pointer, if
     * they meet that means there is a loop otherwise not
     * <ul>
     * <li>Book - Data Structure and algorithms made easy in java</li>
     * <li>Author - Narashimha Karumanchi</li>
     * <li>Chapter - 3 Linked List</li>
     * <li>Problem 6 - Find the kth Node from the end</li>
     * <li>Problem 10 - is snail or snake</li>
     * </ul>
     * 
     * @return boolean
     * 
     */
    public boolean isLoop() {
        if (head != null) {
            Node<Integer> slowPtr = head.getNext(); // this will move 1 step
            Node<Integer> fastPtr = head.getNext().getNext(); // this will move
                                                              // 2 steps

            while (true) {
                if (slowPtr == fastPtr) {
                    return true;
                } else if (fastPtr.getNext().getNext() == null) {
                    return false;
                }
                slowPtr = slowPtr.getNext();
                fastPtr = fastPtr.getNext().getNext();
            }
        }
        return false;
    }

    /**
     * <ul>
     * <li>STEP - 1 This method is called floyd method - one slow and one faster
     * pointer, if they meet that means there is a loop otherwise not</li>
     * <li>STEP - 2 once they meet, move the slow point to the head and just
     * move both slow and fast pointer 1 at a time till they meet. That should
     * be starting point</li>
     * </ul>
     * <ul>
     * <li>Book - Data Structure and algorithms made easy in java</li>
     * <li>Author - Narashimha Karumanchi</li>
     * <li>Chapter - 3 Linked List</li>
     * <li>Problem 11 - find the starting point</li>
     * </ul>
     * 
     * @return boolean
     * @return
     */
    public Node<Integer> whereLoopStarts() {
        if (this.isLoop()) {

            if (head != null) {
                Node<Integer> slowPtr = head.getNext(); // this will move 1 step
                Node<Integer> fastPtr = head.getNext().getNext(); // this will
                                                                  // move
                                                                  // 2 steps
                while (slowPtr != fastPtr) {
                    slowPtr = slowPtr.getNext();
                    fastPtr = fastPtr.getNext().getNext();
                }
                // once they are meet, make slowPtr = head to start it from the
                // head and to be equal distant from the fastPtr.
                slowPtr = head;
                while (slowPtr != fastPtr) {
                    // now just move 1 step for both the pointers
                    slowPtr = slowPtr.getNext();
                    fastPtr = fastPtr.getNext();
                }
                return slowPtr;
            }
        }
        return null;
    }

    /**
     * <ul>
     * <li>STEP - 1 This method is called floyd method - one slow and one faster
     * pointer, if they meet that means there is a loop otherwise not</li>
     * <li>STEP - 2 once they meet, make the slowPtr = fstPoint.getNext and loop
     * it while they meet. this will give totlal length of a loop</li>
     * </ul>
     * <ul>
     * <li>Book - Data Structure and algorithms made easy in java</li>
     * <li>Author - Narashimha Karumanchi</li>
     * <li>Chapter - 3 Linked List</li>
     * <li>Problem 11 - find the starting point</li>
     * </ul>
     * 
     * @return boolean
     * @return
     */
    public int findLoopLength() {
        if (this.isLoop()) {
            if (head != null) {
                Node<Integer> slowPtr = head.getNext(); // this will move 1 step
                Node<Integer> fastPtr = head.getNext().getNext(); // this will
                                                                  // move
                                                                  // 2 steps
                while (slowPtr != fastPtr) {
                    slowPtr = slowPtr.getNext();
                    fastPtr = fastPtr.getNext().getNext();
                }
                // once they are meet, make slowPtr = head to start it from the
                // head and to be equal distant from the fastPtr.
                slowPtr = fastPtr.getNext();
                int ctr = 1;
                while (slowPtr != fastPtr) {
                    // now just move 1 step for both the pointers
                    slowPtr = slowPtr.getNext();
                    ctr++;
                }
                return ctr;
            }
        }
        return 0;
    }

    /**
     * TODO : Find the elements > than the value passed and add in front of it.
     * <ul>
     * <li>Book - Data Structure and algorithms made easy in java</li>
     * <li>Author - Narashimha Karumanchi</li>
     * <li>Chapter - 3 Linked List</li>
     * <li>Problem 15 - Add the value to the sorted list</li>
     * </ul>
     * 
     * @param value
     */
    public void addValueToSortedLinkedList(int value) {
    }

    /**
     * <ul>
     * <li>Book - Data Structure and algorithms made easy in java</li>
     * <li>Author - Narashimha Karumanchi</li>
     * <li>Chapter - 3 Linked List</li>
     * <li>Problem 16 - reverse the list</li>
     * </ul>
     * 
     */
    public void reverse() {
        Node<Integer> temp = null;
        Node<Integer> current = null;
        while (head != null) {
            current = head.getNext();
            head.setNext(temp);
            temp = head;
            head = current;
        }
        head = temp;
    }

    /**
     * <ul>
     * <li>Book - Data Structure and algorithms made easy in java</li>
     * <li>Author - Narashimha Karumanchi</li>
     * <li>Chapter - 3 Linked List</li>
     * <li>Problem 24 - Find mid of the list using solution in problem 27</li>
     * </ul>
     * 
     */
    public Node<Integer> findMid() {
        if (head != null) {
            Node<Integer> pointer1 = head;
            Node<Integer> pointer2 = head;
            int ctr = 0;
            while (pointer2 != null) {
                if (ctr == 0) {
                    pointer2 = pointer2.getNext();
                    ctr = 1;
                }
                if (ctr == 1) {
                    if (pointer2 != null) {
                        pointer1 = pointer1.getNext();
                        pointer2 = pointer2.getNext();
                    }
                    ctr = 0;
                }
            }
            return pointer1;
        }
        return null;
    }

    /**
     * TODO - Implementation
     * <ul>
     * <li>Book - Data Structure and algorithms made easy in java</li>
     * <li>Author - Narashimha Karumanchi</li>
     * <li>Chapter - 3 Linked List</li>
     * <li>Problem 25 - Display list from the end</li>
     * </ul>
     * 
     */
    public void printFromEnd() {
    }

    /**
     * <ul>
     * <li>Book - Data Structure and algorithms made easy in java</li>
     * <li>Author - Narashimha Karumanchi</li>
     * <li>Chapter - 3 Linked List</li>
     * <li>Problem 29 - if the length of the list is even or odd</li>
     * </ul>
     * 
     */
    public boolean isEven() {
        if (head != null) {
            while (head != null && head.getNext() != null) {
                head = head.getNext().getNext();
            }
            if (head == null) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * TODO - implementation
     * <ul>
     * <li>Book - Data Structure and algorithms made easy in java</li>
     * <li>Author - Narashimha Karumanchi</li>
     * <li>Chapter - 3 Linked List</li>
     * <li>Problem 30 - if the head is at the kth node how to find the previous
     * node. User XOR linked list</li>
     * </ul>
     * 
     */
    public void findPreviousFromKthNode(int k) {
    }

    /**
     * <ul>
     * <li>Book - Data Structure and algorithms made easy in java</li>
     * <li>Author - Narashimha Karumanchi</li>
     * <li>Chapter - 3 Linked List</li>
     * <li>Problem 32 - Reverse the linked list in pairs, if you have a linked
     * list that holds 1->2->3->4->X, then after applying the function has been
     * called the liked list would hold 2->1->4->3->X</li>
     * </ul>
     */
    public void reverseInPair() {
        if (head != null) {
            Node<Integer> first, second = head;
            first = head;
            second = head.getNext();
            while (first != null && second.getNext() != null) {
                Node<Integer> temp = second.getNext();
                first.setNext(temp);
                second.setNext(first);
                System.out.println(second.getValue());
                System.out.println(first.getValue());
                first = temp;
                second = first.getNext();
            }
        }
    }

    public void reverseInPairR(Node<Integer> node) {
    }

    /**
     * TODO implementation
     * <ul>
     * <li>Book - Data Structure and algorithms made easy in java</li>
     * <li>Author - Narashimha Karumanchi</li>
     * <li>Chapter - 3 Linked List</li>
     * <li>Problem 34 - Sorting the linked list</li>
     * </ul>
     */
    public void sortLinkedList(Node<Integer> first) {
    }

    /**
     * <ul>
     * <li>Book - Data Structure and algorithms made easy in java</li>
     * <li>Author - Narashimha Karumanchi</li>
     * <li>Chapter - 3 Linked List</li>
     * <li>Problem 38 - Exchange the adjacent elements in a link list</li>
     * </ul>
     */
    public void exchangeAdjacentNode() {
        Node<Integer> current, temp, next;
        current = head;
        if (current == null || current.getNext() == null) {
            return;
        }
        while (current != null && current.getNext() != null) {
            next = current.getNext();
            current.setNext(next.getNext());
            temp = current.getNext();
            next.setNext(current);
            if (temp != null && temp.getNext() != null) {
                current.setNext(current.getNext().getNext());
            }
            current = temp;
        }
    }

    /**
     * <ul>
     * <li>Book - Data Structure and algorithms made easy in java</li>
     * <li>Author - Narashimha Karumanchi</li>
     * <li>Chapter - 3 Linked List</li>
     * <li>Problem 39 - For a given K value (K>0) reverse blocks of K nodes in a
     * list Input : 1 2 3 4 5 6 7 8 9 10 For K : 2 2 1 3 4 5 6 7 8 9 10 For K :
     * 3 3 2 1 4 5 6 7 8 9 10</li>
     * </ul>
     */
    public void reverseFromKthNode(int k) {
        if (head != null) {
            Node<Integer> current = head;
            int ctr = 0;
            if (k > size) {
                return;
            }

            Node<Integer> temp2 = head;
            while (ctr <= k && temp2.getNext() != null) {
                temp2 = temp2.getNext();
                ctr++;
            }
            Node<Integer> temp = temp2.getNext();
            ctr = 0;
            while (ctr <= k && current.getNext() != null && temp2 != null) {
                ctr++;
                current = head.getNext();
                head.setNext(temp);
                temp = head;
                head = current;
            }
            head = temp;
        }
    }
    
    public Node<Integer> getElement(int index) {
        if (head == null) {
            return null;
        } else {
            Node<Integer> current = head;
            int ctr = 0;
            while (current.getNext() != null && ctr != index) {
                current = current.getNext();
                ctr++;
            }
            return current;
        }
    }

    private Node<Integer> createNode(Integer value) {
        return new Node<Integer>(value, null);
    }

    public int size() {
        return size;
    }

    public void print() {
        Node<Integer> current = head;
        while (current != null) {
            System.out.print("[" + current.getValue() + "]  ");
            current = current.getNext();
        }
    }

    public void print(Node<Integer> start) {
        Node<Integer> current = start;
        while (current != null && start != null && current.getNext() != start) {
            System.out.print("[" + current.getValue() + "]  ");
            current = current.getNext();
        }
        if (current != null)
            System.out.print("[" + current.getValue() + "]  ");
    }

    public class MyIterator implements Iterator<Node<Integer>> {
        private Node<Integer> lastReturned = null;
        private Node<Integer> next;
        private int nextIndex;

        public MyIterator(int index) {
            next = (index == size) ? null : getElement(index);
            nextIndex = index;
        }

        public MyIterator() {
            if (head != null) {
                next = head;
                nextIndex = 0;
            }
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public Node<Integer> next() {
            if (!hasNext())
                throw new NoSuchElementException();

            if (next != null) {
                lastReturned = next;
                next = next.getNext();
                nextIndex++;
                return lastReturned;
            }
            return null;
        }

        public void remove() {
            // implement... if supported.
        }
    }

    public Iterator<Node<Integer>> iterator() {
        return new MyIterator();
    }
}
