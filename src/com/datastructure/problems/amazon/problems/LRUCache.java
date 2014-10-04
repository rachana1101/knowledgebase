package com.datastructure.problems.amazon.problems;

import java.util.LinkedList;
/*
 * 
 */
public class LRUCache {
	static LinkedList<Integer> list = new LinkedList<Integer>();
	public static void main(String argc[]) {
		for(int i =0;i<5;i++) {
			insert(i, i);
		}
		print();
		System.out.println(get(3));
		print();
		insert(1,6);
		print();
		System.out.println(get(3));
		print();
	}
	
	static void print(){
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+ " , ");
		}
	}
	static void insert(int index,int element) {
		if(list.size()>4) {
			System.out.println(" no more size left");
			System.out.println(list.removeLast());
		} else {
			list.add(index,element);
		}
	}
	static Integer get(int index) {
		int temp = list.get(index);
		insert(0, temp);
		return temp;
	}
}
