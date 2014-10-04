package com.datastructure.sorting;

public class MergeSort {
	public static void main(String argv[]) {
		Integer[] list = new Integer[]{12,11,45,36,4,3,89,22};
		Integer[] temp = new Integer[list.length];
		mergeSort(list,temp,0,list.length-1);
		print(list);
	}
	
	public static void mergeSort(Integer[] list, Integer[] temp, int start, int end) {
		if(start<end) {
			int mid = start+(end-start)/2;
			mergeSort(list,temp,start,mid);
			mergeSort(list,temp, mid+1,end);
			merge(list,temp,start,(start+end)/2,end);
			System.out.println("-------------------");
			print(list);
			System.out.println("-------------------");
		}
	}
	public static void merge(Integer[] list,Integer[] temp,int start, int mid, int end) {
		int i=start,j =mid+1, k =start;
		
		for(int z=start;z<=end;z++) {
			temp[z] = list[z];
		}
		System.out.println("********************");
		print(temp);
		System.out.println("********************");
		while(i<=mid && j<=end-1) {
			if(temp[i] <= temp[j]) {
				list[k] = temp[i];
				i++;k++;
			} else {
				list[k] = temp[j];
				j++;k++;
			}
		}
		while (i <= mid) {
			list[k] = temp[i];
			k++;
			i++;
		}
	}
	public static void print(Integer[] list){
		for(int i=0;i<list.length;i++) {
			System.out.print(list[i]+",");
		}
		System.out.println("");
	}

}
