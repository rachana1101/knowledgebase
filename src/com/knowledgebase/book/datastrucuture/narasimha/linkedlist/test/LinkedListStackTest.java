package com.knowledgebase.book.datastrucuture.narasimha.linkedlist.test;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

import com.knowledgebase.book.datastrucuture.narasimha.linkedlist.LinkedListStack;
import com.knowledgebase.book.datastrucuture.narasimha.linkedlist.Node;

public class LinkedListStackTest {
    @Test
    public void push() {
        LinkedListStack list = new LinkedListStack();
        for(int i =0;i<5;i++) {
            list.push(new Integer(i+1));
        }
        assertThat(list.size()).isEqualTo(5);
        
        //Now add to the front 
        list.push(88);
        assertThat(list.size()).isEqualTo(6);
        System.out.println();
        list.print();
    }
    @Test 
    public void pop() {
        LinkedListStack list = new LinkedListStack();
        for(int i =0;i<5;i++) {
            list.push(new Integer(i+1));
        }
        assertThat(list.size()).isEqualTo(5);
        
        Node<Integer> node = list.pop();
        System.out.println("popped - "+node.getValue());
        assertThat(list.size()).isEqualTo(4);
        
        node = list.pop();
        System.out.println("popped - "+node.getValue());
        assertThat(list.size()).isEqualTo(3);
        
        System.out.println();
        list.print();
    }
    
    @Test 
    public void pop_all() {
        LinkedListStack list = new LinkedListStack();
        for(int i =0;i<5;i++) {
            list.push(new Integer(i+1));
        }
        assertThat(list.size()).isEqualTo(5);
        
        Node<Integer> node = null;
        while((node = list.pop()) != null) {
            System.out.println("popped - "+node.getValue());
            System.out.println();
            list.print();
        }
    }
}
