package com.knowledgebase.thread.java7.example.Executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/**
 * <p>
 * This simple program demostrates how to use ExecutorService 
 * and TimeoutException is thrown if when sum expected execution 
 * time is 10 milliseconds but we have sleept the thread in 
 * the {@link Sum#call()}
 * </p>
 * <p> 
 * Executor helps to run task independent of each other simultaneously 
 * without the use of Threads 
 * </p> 
 * @author rachana
 *
 */
public class CallableTimeUnitExample {
    public static void main(String[] argv) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> sum = service.submit(new SumImpl(5,10));
        Future<Integer> sub = service.submit(new SubstractImpl(10,7));
        Future<Integer> mul = service.submit(new MultipleImpl(10,7));
        try {
            System.out.println("******** starting ******");
            System.out.println(sum.get(10, TimeUnit.MILLISECONDS).toString());
            System.out.println(sub.get().toString());
            System.out.println(mul.get().toString());
            System.out.println("******** ending ******");
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}

class SumImpl implements Callable<Integer> {
    private int val1;
    private int val2;
    
    public SumImpl(int val1, int val2) {
        super();
        this.val1 = val1;
        this.val2 = val2;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(100);
        return this.val1 + this.val2;
    }

}

class SubstractImpl implements Callable<Integer> {
    private int val1;
    private int val2;
    
    public SubstractImpl(int val1, int val2) {
        super();
        this.val1 = val1;
        this.val2 = val2;
    }

    @Override
    public Integer call() throws Exception {
        return val1-val2;
    }
}

class MultipleImpl implements Callable<Integer> {
    private int val1;
    private int val2;

    public MultipleImpl(int val1, int val2) {
        super();
        this.val1 = val1;
        this.val2 = val2;
    }
    @Override
    public Integer call() throws Exception {
        return val1*val2;
    }
    
}