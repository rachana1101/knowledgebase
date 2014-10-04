package com.datastructure.problems.linkedIn;

public class FindNumber {
	
	public static void main(String argv[]) {
		String st = "1234a";
		char[] chr = st.toCharArray();
		boolean isNumber = true;
		for(int i=0;i<chr.length;i++) {
			if(chr[i] >=48 && chr[i] <=57) {
				System.out.println(" number ");
			} else {
				isNumber = false;
				System.out.println(" not a number");
			}
		}
		if(isNumber) {
			System.out.println("is a number");
		}
	}
}
