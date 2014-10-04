package com.knowledgebase.thread.readwrite;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerThread {
    
    public static void main(String... s) {
        SQueue<Integer> queue = new SQueue<Integer>();
        new Producer(queue);
        new Consumer(queue);
    }
}

class SQueue<E> {
    int size = 5;
    List<E> elements = new ArrayList<E>(5);
    boolean isAvailable = false;
    synchronized public E get() {
        try {
            while(!isAvailable) {
                wait();
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        if(elements.size()<0) {
            isAvailable = false;
        }
        E value = elements.get(elements.size()-1);
        notify();
        return value;
    }
    
    synchronized public void set(E value) {
        try {
           while(isAvailable) {
               wait();
           }
        } catch(Exception e) {
            System.out.println(e);
        }
        elements.add(value);
        if(elements.size()>size) {
            isAvailable = true;
        }
        notify();
    }
}

class Producer implements Runnable {
    SQueue<Integer> queue = new SQueue<>();
    
    public Producer(SQueue<Integer> queue) {
        this.queue = queue;
        new Thread(this).start();;
    }

    @Override
    public void run() {
        int ctr = 1;
        while(true) {
            queue.set(ctr++);
        }
    }
}

class Consumer implements Runnable {

    SQueue<Integer> queue = new SQueue<>();

    public Consumer(SQueue<Integer> queue) {
        this.queue = queue;
        new Thread(this).start();;
    }
    
    @Override
    public void run() {
        while(true) {
            System.out.println(">>>> "+queue.get());
        }
    }
    
}