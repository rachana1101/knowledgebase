package com.datastructure.problems.linkedIn;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * 
 Write a multithreaded blocking version of Bounded Queue.
 There are writers which fill up the queue, and then readers which empty the queue.
 If q is full, writer should block. If Q is empty readers should block.
 The Queue size is finite... (its bounded).
 Maximize parallelism, minimize resource usage etc...
 */
public class BlockingQueue {

	static Thread writers = new Thread();
	static Thread readers = new Thread();

	public static void main(String argv[]) {
		Scanner in = new Scanner(System.in);
		Q q = new Q();
		Add ad = new Add(q);
		Reader reader = new Reader(q);
		in.close();
	}
}

class Q {
	private LinkedList<Integer> list = new LinkedList<Integer>();
	public int get() {
		synchronized (this) {
		if (list.size() == 0) {
				try {
					System.out.println("Nothing to read from");
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		notify();
		}
		return list.getFirst();
	}
	public void put(int data) {
		synchronized (this) {
			if (list.size() == 3) {
				try {
					System.out.println("No more space to add");
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			} else {
				notify();
				list.add(data);
			}
		}
		list.add(data);
	}
}

class Add implements Runnable {
	
	Q q;
	Thread writer;

	public Add(Q q) {
		this.q = q;
		writer = new Thread(this);
		writer.start();
		System.out.println(" constructor ");
	}

	public void run() {
		int data = 0;
		while (true) {
			q.put(data++);
		}
	}
}

class Reader implements Runnable {
	Q q;
	Thread reader;

	public Reader(Q q) {
		this.q = q;
		reader = new Thread(this);
		reader.start();
		System.out.println(" constructor ");
	}

	public void run() {
		while (true) {
			System.out.println(" run ");
			System.out.println(q.get());
		}
	}
}
