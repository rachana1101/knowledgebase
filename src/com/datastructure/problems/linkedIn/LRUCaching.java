package com.datastructure.problems.linkedIn;

import java.util.LinkedList;

public class LRUCaching {
	public static void main(String argv[]) {
		LRU lru = new LRU();
		for(int i=0;i<15;i++) {
			lru.add(i);
		}
	}
}

class LRU {
	LinkedList<Integer> map =null;
	public LRU() {
		map = new LinkedList<Integer>();
	}
	public void add(Integer data) {
		if(map.size()<10) {
			System.out.println("adding "+data);
			map.add(data);
		} else {
			System.out.println("removing least used element");
			System.out.println(" remove last "+map.removeFirst());
		}
	}
}