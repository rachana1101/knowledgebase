package com.datastructure.problems.amazon.problems;

public class ReverseString {
	
	public static void main(String argv[]) {
		String name = "rachana";
		byte[] str = name.getBytes();
		for(int i=0, j=name.length()-1; i<name.length()-1 && j>=0; i++,j--) {
			byte temp = str[i];
			str[i] = str[j];
			str[j] = temp;
		}
		System.out.println(new String(str));
	}

}
