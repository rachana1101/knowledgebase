package com.knowledgebase.book.datastrucuture.narasimha.stack;

public class AdvancedStack implements IStack<Integer>{
    Stack<Integer> stack = new Stack<Integer>(Integer.class);
    Stack<Integer> minStack = new Stack<Integer>(Integer.class);
    
    @Override
    public void push(Integer value) {
        stack.push(value);
        if(minStack.top()==null) {
            minStack.push(value);
        } else if (minStack.top() > value) {
            //minStack.pop();
            minStack.push(value);
        }
    }

    @Override
    public Integer pop() {
       return stack.pop();
    }
    
    public Integer getMin() {
        return minStack.top();
    }

}
