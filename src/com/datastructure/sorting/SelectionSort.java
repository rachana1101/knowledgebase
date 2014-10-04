package com.datastructure.sorting;

public class SelectionSort {
	public static void main(String argv[]) {
		Integer[] list = new Integer[]{12,35,45,111,4,7,3,89};
		
		for(int i=0;i<list.length;i++) {
			int min = list[i];
			int position = i;
			for(int j=i; j<list.length;j++) {
				if(list[j] < min) {
					min = list[j];
					position = j;
				}
			}
			Integer temp = list[position];
			list[position] = list[i];
			list[i] = temp;
			print(list);
		}
	}
	public static void print(Integer[] list){
		for(int i=0;i<list.length;i++) {
			System.out.print(list[i]+",");
		}
		System.out.println("");
	}
}
