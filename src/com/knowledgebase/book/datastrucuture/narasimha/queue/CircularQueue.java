package com.knowledgebase.book.datastrucuture.narasimha.queue;

public class CircularQueue {
    int size = 5;
    Integer[] elements = new Integer[size];
    int front = -1;
    int rear = -1;

    public void enque(Integer value) {
        if (rear < size - 1) {
            elements[++rear] = value;
        } else if (rear == size - 1 && rear - front > 0) {
            System.out.println(" have reached ");
            // that means rear is at 10 and we are checking if slot is empty or
            // not
            rear = -1;
            elements[++rear] = value;
        } else {
            throw new StackOverflowError();
        }
    }

    public Integer deque() {
        if (!isEmpty()) {
            return elements[++front];
        } else if (front == size - 1) {
            front = -1;
            return elements[++front];
        }
        return null;
    }

    private boolean isEmpty() {
        if (rear < 0) {
            return true;
        } else {
            return false;
        }
    }
}
