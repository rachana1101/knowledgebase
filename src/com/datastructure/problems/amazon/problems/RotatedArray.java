package com.datastructure.problems.amazon.problems;

import java.util.ArrayList;
import java.util.List;

public class RotatedArray {
	
	public static void main (String argv[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		List<Integer> firstHalf = list.subList(0, list.size()/2);
		List<Integer> lastHalf = list.subList(list.size()/2, list.size());
		boolean found = false;
		for(int i=0;i<firstHalf.size()-1;i++) {
			Integer temp = firstHalf.get(i);
			if(temp>firstHalf.get(i+1)) {
				System.out.println("found it");
				found = true;
			}
		}
		
		if(!found) {
			for(int i=0;i<lastHalf.size()-1;i++) {
				Integer temp = lastHalf.get(i);
				if(temp>lastHalf.get(i+1)) {
					System.out.println("found it");
					found = true;
				}
			}
		}
	}

}
