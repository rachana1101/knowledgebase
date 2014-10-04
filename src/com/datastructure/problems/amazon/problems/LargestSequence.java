package com.datastructure.problems.amazon.problems;

import java.util.ArrayList;
import java.util.TreeMap;

public class LargestSequence {
	public static void main(String[] argv) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(0);
		list.add(4);
		list.add(7);
		list.add(6);
		list.add(12);
		list.add(13);
		list.add(14);
		list.add(1);
		
		int ctr =0;
		ArrayList<Integer> largest = new ArrayList<Integer>();
		TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<Integer,ArrayList<Integer>>();
		for(int i=0;i<list.size()-1;i++) {
			if(list.get(i) < list.get(i+1)) {
				largest.add(list.get(i));
				ctr++;
			} else {
				map.put(ctr, largest);
				largest = new ArrayList<Integer>();
			}
 		}
		System.out.println(map);
		System.out.println(map.lastEntry());
	}
	
}
