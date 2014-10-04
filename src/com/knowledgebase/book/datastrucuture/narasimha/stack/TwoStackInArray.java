package com.knowledgebase.book.datastrucuture.narasimha.stack;

import java.lang.reflect.Array;

public class TwoStackInArray<E> {
    
    private static final int CAPA = 20;
    private static final double THRESHOLD = .75;
    private int stackOneTop = 0;
    private int stackTwoTop = 0;
    
    
    private E elements[] = null;
    
    @SuppressWarnings("unchecked")
    public TwoStackInArray(Class<E> c) {
        elements = ((E[]) Array.newInstance(c , CAPA));
        stackTwoTop = CAPA-1;
    }

    public void pushStackOne(E value) {
        //checkLimit();
        if(stackOneTop < stackTwoTop) {
            elements[stackOneTop++] = value;
        }
    }    
    public void pushStackTwo(E value) {
        //checkLimit();
        if(stackTwoTop > stackOneTop) {
            elements[stackTwoTop--] = value;
        }
    }
    
    public E popStackOne() {
        if(stackOneTop> -1) {
            return elements[--stackOneTop]; 
        }
        return null;
    }
    
    public E popStackTwo() {
        if(stackTwoTop> stackOneTop && stackTwoTop <CAPA-1) {
            return elements[++stackTwoTop]; 
        }
        return null;
    }
    
    public void checkLimit() {
        if(stackOneTop + stackTwoTop >= CAPA || stackOneTop + stackTwoTop<0 ) {
            System.out.println("Cannot push more ");
            return; 
        }
    }
}
