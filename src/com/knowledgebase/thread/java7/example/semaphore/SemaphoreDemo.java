package com.knowledgebase.thread.java7.example.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    // creating a mutex semaphore only one thread at a time

    public static void main(String[] argv) {
        Semaphore sem = new Semaphore(1);
        SharedResource shared = new SharedResource();
        new Increment(sem, shared);
        new Decrement(sem, shared);
    }
}

class Increment implements Runnable {
    Semaphore sm1;
    SharedResource sharedResource;
    Thread th;

    public Increment(Semaphore sm1, SharedResource sharedResource) {
        super();
        this.sm1 = sm1;
        this.sharedResource = sharedResource;
        this.th = new Thread(this);
        this.th.start();
    }

    @Override
    public void run() {
        try {
            // acquire lock
            this.sm1.acquire();
            // see if it has permit
            System.out.println("After acquiring increment lock "
                    + sm1.availablePermits());
            // sleep to let the other thread trigger
            for (int i = 0; i < 5; i++) {
                this.sharedResource.count++;
                System.out.println(this.sharedResource.count);
            }
            Thread.sleep(1000);
            // release the lock
            this.sm1.release();
            System.out.println("After releasing increment lock "
                    + sm1.availablePermits());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Decrement implements Runnable {
    Semaphore sm1;
    SharedResource sharedResource;
    Thread th;

    public Decrement(Semaphore sm1, SharedResource sharedResource) {
        super();
        this.sm1 = sm1;
        this.sharedResource = sharedResource;
        this.th = new Thread(this);
        this.th.start();
    }

    @Override
    public void run() {
        try {
            // acquire lock
            this.sm1.acquire();
            // see if it has permit
            System.out.println("After acquiring decrement lock "
                    + sm1.availablePermits());
            // sleep to let the other thread trigger
            for (int i = 0; i < 5; i++) {
                this.sharedResource.count--;
                System.out.println(this.sharedResource.count);
            }
            Thread.sleep(1000);
            // release the lock
            this.sm1.release();
            System.out.println("After releasing decrement lock "
                    + sm1.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SharedResource {
    public static int count = 0;
}