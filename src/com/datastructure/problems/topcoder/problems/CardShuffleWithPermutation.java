package com.datastructure.problems.topcoder.problems;

/*
 * card shutffling can be achieved used permutation
 */
public class CardShuffleWithPermutation {

	public static void main(String argv[]) {
		int noOfDigits = 4;
		int[] cards = new int[noOfDigits];
		for (int i = 0; i < noOfDigits; i++) {
			System.out.println(i);
			cards[i] = i + 1;
		}
		System.out.println(findFactorial(cards));
		findPermutations(cards);
	}

	public static int findFactorial(int[] list) {
		int length = list.length;
		int j = 1;
		for (int i = length; i > 0; i--) {
			j = j * i;
		}
		return j;
	}

	// {1,2,3}, {1,3,2}, {2,3,1}, {2,1,3}, {3,1,2} {3,2,1}
	public static void findPermutations(int[] list) {
		// String temp = "";
		for (int i = 0; i < list.length; i++) {
			String temp = "" + list[i];
			for (int j = 0; j < list.length; j++) {
				if (i != j) {
					temp += list[j];
				}
			}
			System.out.println(temp + "\n");
		}
		for (int i = 0; i < list.length; i++) {
			String temp = "" + list[i];
			for (int j = list.length-1; j >= 0; j--) {
				if (i != j) {
					temp += list[j];
				}
			}
			System.out.println(temp + "\n");
		}
	}
	
	
}
