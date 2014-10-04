package com.datastructure.problems;

import java.util.ArrayList;

//sort all the character in the word, then compare each word in list.
public class AnagramIdentifier {
	public static void main(String argv[]) {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> newList = new  ArrayList<String>();
		list.add("catn");
		list.add("tanc");
		list.add("naty");
		
		//fist sort each character
		for(String data:list) {
			data = exchangeSort(data);
			newList.add(data);
		}
		String temp = newList.get(0);
		boolean flag = true;
		for(String d:newList) {
			if(!d.equals(temp)) {
				flag = false;
			}
		}
		if(flag) {
			System.out.println("Anagram");
		} else {
			System.out.println("not Anagram");
		}
		System.out.println(newList);
	}
	
	 static String exchangeSort(String data) {
		char[] strings = data.toCharArray();
		for(int i=0;i<strings.length; i++) {
			for(int j=1;j<strings.length;j++) {
				if(strings[i] < strings[j]) {
					char temp = strings[i];
					strings[i] = strings[j];
					strings[j] = temp;
				}
			}
		}
		return new String(strings);
	}

}
