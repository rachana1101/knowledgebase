package com.datastructure.problems.amazon.problems;

public class PrintNoWithoutLoop {
	
	public static void main(String argv[]) {
		int i = 5000;
		sub(i);
	}
	
	public static void sub(int i) {
		if(i<1) {
			return;
		} else {
			System.out.println(i);
			sub(i-1);
		}
	}
}
