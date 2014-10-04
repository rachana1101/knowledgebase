package com.knowledgebase.book.datastrucuture.narasimha.linkedlist.test;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Iterator;

import org.junit.Test;

import com.knowledgebase.book.datastrucuture.narasimha.linkedlist.LinkedList;
import com.knowledgebase.book.datastrucuture.narasimha.linkedlist.Node;

public class LinkedListTest {

    @Test
    public void add() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 5; i++) {
            list.add(new Integer(i));
        }
        assertThat(list.size()).isEqualTo(5);
        System.out.println();
        list.print();
    }

    @Test
    public void addToFront_whenListIsHavingElements() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 5; i++) {
            list.add(new Integer(i));
        }
        assertThat(list.size()).isEqualTo(5);

        // Now add to the front
        list.addInFront(88);
        assertThat(list.size()).isEqualTo(6);
        System.out.println();
        list.print();
    }

    @Test
    public void addToIndex_positive_addWhenHeadNull() {
        LinkedList list = new LinkedList();
        assertThat(list.size()).isEqualTo(0);
        list.addAtIndex(1, 0);
        assertThat(list.size()).isEqualTo(1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void addToIndex_negative_addWhenHeadNull() {
        LinkedList list = new LinkedList();
        assertThat(list.size()).isEqualTo(0);
        list.addAtIndex(1, 10);
    }

    @Test
    public void addToIndex_positive_addWhenHeadNotNull() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 5; i++) {
            list.add(new Integer(i));
        }
        assertThat(list.size()).isEqualTo(5);
        list.addAtIndex(99, 3);
        assertThat(list.size()).isEqualTo(6);
        System.out.println();
        System.out.println("addToIndex_positive_addWhenHeadNotNull");
        list.print();
    }

    @Test
    public void deleteFromFront() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 5; i++) {
            list.add(new Integer(i + 1));
        }
        assertThat(list.size()).isEqualTo(5);

        Node<Integer> node = list.deleteFromFront();
        System.out.println(node.getValue());
        assertThat(list.size()).isEqualTo(4);

        node = list.deleteFromFront();
        System.out.println(node.getValue());
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    public void kthNodeFromEnd() {
        LinkedList list = new LinkedList();
        for (int i = 0; i <= 9; i++) {
            list.add(new Integer(i + 1));
        }
        System.out.println();
        list.print();

        Node<Integer> result = list.kthNodeFromEnd(2);
        System.out.println("kthNodeFromEnd");
        System.out
                .println(" value at 2nd from the end is " + result.getValue());
        System.out.println();
        list.print();

        result = list.kthNodeFromEnd(5);
        System.out.println("kthNodeFromEnd");
        System.out
                .println(" value at 4th from the end is " + result.getValue());
        System.out.println();
        list.print();

        result = list.kthNodeFromEnd(1);
        System.out.println("kthNodeFromEnd");
        System.out
                .println(" value at 1st from the end is " + result.getValue());
        System.out.println();
        list.print();
    }

    @Test
    public void addAndDetectLoop() {
        LinkedList list = new LinkedList();
        for (int i = 0; i <= 9; i++) {
            list.add(new Integer(i + 1));
        }
        System.out.println();
        list.print();
        System.out.println();
        // before adding a loop, check
        System.out.println(" isLoop before " + list.isLoop());

        list.addLoop(4);
        // before adding a loop, check
        System.out.println(" isLoop after " + list.isLoop());
    }

    @Test
    public void whereLoopStarts() {
        LinkedList list = new LinkedList();
        for (int i = 0; i <= 9; i++) {
            list.add(new Integer(i + 1));
        }
        System.out.println();
        list.print();
        System.out.println();
        // before adding a loop, check
        System.out.println(" isLoop before " + list.isLoop());

        list.addLoop(4);
        // before adding a loop, check
        System.out.println(" isLoop after " + list.isLoop());

        Node<Integer> where = list.whereLoopStarts();
        System.out.println(" loop starts at " + where.getValue());
    }

    @Test
    public void findLoopLength_positive_at4() {
        LinkedList list = new LinkedList();
        for (int i = 0; i <= 9; i++) {
            list.add(new Integer(i + 1));
        }
        System.out.println();
        list.print();
        System.out.println();
        // before adding a loop, check
        System.out.println(" isLoop before " + list.isLoop());

        list.addLoop(4);
        // before adding a loop, check
        System.out.println(" isLoop after " + list.isLoop());

        Node<Integer> where = list.whereLoopStarts();
        System.out.println(" loop starts at " + where.getValue());

        System.out.println(" length of loop " + list.findLoopLength());
    }

    @Test
    public void findLoopLength_positive_at7() {
        LinkedList list = new LinkedList();
        for (int i = 0; i <= 9; i++) {
            list.add(new Integer(i + 1));
        }
        System.out.println();
        list.print();
        System.out.println();
        // before adding a loop, check
        System.out.println(" isLoop before " + list.isLoop());

        list.addLoop(7);
        // before adding a loop, check
        System.out.println(" isLoop after " + list.isLoop());

        Node<Integer> where = list.whereLoopStarts();
        System.out.println(" loop starts at " + where.getValue());

        System.out.println(" length of loop " + list.findLoopLength());
    }

    @Test
    public void reverse() {
        LinkedList list = new LinkedList();
        for (int i = 0; i <= 9; i++) {
            list.add(new Integer(i + 1));
        }
        System.out.println();
        list.print();
        System.out.println();
        list.reverse();
        System.out.println();
        list.print();
    }
    
    @Test 
    public void findMid_even() {
        LinkedList list = new LinkedList();
        for (int i = 0; i <= 9; i++) {
            list.add(new Integer(i + 1));
        }
        System.out.println();
        list.print();
        
        Node<Integer> mid = list.findMid();
        System.out.println(" Mid "+mid.getValue());
    }
    
    @Test 
    public void findMid_odd() {
        LinkedList list = new LinkedList();
        for (int i = 0; i <= 15; i++) {
            list.add(new Integer(i + 1));
        }
        System.out.println();
        list.print();
        
        Node<Integer> mid = list.findMid();
        System.out.println(" Mid "+mid.getValue());
    }
    
    @Test 
    public void isEven_even() {
        LinkedList list = new LinkedList();
        for (int i = 0; i <= 9; i++) {
            list.add(new Integer(i + 1));
        }
        System.out.println();
        list.print();
        System.out.println(" isEven "+list.isEven());
    }
    
    @Test 
    public void isEven_odd() {
        LinkedList list = new LinkedList();
        for (int i = 0; i <= 2; i++) {
            list.add(new Integer(i + 1));
        }
        System.out.println();
        list.print();
        System.out.println(" isEven "+list.isEven());
    }

    /**
     * <ul>
     * <li>find the larger list</li>
     * <li>difference = biggerList.size - smaller.size</li>
     * <li>move the larger list by difference to bring both the list at the same
     * starting point</li>
     * <li>move pointer in larger and smaller 1 node at a time till value are
     * same</li>
     * </ul>
     * <ul>
     * <li>Book - Data Structure and algorithms made easy in java</li>
     * <li>Author - Narashimha Karumanchi</li>
     * <li>Chapter - 3 Linked List</li>
     * <li>Problem 17 - reverse the list, implemented with efficient Problem -23
     * </li>
     * <li>Time complexity : O(max(m +n)) and space complexity O(1)</li>
     * <li>
     *  -------\
     *          ------
     *         /
     *     ----    
     * </li>
     * </ul>
     * 
     */
    @Test
    public void findTheMergeElement() {
        LinkedList list1 = new LinkedList();
        for (int i = 0; i <= 9; i++) {
            list1.add(new Integer(i + 1));
        }

        LinkedList list2 = new LinkedList();
        for (int i = 0; i <= 2; i++) {
            list2.add(new Integer(i + 20));
        }
        list2.add(8);
        list2.add(9);
        list2.add(10);

        // print both the list
        System.out.println();
        list1.print();
        System.out.println();
        list2.print();
        
        findIntersection(list1, list2);
    }

    /**
     * <ul>
     * <li>find the larger list</li>
     * <li>difference = biggerList.size - smaller.size</li>
     * <li>move the larger list by difference to bring both the list at the same
     * starting point</li>
     * <li>move pointer in larger and smaller 1 node at a time till value are
     * same</li>
     * </ul>
     * <ul>
     * <li>Book - Data Structure and algorithms made easy in java</li>
     * <li>Author - Narashimha Karumanchi</li>
     * <li>Chapter - 3 Linked List</li>
     * <li>Problem 17 - reverse the list, implemented with efficient Problem -23
     * </li>
     * <li>Time complexity : O(max(m +n)) and space complexity O(1)</li>
     * <li>
     *          |
     *          |
     *   -------
     *          |       
     * </li>
     * </ul>
     * 
     */
    @Test
    public void findTheMergeElement_withT() {
        LinkedList list1 = new LinkedList();
        for (int i = 0; i <= 9; i++) {
            list1.add(new Integer(i + 1));
        }

        LinkedList list2 = new LinkedList();
        for (int i = 0; i <= 2; i++) {
            list2.add(new Integer(i + 20));
        }
        list2.add(6);
        list2.add(91);
        list2.add(101);

        // print both the list
        System.out.println();
        list1.print();
        System.out.println();
        list2.print();
        
        findIntersection(list1, list2);
    }

    
    
    private void findIntersection(LinkedList list1, LinkedList list2) {
        // find the size of current list and otherList size, find the difference
        int difference = 0;
        if (list1.size() > list2.size()) {
            difference = list1.size() - list2.size();
            System.out.println(difference);
            // move the difference in the larger list
            int ctr = 1;
            Node<Integer> pointer1 = list1.head;
            while (ctr <= difference && pointer1.getNext() != null) {
                pointer1 = pointer1.getNext();
                ctr++;
            }
            // Now move the pointer1 and pointer2 at same pace
            Node<Integer> pointer2 = list2.head;
            while (!pointer1.getValue().equals(pointer2.getValue())
                    && (pointer1.getNext() != null && pointer2.getNext() != null)) {
                pointer1 = pointer1.getNext();
                pointer2 = pointer2.getNext();
            }
            System.out.println("Merged at " + pointer1.getValue());
        } else {
            difference = list2.size() - list1.size();
            System.out.println(difference);
            // move the difference in the larger list
            int ctr = 1;
            Node<Integer> pointer1 = list2.head;
            while (ctr <= difference && pointer1.getNext() != null) {
                pointer1 = pointer1.getNext();
                ctr++;
            }
            // Now move the pointer1 and pointer2 at same pace
            Node<Integer> pointer2 = list1.head;
            while (pointer1 != pointer2
                    && pointer1.getNext() != null && pointer2.getNext() != null) {
                pointer1 = pointer1.getNext();
                pointer2 = pointer2.getNext();
            }
            System.out.println("Merged at " + pointer1.getValue());
        }
    }
    /**
    * TODO - implementation
    * <ul>
    *      <li>Book - Data Structure and algorithms made easy in java</li>
    *      <li>Author - Narashimha Karumanchi</li>
    *      <li>Chapter - 3 Linked List</li>
    *      <li>Problem 30 - if the head is at the kth node how to find the previous node. User XOR linked list </li>
    * </ul>
    */
    @Test 
    public void mergeToListInSortedManner() {
        LinkedList list1 = new LinkedList();
        list1.add(1);
        list1.add(3);
        list1.add(6);
        list1.add(7);
        LinkedList list2 = new LinkedList();
        list2.add(4);
        list2.add(5);
        list2.add(10);
        
        // print both the list
        System.out.println();
        list1.print();
        System.out.println();
        list2.print();
        
        LinkedList result = new LinkedList();
        while(list1.head!=null && list2.head!=null) {
            if(list1.head.getValue()<=list2.head.getValue()) {
                result.add(list1.head.getValue());
                list1.head = list1.head.getNext();
            } else {
                result.add(list2.head.getValue());
                list2.head = list2.head.getNext();
            }
        }
        if(list1.head!=null) {
            result.add(list1.head.getValue());
        }
        if(list2.head!=null) {
            result.add(list2.head.getValue());
        }
        
        // print both the list
        System.out.println();
        result.print();
    }
    
    @Test
    public void iteratorHasNext() {
        LinkedList list1 = new LinkedList();
        for (int i = 0; i <= 9; i++) {
            list1.add(new Integer(i + 1));
        }
        
        Iterator<Node<Integer>> itr = list1.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next().getValue());
        }
    }
    
    @Test
    public void reverseInPair() {
        LinkedList list1 = new LinkedList();
        for (int i = 0; i <= 9; i++) {
            list1.add(new Integer(i + 1));
        }
        // print both the list
        System.out.println();
        list1.print();
        
        
        list1.reverseInPair();
        System.out.println();
        list1.print();
    }
    
    @Test
    public void exchangeAdjacentNode() {
        LinkedList list1 = new LinkedList();
        for (int i = 0; i <= 9; i++) {
            list1.add(new Integer(i + 1));
        }
        // print both the list
        System.out.println();
        list1.print();
        
        
        list1.exchangeAdjacentNode();
        System.out.println();
        list1.print();
    }

    @Test
    public void reverseFromKthNode() {
        LinkedList list1 = new LinkedList();
        for (int i = 0; i <= 9; i++) {
            list1.add(new Integer(i + 1));
        }
        // print both the list
        System.out.println();
        list1.print();
        
        
        list1.reverseFromKthNode(5);
        System.out.println();
        list1.print();
    }

    
}
