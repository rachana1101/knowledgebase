package com.datastructure.sorting;
/*
 * in dutchflagsort 
 * we move from last to center and front to center
 * moving elements in to their place
 */
public class DutchFlagSort {
	
	public static void main(String argv[]) {
		Integer[] list = new Integer[]{1,3,2,3,2,3,2,1,1};
		int low = 1;
		int high = 3;
		int low_p = 0;
		int high_p= list.length-1;
		print(list);
		for(int i=0;i<high_p;) {
			if(list[i]<=low) {
				swap(list, i, low_p);
				print(list);
				low_p++;
				i++;
				System.out.println("i "+i+" low_p"+low_p+" high_p "+high_p);
			} else if(list[i]>=high) {
				swap(list,i,high_p);
				print(list);
				high_p--;
				System.out.println("i "+i+" low_p"+low_p+" high_p "+high_p);
			} else {
				i++;
				System.out.println("i "+i+" low_p"+low_p+" high_p "+high_p);
			}
			print(list);	
		}
		
		
	}
	
	public static void swap(Integer[] arr, int i, int j){
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
	public static void print(Integer[] list){
		for(int i=0;i<list.length;i++) {
			System.out.print(list[i]+",");
		}
		System.out.println("");
	}
}
