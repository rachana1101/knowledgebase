package com.datastructure.problems.topcoder.problems;

import java.util.Random;

public class CardShuffleWithRandom {
	public static void main(String[] argc) {
		int noOfDigits = 4;
		int[] cards = new int[noOfDigits];
		for (int i = 0; i < noOfDigits; i++) {
			System.out.println(i);
			cards[i] = i + 1;
		}
		Random r = new Random();
		int[] shuffledList = new int[cards.length];
		for (int i = 0; i < cards.length; i++) {
			int randNo = r.nextInt(cards.length-1);
			shuffledList[i] = cards[randNo];
			System.out.println(shuffledList[i]);
		}
	}
}
