package com.knowledgebase.book.datastrucuture.narasimha.linkedlist.test;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

import com.knowledgebase.book.datastrucuture.narasimha.linkedlist.CircularLinkedList;
import com.knowledgebase.book.datastrucuture.narasimha.linkedlist.Node;

public class CircularLinkedListTest {
    
    @Test
    public void add() {
        CircularLinkedList list = new CircularLinkedList();
        for(int i =0;i<5;i++) {
            list.add(new Integer(i));
        }
        assertThat(list.size()).isEqualTo(5);
        System.out.println();
        list.print();
    }

    @Test
    public void addAtEnd() {
        CircularLinkedList list = new CircularLinkedList();
        for(int i =0;i<5;i++) {
            list.addAtEnd(new Integer(i));
        }
        assertThat(list.size()).isEqualTo(5);
        System.out.println();
        list.print();
        
        list.addAtEnd(100);
        assertThat(list.size()).isEqualTo(6);
        System.out.println();
        list.print();
    }

    @Test
    public void addAtFront() {
        CircularLinkedList list = new CircularLinkedList();
        for(int i =0;i<5;i++) {
            list.add(new Integer(i));
        }
        assertThat(list.size()).isEqualTo(5);
        System.out.println();
        list.print();
        
        list.addAtFront(100);
        assertThat(list.size()).isEqualTo(6);
        System.out.println();
        list.print();
        
        list.addAtFront(111);
        assertThat(list.size()).isEqualTo(7);
        System.out.println();
        list.print();
    }
    
    @Test
    public void deleteFromFront() {
        CircularLinkedList list = new CircularLinkedList();
        for(int i =0;i<5;i++) {
            list.add(new Integer(i+1));
        }
        assertThat(list.size()).isEqualTo(5);
        System.out.println();
        list.print();
        
        Node<Integer> deleted = list.deleteFromFront();
        System.out.println();
        System.out.print("[" + deleted.getValue() + "]  ");
        
        assertThat(list.size()).isEqualTo(4);
        System.out.println();
        list.print();
        
        deleted = list.deleteFromFront();
        System.out.println();
        System.out.print("[" + deleted.getValue() + "]  ");
        
        assertThat(list.size()).isEqualTo(3);
        System.out.println();
        list.print();
    }
    
    @Test
    public void deleteFromEnd() {
        CircularLinkedList list = new CircularLinkedList();
        for(int i =0;i<5;i++) {
            list.add(new Integer(i+1));
        }
        assertThat(list.size()).isEqualTo(5);
        System.out.println();
        list.print();
        
        Node<Integer> deleted = list.deleteFromEnd();
        System.out.println();
        System.out.print("[" + deleted.getValue() + "]  ");
        
        assertThat(list.size()).isEqualTo(4);
        System.out.println();
        list.print();
        
        deleted = list.deleteFromEnd();
        System.out.println();
        System.out.print("[" + deleted.getValue() + "]  ");
        
        assertThat(list.size()).isEqualTo(3);
        System.out.println();
        list.print();
    }
    
    @Test
    public void splitHalf() {
        CircularLinkedList list = new CircularLinkedList();
        for(int i =0;i<10;i++) {
            list.add(new Integer(i+1));
        }
        System.out.println();
        list.print();
        
        list.splitList();
    }
    
    @Test
    public void getJosephusCirlce() {
        CircularLinkedList list = new CircularLinkedList();
        for(int i =0;i<10;i++) {
            list.add(new Integer(i+1));
        }
        System.out.println();
        list.print();
        
        Node<Integer> leader = list.getJosephusCircle(list.size(), 10);
        System.out.println(" leader "+ leader.getValue());
    }
}
