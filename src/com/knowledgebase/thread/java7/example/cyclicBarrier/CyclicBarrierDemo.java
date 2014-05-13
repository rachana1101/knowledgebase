package com.knowledgebase.thread.java7.example.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * <p>
 * This example demostrates that all threads have to reach {@link Barrier}.
 * </p>
 * <ul>
 * <li>if parties > noOfThreadsCreated : infinite loop, as all parties have not
 * reached the barrier</li>
 * <li>if parties < noOfThreadsCreated : infinite loop, last thread keeps in
 * await</li>
 * <li> if parties < noOfThreadsCreated = Sets(ofThread) : Barrier will be meet
 *  example : 
 *   new MyThread(barrier, "A");
 *   new MyThread(barrier, "B");
 *   new MyThread(barrier, "C");
 *   new MyThread(barrier, "X");
 *   new MyThread(barrier, "Y");
 *   new MyThread(barrier, "Z");
 *        
 *  Output : 
 *  ...... A
    ...... B
    ...... X
    Barrier Reached 
    ...... C
    ...... Y
    ...... Z
    Barrier Reached 
 * </ul>
 * 
 * @author rachana.
 * 
 * 
 */
public class CyclicBarrierDemo {

    public static void main(String[] argv) {
        CyclicBarrier barrier = new CyclicBarrier(3, new Barrier());

        new MyThread(barrier, "A");
        new MyThread(barrier, "B");
        new MyThread(barrier, "C");
        new MyThread(barrier, "X");
        new MyThread(barrier, "Y");
        new MyThread(barrier, "Z");
    }
}

class MyThread implements Runnable {
    CyclicBarrier barrier;
    String name;
    Thread th;

    public MyThread(CyclicBarrier barrier, String name) {
        super();
        this.barrier = barrier;
        th = new Thread(this);
        this.name = name;
        th.start();
    }

    @Override
    public void run() {
        System.out.println("...... " + this.name);
        try {
            this.barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class Barrier implements Runnable {
    @Override
    public void run() {
        System.out.println(" Barrier Reached ");
    }
}