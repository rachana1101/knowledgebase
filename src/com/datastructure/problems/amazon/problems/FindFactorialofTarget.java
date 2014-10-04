package com.datastructure.problems.amazon.problems;
/*
 * Write a function that prints pairs for target sum
 */
public class FindFactorialofTarget {
	public static void main(String argv[]) {
		Integer[] list = new Integer[]{10,2,4,6,7,3,1};
		printPairs(list,6);
	}
	static void printPairs (Integer a[], int target) {
		for(int i=0;i<a.length;i++) {
			if(a[i]>target) {
				System.out.println("skip as it cannot be used");
			} else {
				int temp = target-a[i];
				for(int j = i;j<a.length;j++) {
					if(temp == a[j]) {
						System.out.println("{"+a[i]+","+a[j]+"}");
					}
				}
			}
		}
	}
}
