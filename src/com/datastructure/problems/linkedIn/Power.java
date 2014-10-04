package com.datastructure.problems.linkedIn;

import java.util.Scanner;

/*
 * find the power of 
 */
public class Power {

	public static void main(String[] argc) {
		int digit;
		int power;
		Scanner in = new Scanner(System.in);
		digit = in.nextInt();
		power = in.nextInt();
		System.out.println(findP(digit,power-1));
		in.close();
	}
	public static int findPower(int digit,int power) {
		int answer = digit << power;
		return answer;
	}
	
	public static int findP(int digit, int power) {
		for(int i=0;i<power;i++) {
			digit &= digit * i;
		}
		return digit;
	}
}
