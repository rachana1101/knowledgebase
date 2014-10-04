package com.knowledgebase.book.datastrucuture.narasimha.queue;

import com.knowledgebase.book.datastrucuture.narasimha.stack.Stack;

public class TwoStackQueue {
    
    Stack<Integer> inStack = new Stack<Integer>(Integer.class);
    Stack<Integer> outStack = new Stack<Integer>(Integer.class);
    
    public void enqueue(int value) {
        inStack.push(value);
    }
    
    public int deque() {
        if(!outStack.isEmpty()) {
            while(!outStack.isEmpty()) {
                return outStack.pop();
            } 
        } else {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }
}
