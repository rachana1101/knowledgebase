package com.datastructure.problems.amazon.problems;
import java.util.ArrayList;
public class RGBSorting {
	public static void main(String argc[]) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("R");
		list.add("G");
		list.add("B");
		list.add("B");
		list.add("G");
		list.add("R");
		list.add("R");
		list.add("G");
		for(int i =1;i<list.size();i++) {
			if(list.get(i).charAt(0) < list.get(i-1).charAt(0)) {
				String temp = list.get(i);
				list.set(i, list.get(i-1));
				list.set(i-1, temp);
			}
		}
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}
