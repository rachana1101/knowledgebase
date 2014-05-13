package com.knowledgebase.thread.java7.example.semaphore;

import java.util.concurrent.Semaphore;

/**
 * This is the same example of Producer and Consumer
 * using {@link Semaphore}
 * 
 * Remember : to remove synchronized keyword
 * @author rachana
 *
 */
public class SemaphoreProducerConsumer {
    
   public static void main(String[] argv) {
       Q q = new Q();
       new Producer(q);
       new Consumer(q);
   }
}

class Q {
    private int n;
    Semaphore writeLock = new Semaphore(1);
    Semaphore readLock = new Semaphore(0);
    public int get() {
        try {
            readLock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( " GOT VALUE "+n);
        writeLock.release();
        return n;
    }
    public int set(int n) {
        try {
            writeLock.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.n = n;
        System.out.println(" PUT VALUE "+n);
        readLock.release();
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
        for(int i =0; i<20; i++) {
             this.q.set(i);
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
        for(int i =0; i<20; i++) {
            this.q.get();
       }
    }
}