package com.knowledgebase.book.datastrucuture.narasimha.stack;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Stack<E> {
    private static final int CAPA = 20;
    private static final double THRESHOLD = .75;
    private int top = -1;
    
    private E elements[] = null;
    
    @SuppressWarnings("unchecked")
    public Stack(Class<E> c) {
        elements = ((E[]) Array.newInstance(c , CAPA));
    }
    
    public void push(E value) {
        if(top+1 > elements.length) {
            System.out.println(top);
            resize();
        }
        elements[++top] = value;
    }
    
    public E pop() {
        if(top > -1) {
            return elements[top--];
        }
        return null;
    }
    
    private void resize() {
        System.out.println(" resized ++ ");
        E temp[] = Arrays.copyOf(elements, (int)(elements.length + CAPA * THRESHOLD));
        System.out.println("temp after --> "+temp.length);
        elements = temp;
    }
    
    public E top() {
        if(top> -1) {
            return elements[top];
        }
        return (E)new Integer(-1);
    }
    
    public void delete() {
        top = -1;
    }
    
    public boolean isEmpty() {
        return top <0 ? true:false;
    }
}
