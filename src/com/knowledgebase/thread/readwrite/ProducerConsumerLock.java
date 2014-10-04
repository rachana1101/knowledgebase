package com.knowledgebase.thread.readwrite;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerLock {
    
    public static void main(String... s) {
        SQueueL<Integer> queue = new SQueueL<Integer>();
        new ProducerL(queue);
        new ConsumerL(queue);
    }
}

class SQueueL<E> {
    int size = 5;
    List<E> elements = new ArrayList<E>(5);
    Lock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();
    
    public E get() {
        lock.lock();
        try {
            while(elements.size()<=0) {
                notEmpty.await();
            }
            E value = elements.remove(elements.size()-1);
            notFull.signal();
            return value;
        }catch(Exception e) {
            System.out.println(e);
            lock.unlock();
        }
        return null;
    }
    
    public void set(E value) {
        lock.lock();
        try {
            while(elements.size() == size) {
                notFull.await();   
            }
            elements.add(value);
            notEmpty.signal();
        } catch(Exception e) {
            System.out.println(e);
            lock.unlock();
        }
    }
}

class ProducerL implements Runnable {
    SQueueL<Integer> queue = new SQueueL<>();
    
    public ProducerL(SQueueL<Integer> queue) {
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

class ConsumerL implements Runnable {

    SQueueL<Integer> queue = new SQueueL<>();

    public ConsumerL(SQueueL<Integer> queue) {
        this.queue = queue;
        new Thread(this).start();;
    }
    
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(">>>> "+queue.get());
        }
    }
    
}