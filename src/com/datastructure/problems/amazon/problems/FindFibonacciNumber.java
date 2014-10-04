package com.datastructure.problems.amazon.problems;

import java.util.ArrayList;
/**
 * Fibonacci numbers : [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89]
 * @author rachana
 *
 */
public class FindFibonacciNumber {
	public static void main(String argv[]) {
		Integer first = 0;
		Integer second = 1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(first);
		list.add(second);
		for(int i=1;i<=10;i++) {
			Integer number =(Integer) list.get(list.size()-1) +(Integer) list.get(list.size()-2);
			list.add(number);
		}
		System.out.println(list);
	}
}
