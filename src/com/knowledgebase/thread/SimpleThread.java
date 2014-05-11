package com.knowledgebase.thread;
/**
 * This class demonstrates how to use simple thread
 * using {@link Runnable} interface.
 * 
 * @author rachana
 *
 */
public class SimpleThread implements Runnable {

    @Override
    public void run() {
        System.out.println("running");
    }

    public static void main(String[] argv) {
        Thread thread = new Thread(new SimpleThread());
        thread.start();
    }
}
