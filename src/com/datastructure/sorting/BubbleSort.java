package com.datastructure.sorting;


public class BubbleSort {

	public static void main(String argv[]) {
		Integer[] list = new Integer[]{12,35,45,111,4,7,3,89};
		for(int i=1;i<list.length;i++) {
			for(int j=0;j<list.length;j++) {
				if(list[j]>list[i]) {
					Integer temp = list[j];
					list[j] = list[i];
					list[i] = temp;
				}
			}
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
