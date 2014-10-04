package com.datastructure.sorting;
/**
 * insertion sort means placing the smallest element in their right position
 * @author rachana
 *
 */
public class InsertionSort {
	public static void main(String argv[]) {
		Integer[] list = new Integer[]{12,35,45,111,4,7,3,89};
		for(int i=1;i<list.length;i++) {
			int j = i;
			for(;j>0;j--) {
				if(list[j-1] > list[j]) {
					Integer temp = list[j-1];
					list[j-1] = list[j];
					list[j] = temp;
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
