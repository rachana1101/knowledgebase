package com.datastructure.thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
	
	public static void main(String argv[]) throws InterruptedException {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new BarrierReach());
		MyThread cyclic1 = new MyThread(cyclicBarrier, "1");
		MyThread cyclic2 = new MyThread(cyclicBarrier, "2");
		MyThread cyclic3 = new MyThread(cyclicBarrier, "3");
		Thread.sleep(100);
		if(cyclicBarrier.getNumberWaiting()==0) {
		cyclicBarrier.reset();
		}
		/*MyThread cyclic4 = new MyThread(cyclicBarrier, "a");
		MyThread cyclic5 = new MyThread(cyclicBarrier, "b");
		MyThread cyclic6 = new MyThread(cyclicBarrier, "c");*/
	}

}
class BarrierReach implements Runnable{
	public void run() {
		System.out.println(" Barrier reached");
	}

}
class MyThread implements Runnable {
	CyclicBarrier cyclicBarrier = null;
	String name = null;
	public MyThread(CyclicBarrier cdl1, String name) {
		this.cyclicBarrier = cdl1;
		this.name = name;
		new Thread(this).start();
	}

	public void run() {
			try {
				System.out.println(" Thread nae "+this.name);
				this.cyclicBarrier.await();
				System.out.println(" crossed the barrier "+this.name);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
	}
	
}
