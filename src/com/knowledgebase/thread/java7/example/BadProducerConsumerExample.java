package com.knowledgebase.thread.java7.example;
/**
 * This example demonstrated the classic problem  
 * {@link Producer} and {@link Consumer}, where methods 
 * of Q are synchronized which causes the Producer to wait 
 * till the Consumer is done with consumption and  
 * Consumer will wait till the producer has not produced any thing 
 * to consume 
 *  
 * @author rachana
 * 
 * Output : 
 * PUT VALUE 142834
 * PUT VALUE 142835
 * GOT VALUE 142835
 * GOT VALUE 142835
 * GOT VALUE 142835
 * GOT VALUE 142835
 * PUT VALUE 142836
 * PUT VALUE 142837
 * PUT VALUE 142838
 * PUT VALUE 142839
 * PUT VALUE 142840
 * PUT VALUE 142841
 * PUT VALUE 142842
 *
 */
public class BadProducerConsumerExample {
    
    public static void main(String[] argc) {
        BQ q = new BQ();
        new BProducer(q);
        new BConsumer(q);
    }
}

class BQ {
    private int n;
    synchronized public int get() {
        System.out.println( " GOT VALUE "+n);
        return n;
    }
    synchronized public int set(int n) {
        this.n = n;
        System.out.println(" PUT VALUE "+n);
        return this.n;
    }
}

class BProducer implements Runnable{
    BQ q; 
    
    public BProducer(BQ q) {
        this.q = q;
        new Thread(this).start();
    }

    @Override
    public void run() {
        int i = 0;
        while(true) {
             this.q.set(i++);
        }
    }
}
class BConsumer implements Runnable {
    BQ q;
    
    public BConsumer(BQ q) {
        this.q = q;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while(true) {
            q.get();
        }
    }
}