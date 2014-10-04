package com.datastructure.problems.amazon.problems;

import java.util.ArrayList;

/*
 * In given array of elements like [a1,a2,a3,..an,b1,b2,b3,..bn,c1,c2,c3,...cn] Write a program to merge them like [a1,b1,c1,a2,b2,c2,...an,bn,cn].

PS: Do it without using extra memory

Sample Testcases:

Input #00:

{1,2,3,4,5,6,7,8,9,10,11,12}

Output #00:

{1,5,9,2,6,10,3,7,11,4,8,12}

Explanation:

Here as you can notice, the array is of the form
{a1,a2,a3,a4,b1,b2,b3,b4,c1,c2,c3,c4}
 */
public class InPlaceMerging {
	public static void main(String argv[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(13);
		
		int length = list.size();
		Integer trigger = 4;
		for(int i=trigger;i>0;i--) {
			int z =0;
			while(z<length) {
				for(;z<trigger && z<length;z++) {
				}
				trigger += trigger;
				list.add(list.get(z));
			}	
		}
		
		System.out.println(list);
	}
}
