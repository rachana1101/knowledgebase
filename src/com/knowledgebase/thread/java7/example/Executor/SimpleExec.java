package com.knowledgebase.thread.java7.example.executor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleExec {

    public static void main(String[] argv) {
        // Creating the countdown latch
        CountDownLatch countDown1 = new CountDownLatch(5);
        CountDownLatch countDown2 = new CountDownLatch(5);
        CountDownLatch countDown3 = new CountDownLatch(5);
        CountDownLatch countDown4 = new CountDownLatch(5);
        // Executor to execute this countLatches
        ExecutorService executor = Executors.newFixedThreadPool(2);

        System.out.println(" Starting .... ");

        // Now create 5 threads to be executed using thread pool of 2 of
        // executor
        // Dont create the thread and add to execute because
        // thread.start is in MyThread so thread will start before the
        // assigning it to the pool
        executor.execute(new MyThread(countDown1, "A"));
        executor.execute(new MyThread(countDown2, "B"));
        executor.execute(new MyThread(countDown3, "C"));
        executor.execute(new MyThread(countDown4, "D"));

        try {
            countDown1.await();
            countDown2.await();
            countDown3.await();
            countDown4.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" Ending the execution ");

        executor.shutdown();

    }
}

class MyThread implements Runnable {
    CountDownLatch latch;
    String name;
    Thread th;

    public MyThread(CountDownLatch latch, String name) {
        super();
        this.latch = latch;
        th = new Thread(this, name);
        th.start();

    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(th.currentThread().getName() + ">>>>" + i);
            latch.countDown();
        }
    }

}