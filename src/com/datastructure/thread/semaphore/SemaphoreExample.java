package com.datastructure.thread.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
	
	public static void main(String argv[]) {
		Semaphore sem = new Semaphore(1);
		MyIncThread thread1 = new MyIncThread(sem, "first");
		MyIncThread thread2 = new MyIncThread(sem, "second");
	}
}

class MyIncThread implements Runnable {
	
	Semaphore localSem = null;
	String name = null;
	
	public MyIncThread(Semaphore e, String name) {
		this.localSem = e;
		this.name = name;
		new Thread(this).start();
	}

	public void run() {
		try {
			this.localSem.acquire();
			for(int i = 0;i< 5;i++) {
				System.out.println(name + " " + Shared.count++);
				Thread.sleep(10);
			}
			this.localSem.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyDecThread implements Runnable {
	
	Semaphore localSem = null;
	String name = null;
	
	public MyDecThread(Semaphore e, String name) {
		this.localSem = e;
		this.name = name;
		new Thread(this).start();
	}

	public void run() {
		try {
			this.localSem.acquire();
			for(int i = 0;i< 5;i++) {
				System.out.println(name + " " + Shared.count--);
				Thread.sleep(10);
			}
			this.localSem.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Shared {
	static int count =0;
}