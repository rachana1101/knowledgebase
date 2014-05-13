package com.knowledgebase.thread.java7.example;
/**
 * This class demostrates how we can fix the race condition of 
 * {@link ThreadRaceConditionExample} by using synchronized keyword
 * 
 * What is happending here : Since we have made method synchronized 
 * only one thread can enter the method for the CallMeSync object. 
 * 
 * As object is having its own implicit monitor, thread has entered 
 * in the monitor and other threads have to wait to enter in that monitor
 * 
 * Precaution - because we want targeting only one object 
 * 
 * Do this 
 *      CallMeSync callMeSync = new CallMeSync();
 *      CallerSync caller1 = new CallerSync("One", callMeSync);
 *      CallerSync caller2 = new CallerSync("Two", callMeSync);
 *
 * Dont       
 *      CallMeSync callMeSync = new CallMeSync();
 *      CallerSync caller1 = new CallerSync("One", new CallMeSync());
 *      CallerSync caller2 = new CallerSync("Two", new CallMeSync());
 * @author rachana
 *
 */
public class SynchronizationExample {
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

class CallerSync implements Runnable {
    private String msg;
    public Thread thread;
    private CallMeSync callMe;

    public CallerSync(String msg, CallMeSync callMe) {
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

class CallMeSync {
    synchronized void call(String msg) {
        System.out.println("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("]");
    }
}
