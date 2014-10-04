package com.datastructure.problems.amazon.problems;

import java.util.HashMap;
import java.util.TreeMap;

/*
 * amazon-interview-questions 15 Answers
 *
 * I have given a Long Sentence and some words(to be searched in the sentence),
 * i have to find the smallest part of the sentence which contains all the words to be Searched in that
 *  Sentence and print that part.
 */
public class SearchWordsInBigSentence {
	
	public static void main(String argv[]) {
		String sentence = "hello rat xxxxx mat zzzzzzz cat. How are you doing rat, and how abt out mat. where is cat. I like you all rat, mat and cat.";
		String[] words = new String[] {"rat","mat","cat"};
		TreeMap<Integer, Integer> treeMap = new TreeMap<Integer,Integer>();
		int lastIndex = 0;
		for(int j=0;j<3;j++) {
			int indexA = sentence.indexOf("rat",lastIndex);
			int indexB = sentence.indexOf("cat",lastIndex);
			System.out.println(sentence.indexOf("rat",lastIndex));
			System.out.println(sentence.indexOf("cat",lastIndex));
			lastIndex = sentence.indexOf("cat",lastIndex)+1;
			System.out.println(lastIndex);
			treeMap.put(j, indexB-indexA);
		}
		
		System.out.println(treeMap);
	}
	

}
