package com.knowledgebase.thread.java7.example.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * <p>
 * This class demonstrates simple use of {@link CountDownLatch}
 * </p>
 * <ul>
 * <li>if for loop = 20 but latchcount = 5, it will still print 0-19</li>
 * <li>if for loop = 20 but latchcount = 50, it will go in infinite loop as
 * latch count has not become zero</li>
 * <li>if for loop = 20 but latch count = 20, it will still print 0-19</li>
 * </ul>
 * <p>
 * you might not necessarily require "await" to pause the main thread.
 * </p>
 * 
 * @author rachana
 * 
 */
public class CountDownLatchDemo {

    public static void main(String[] argv) {
        CountDownLatch countDown = new CountDownLatch(5);
        // acquire a lock
        new MyThread(countDown);

        // lets make the main thread to wait
        // till all the events are done
        try {
            countDown.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread implements Runnable {

    private CountDownLatch latch;
    private Thread th;

    public MyThread(CountDownLatch latch) {
        super();
        this.latch = latch;
        th = new Thread(this);
        th.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.latch.countDown();
        }
    }
}
