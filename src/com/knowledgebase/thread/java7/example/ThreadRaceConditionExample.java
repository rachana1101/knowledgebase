package com.knowledgebase.thread.java7.example;

/**
 * This problem demostrates how to write the race condition 
 * problem to understanding the threads better and how 
 * you can fix this issue with Synchronization
 *
 * Here we have created CallMe object to show 
 * when the same object (resource) is been accessed by multiple 
 * thread what can go wrong 
 * 
 * Output 
 * [Two
 * [Three
 * [One
 * ]
 * ]
 * ]
 *
 * The fix of this issue is here 
 * @author rachana
 *
 */
public class ThreadRaceConditionExample {
    
    public static void main(String[] argv) {
        CallMeSync callMeSync = new CallMeSync();
        CallerSync caller1 = new CallerSync("One", callMeSync);
        CallerSync caller2 = new CallerSync("Two", callMeSync);
        CallerSync caller3 = new CallerSync("Three", callMeSync);
        try {
            caller1.thread.join();
            caller2.thread.join();
            caller3.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Caller implements Runnable {
    private String msg;
    public Thread thread;
    private CallMe callMe;

    public Caller(String msg, CallMe callMe) {
        this.msg = msg;
        this.thread = new Thread(this);
        this.thread.start();
        this.callMe = callMe;
    }

    @Override
    public void run() {
        this.callMe.call(this.msg);
    }
}

class CallMe {
     public void call(String msg) {
        System.out.println("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("]");
    }
}
