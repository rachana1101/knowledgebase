package com.datastructure.thread.blockingqueue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<E> {

	static class Node<E> {
		E item;
		Node<E> next;

		Node(E x) {
			item = x;
		}
	}

	private final AtomicInteger count = new AtomicInteger(0);
	private final int capacity = 2;

	private transient Node<E> head;

	private transient Node<E> end;

	private final ReentrantLock takeLock = new ReentrantLock();

	private final Condition notEmpty = takeLock.newCondition();

	private final ReentrantLock putLock = new ReentrantLock();

	private final Condition notFull = putLock.newCondition();

	public BlockingQueue() {
		end = head = new Node<E>(null);
	}

	public boolean offer(E e) {
		if (e == null)
			throw new NullPointerException();
		final AtomicInteger count = this.count;
		if (count.get() == capacity)
			return false;
		int c = -1;
		Node<E> node = new Node(e);
		final ReentrantLock putLock = this.putLock;
		putLock.lock();
		try {
			if (count.get() < capacity) {
				enqueue(node);
				c = count.getAndIncrement();
				if (c + 1 < capacity)
					notFull.signal();
			}
		} finally {
			putLock.unlock();
		}
		// after the empty queue, when first element is inserted
		// we want to signal the take that it is good to take the element
		if (c == 0)
			signalNotEmpty();
		return c >= 0;
	}

	private void enqueue(Node<E> e) {
		end = end.next = e;
	}

	public E take() throws InterruptedException {
		E x;
		int c = -1;
		final AtomicInteger count = this.count;
		final ReentrantLock takeLock = this.takeLock;
		takeLock.lockInterruptibly();
		try {
			while (count.get() == 0) {
				notEmpty.await();
			}
			x = dequeue();
			c = count.getAndDecrement();
			if (c > 1)
				notEmpty.signal();
		} finally {
			takeLock.unlock();
		}
		if (c == capacity)
			signalNotFull();
		return x;
	}

	private E dequeue() {
		Node<E> h = head;
		Node<E> first = h.next;
		h.next = h; // help GC
		head = first;
		E x = first.item;
		first.item = null;
		return x;
	}

	private void signalNotEmpty() {
		final ReentrantLock takeLock = this.takeLock;
		takeLock.lock();
		try {
			notEmpty.signal();
		} finally {
			takeLock.unlock();
		}
	}

	private void signalNotFull() {
		final ReentrantLock putLock = this.putLock;
		putLock.lock();
		try {
			notFull.signal();
		} finally {
			putLock.unlock();
		}
	}

	public static void main(String argv[]) {
		try {
			BlockingQueue<String> q = new BlockingQueue<String>();
			System.out.println(q.take());
			q.offer("1");
			q.offer("2");
			q.offer("3");
			System.out.println(q.take());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
