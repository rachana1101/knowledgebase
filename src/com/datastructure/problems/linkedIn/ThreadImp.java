package com.datastructure.problems.linkedIn;

public class ThreadImp {
	
public static void main(String argv[]) {
	myThread t = new myThread();
	
}
}


class myThread implements Runnable{
	Thread  t;
	public myThread() {
		System.out.println(">>>>>>");
		t = new Thread(this);
		t.start();
	}
	public void run() {
		System.out.println("hello ");
	}
}