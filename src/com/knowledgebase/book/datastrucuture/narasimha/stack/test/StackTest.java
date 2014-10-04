package com.knowledgebase.book.datastrucuture.narasimha.stack.test;

import java.util.Arrays;

import org.junit.Test;

import com.knowledgebase.book.datastrucuture.narasimha.stack.AdvancedStack;
import com.knowledgebase.book.datastrucuture.narasimha.stack.Stack;
import com.knowledgebase.book.datastrucuture.narasimha.stack.TwoStackInArray;

public class StackTest {

    @Test
    public void pushNPop() {
        Stack<Integer> stack = new Stack<Integer>(Integer.class);
        for (int i = 0; i < 30; i++) {
            stack.push(i + 1);
        }
        for (int i = 0; i < 30; i++) {
            System.out.println(stack.pop());
        }
    }

    @Test
    public void getMin() {
        AdvancedStack stack = new AdvancedStack();
        stack.push(10);
        stack.push(20);
        stack.push(5);

        System.out.println(stack.getMin());
    }

    @Test
    public void isPalindrome() {
        String str = "ababaXababai";
        char[] chars = str.toCharArray();
        boolean flag = true;
        for (int i = 0, j = str.length() - 1; i != j; j--, i++) {
            if (chars[i] != chars[j]) {
                flag = false;
            }
        }
        System.out.println("isPalindrom" + flag);
    }

    @Test
    public void twoStack() {
        TwoStackInArray<Integer> twoStack = new TwoStackInArray<Integer>(
                Integer.class);
        for (int i = 0; i < 10; i++) {
            twoStack.pushStackOne(i + 1);
        }

        for (int i = 0; i < 10; i++) {
            twoStack.pushStackTwo(i + 100);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(twoStack.popStackOne());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(twoStack.popStackTwo());
        }
    }

    /**
     * For example, if an array of 7 days prices is given as {100, 80, 60, 70,
     * 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1,
     * 2, 1, 4, 6}
     */
    @Test
    public void Stack52WeekHigh() {
        int[] inputArray = new int[] { 23, 45, 12, 34, 22, 1 }; // {100, 80, 60,
                                                                // 70, 60, 75,
                                                                // 85};
        int[] spans = findingSpan(inputArray);
        System.out.println(Arrays.toString(spans));
    }

    private int[] findingSpan(int[] inputArray) {
        int[] spans = new int[inputArray.length];

        Stack<Integer> stack = new Stack<Integer>(Integer.class);
        int p = 0;
        for (int i = 0; i < inputArray.length; i++) {
            System.out.println(stack.top());
            if (!stack.isEmpty()) {
                System.out.println("-->" + inputArray[(int) stack.top()]);
            }
            while (!stack.isEmpty()
                    && inputArray[i] > inputArray[(int) stack.top()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                p = -1;
            } else {
                p = (int) stack.top();
            }
            spans[i] = i - p; // for i=0, span[i] = 0-(-1) = 1
            stack.push(i); // [0,]
        }
        return spans;
    }
    
    @Test
    public void sortStack() {
        Stack<Integer> stack = new Stack<Integer>(Integer.class);
        stack.push(10);
        stack.push(5);
        stack.push(11);
        stack.push(6);
        
        Stack result = this.sort(stack);
        for(int i=0;i<4;i++) {
            System.out.println(result.pop());
        }
    }
    
    private Stack sort(Stack inputStack) {
        Stack result = new Stack<Integer>(Integer.class);
        while(!inputStack.isEmpty()) {
            int tmp = (int)inputStack.pop();
            while(!result.isEmpty() && (int)result.top() > tmp) {
                inputStack.push(result.pop());
            }
            result.push(tmp);
        }
        return result;
    }
}


