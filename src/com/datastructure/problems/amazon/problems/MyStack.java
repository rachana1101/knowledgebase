package com.datastructure.problems.amazon.problems;

import java.util.Arrays;
import java.util.LinkedList;
public class MyStack {
	public static void main(String argv[]) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(10);
		stack.push(5);
		
		
		System.out.println(stack.max);
		System.out.println(stack.min);
		System.out.println(stack.maxMap);
		System.out.println(stack.minMap);
		
		stack.push(11);
		System.out.println(stack.max);
		System.out.println("pop >>"+stack.pop());
		System.out.println("pop >>"+stack.pop());
		System.out.println(stack.max);
	}
}

class Stack {
	private int size = 0;
	private int pointer =6;
	private static final int DEFAULT_CAPACITY = 10;
	private Object elements[];
	LinkedList<Integer> maxMap = new LinkedList<Integer>();
	LinkedList<Integer> minMap = new LinkedList<Integer>();
	
	int max = 0;
	int min = 0;

	public Stack() {
		elements = new Object[DEFAULT_CAPACITY];
	}

	public void push(int e) {
		if (size == elements.length) {
			ensureCapa();
		}
		if(e>max) {
			maxMap.add(e);
			max=e;
		}
		if(min==0) {
			min = e;
			minMap.add(e);
		}
		if(e<min) {
			minMap.add(e);
			min=e;
		}
		elements[size++] = e;
	}

	public Integer pop() {
		System.out.println("size "+size);
		//Integer e = (Integer) elements[--size];
		Integer e = (Integer) elements[--pointer];
		if(e==max) {
			maxMap.remove(e);
			max = maxMap.getFirst();
		}
		if(e==min) {
			minMap.remove(e);
			min = minMap.getFirst();
		}
		elements[size] = null;
		return e;
	}

	private void ensureCapa() {
		Integer newSize = elements.length * 2;
		elements = Arrays.copyOf(elements, newSize);
	}
}