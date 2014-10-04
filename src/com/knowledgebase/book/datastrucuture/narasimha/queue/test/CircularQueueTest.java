package com.knowledgebase.book.datastrucuture.narasimha.queue.test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

import org.junit.Test;

import com.knowledgebase.book.datastrucuture.narasimha.queue.CircularQueue;
import com.knowledgebase.book.datastrucuture.narasimha.queue.TwoStackQueue;
import com.knowledgebase.book.datastrucuture.narasimha.stack.Stack;

public class CircularQueueTest {
    @Test
    public void circularQueue() {
        CircularQueue queue = new CircularQueue();
        for(int i =0;i<5;i++) {
            queue.enque(i);
        }
        for(int i =0;i<5;i++) {
            System.out.println(queue.deque());
        }
    }
    
    @Test
    public void circularQueue_checkCircular() {
        CircularQueue queue = new CircularQueue();
        for(int i =0;i<5;i++) {
            queue.enque(i);
        }
        for(int i =0;i<5;i++) {
            System.out.println(queue.deque());
        }
        for(int i =5;i<14;i++) {
            queue.enque(i);
        }
        for(int i =0;i<9;i++) {
            System.out.println(queue.deque());
        }
    }
    
    @Test
    public void queueReversal() {
        ArrayBlockingQueue<Integer> queue =  new ArrayBlockingQueue<Integer>(5);
        for(int i =0;i<5;i++) {
            queue.add(i);
        }
        for(int i =0;i<5;i++) {
            //System.out.println(queue.poll());
        }
        Stack<Integer> stack = new Stack<Integer>(Integer.class);
        while(!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
    
    @Test
    public void TwoStackQueue() {
        TwoStackQueue queue = new com.knowledgebase.book.datastrucuture.narasimha.queue.TwoStackQueue();
        for(int i =0;i<5;i++) {
            queue.enqueue(i);
        }
        for(int i =0;i<5;i++) {
            System.out.println(queue.deque());
        }
    }
    
    @Test
    public void slidingWindow() {
        int[] A = new int[]{1,3,-1,-3,5,3,6,7};
        int[] r = maxSlidingWindow(A, A.length, 3, new int[10]);
        System.out.println(Arrays.toString(r));
    }
    /**
     * http://leetcode.com/2011/01/sliding-window-maximum.html
     * @param A
     * @param n
     * @param w
     * @param B
     * @return
     */
    int[] maxSlidingWindow(int A[], int n, int w, int B[]) {
        ArrayDeque<Integer> Q = new ArrayDeque<Integer>(10);
        for (int i = 0; i < w; i++) {
          while (!Q.isEmpty() && A[i] >= A[Q.peekLast()]) {
            Q.pollLast();
          }
          Q.addLast(i);
        }
        for (int i = w; i < n; i++) {
          B[i-w] = A[Q.peekFirst()];
          while (!Q.isEmpty() && A[i] >= A[Q.peekLast()]) {
            Q.pollLast();
          }
          while (!Q.isEmpty() && Q.pollFirst() <= i-w) {
            Q.pollFirst();
          }
          Q.addFirst(i);
        }
        B[n-w] = A[Q.peekFirst()];
        return B;
      }
}
