package com.knowledgebase.thread.java7.example.Executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * <p>
 * This simple program demostrates how the ExecutorService 
 * can execute the task and returns the result in form 
 * of {@link Future}.
 * </p>
 * <p> 
 * Executor helps to run task independent of each other simultaneously 
 * without the use of Threads 
 * </p> 
 * @author rachana
 *
 */
public class CallableExample {
    public static void main(String[] argv) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> sum = service.submit(new Sum(5,10));
        Future<Integer> sub = service.submit(new Substract(10,7));
        Future<Integer> mul = service.submit(new Multiple(10,7));
        try {
            System.out.println("******** starting ******");
            System.out.println(sum.get().toString());
            System.out.println(sub.get().toString());
            System.out.println(mul.get().toString());
            System.out.println("******** ending ******");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}

class Sum implements Callable<Integer> {
    private int val1;
    private int val2;
    
    public Sum(int val1, int val2) {
        super();
        this.val1 = val1;
        this.val2 = val2;
    }

    @Override
    public Integer call() throws Exception {
        
        return this.val1 + this.val2;
    }

}

class Substract implements Callable<Integer> {
    private int val1;
    private int val2;
    
    public Substract(int val1, int val2) {
        super();
        this.val1 = val1;
        this.val2 = val2;
    }

    @Override
    public Integer call() throws Exception {
        return val1-val2;
    }
}

class Multiple implements Callable<Integer> {
    private int val1;
    private int val2;

    public Multiple(int val1, int val2) {
        super();
        this.val1 = val1;
        this.val2 = val2;
    }
    @Override
    public Integer call() throws Exception {
        return val1*val2;
    }
    
}