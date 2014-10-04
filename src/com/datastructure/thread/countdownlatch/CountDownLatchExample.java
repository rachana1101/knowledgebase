package com.datastructure.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;
/**
 * Another common scenario is with parallel processing, 
 * where we need to wait for several threads to finish or reach a particular point. 
 * In this case, we can use a similar mechanism: 
 * @author rachana
 *
 */
public class CountDownLatchExample {
	public static void main(String argv[]) {
		CountDownLatch cdl1 = new CountDownLatch(5);
		try {
			System.out.println(" before the counta lach waits ");
			for(int i=0;i<5;i++) {
				MyThread thread = new MyThread(cdl1);
			}
			cdl1.await();
			System.out.println(" Done");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

class MyThread implements Runnable {
	CountDownLatch localCdl = null;
	
	public MyThread(CountDownLatch cdl1) {
		this.localCdl = cdl1;
		new Thread(this).start();
	}

	public void run() {
			System.out.println(" thing  done");
			this.localCdl.countDown();
			System.out.println(" taking latch down for ");
	}
	
}