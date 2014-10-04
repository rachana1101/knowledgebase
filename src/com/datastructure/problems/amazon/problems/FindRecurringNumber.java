package com.datastructure.problems.amazon.problems;

import java.util.ArrayList;

/*
 * Given Numerator and Denominator. After division you might get a recurring decimal points float as the answer. You need to identify the recurring part?
For example 23.34563456 ...
return 3456
 */
public class FindRecurringNumber {
	public static void main(String argv[]) {
		String number = "23,34563456345610";
		String[] arr = number.split(",");
		String afterDecimal = arr[1];
		ArrayList<String>  recurrsion = new ArrayList<String>();
		String first = afterDecimal.substring(0, 1);
		int nextPost = afterDecimal.indexOf(first,1);
		recurrsion.add(first);
		for(int i=1;i<afterDecimal.length();i++) {
			String next = afterDecimal.substring(i, i+1);
			int post = afterDecimal.indexOf(next,i+1);
			if(!recurrsion.contains(next)&& ((post-i) ==nextPost)) {
				recurrsion.add(next);
			}
		}
		System.out.println(recurrsion);
	}
}
