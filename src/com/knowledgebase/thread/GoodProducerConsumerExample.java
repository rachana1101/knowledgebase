package com.knowledgebase.thread;
/**
 * This example demonstrated the classic of 
 * {@link Producer} and {@link Consumer}. 
 * It fixes the problem of {@link BadProducerConsumerExample}
 * by using notify() and wait()
 *  
 * @author rachana
 * 
 * 
 * PUT VALUE 28290
 * GOT VALUE 28290
 * PUT VALUE 28291
 * GOT VALUE 28291
 * PUT VALUE 28292
 * GOT VALUE 28292
 * PUT VALUE 28293
 * GOT VALUE 28293
 *
 */
public class GoodProducerConsumerExample {
    
    public static void main(String[] argc) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}

class Q {
    private int n;
    boolean isValueSet = false;
    synchronized public int get() {
        while(!isValueSet) {
            try {
                wait(); //wait there is value to be consumed
            } catch (InterruptedException e) {
                e.printStackTrace();
            } 
        }
        System.out.println( " GOT VALUE "+n);
        isValueSet = false;
        notify(); // notify the set that value is been consumed
        return n;
    }
    synchronized public int set(int n) {
        while(isValueSet) {
            try {
                wait(); //wait till the value is not consumed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }  
        }
        this.n = n;
        System.out.println(" PUT VALUE "+n);
        isValueSet = true;  
        notify(); // notify the getter, to check for the value in queue
        return this.n;
    }
}

class Producer implements Runnable{
    Q q; 
    
    public Producer(Q q) {
        this.q = q;
        new Thread(this).start();
    }

    @Override
    public void run() {
        int i = 0;
        while(true) {
             this.q.set(i++);
        }
    }
}
class Consumer implements Runnable {
    Q q;
    
    public Consumer(Q q) {
        this.q = q;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while(true) {
            q.get();
        }
    }
}