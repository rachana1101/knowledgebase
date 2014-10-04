package com.datastructure.problems.amazon.problems;

public class FindFactorialWithoutLoop {
	
	public static void main(String argv[]) {
		int i = 10;
		System.out.println(sub(i));
	}
	
	public static int sub(int i) {
		if(i<1) {
			return 1;
		} else {
			return i*sub(i-1);
		}
	}

}
