package com.datastructure.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * This class shows how multiple thread can start togher
 * 
 * @author rachana
 * 
 */
public class MultipleThreadStartTogether {
	public static void main(String argv[]) throws InterruptedException {
		CountDownLatch startLatch = new CountDownLatch(1);
		CountDownLatch endLatch = new CountDownLatch(4);
		for(int i=0;i<4;i++) {
			Thread th = new LatchedThread(startLatch, endLatch);
			th.start();
		}
		Thread.sleep(200);
		System.out.println(" before count down ");
		startLatch.countDown();
		System.out.println(" after count down ");
		endLatch.await();
	}
}

class LatchedThread extends Thread {
	private final CountDownLatch startLatch;
	private final CountDownLatch endLatch;

	public LatchedThread(CountDownLatch startLatch, CountDownLatch endLatch) {
		this.startLatch = startLatch;
		this.endLatch = endLatch;
	}

	public void run() {
		System.out.println(" run started ");
		try {
			System.out.println(" start await ");
			startLatch.await();
			System.out.println(" end await ");
		} catch (InterruptedException iex) {
		} finally {
			endLatch.countDown();
		}
	}
}