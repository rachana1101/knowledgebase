package com.datastructure.problems;


public class ExchangeSort {
	
	static String string = "abcndgdca";
	
	public static void main(String argv[]) {
		char[] strings = string.toCharArray();
		for(int i=0;i<strings.length; i++) {
			for(int j=1;j<strings.length;j++) {
				if(strings[i] < strings[j]) {
					char temp = strings[i];
					strings[i] = strings[j];
					strings[j] = temp;
				}
			}
		}
		for(int i =0;i<strings.length;i++) {
			System.out.println(strings[i]);
		}
	}

}
