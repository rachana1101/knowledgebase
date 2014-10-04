package com.datastructure.sorting;

/**
 * 
 * quick sort is better than merge as it doesnot uses extra memory
 * @author rachana
 * 
 * 
 *
 */
public class QuickSort {
	static Integer[] list = new Integer[] { 12, 5, 45, 111, 4, 7, 3, 89,31,90,1,9 ,10};
	static Integer[] sorted = new Integer[list.length];

	public static void main(String argv[]) {
		int pivot = 0;
		for(int i=0;i<list.length-1;i++) {
			if (list.length % 2 == 0) {
				System.out.println("even");
				pivot = list[((list.length / 2) + 1) - 1];
			} else {
				System.out.println("odd");
				pivot = list[((list.length + 1) / 2) - 1];
			}
			System.out.println("pivot >>>"+pivot);
			sort(pivot, list.length / 2, list.length);
			
		}
	}

	public static void sort(int pivot, int mid, int length) {
		int leftend = 0;
		int rightend = length - 1;
		while (leftend < rightend) {
			while (list[leftend] < pivot) {
				leftend++;
			}
			while (list[rightend] > pivot) {
				rightend--;
			}
			if (list[leftend] >= pivot && list[rightend] <= pivot) {
				int temp = list[rightend];
				list[rightend] = list[leftend];
				list[leftend] = temp;
			}
			print(list);
		}
	}

	public static void print(Integer[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + ",");
		}
		System.out.println("");
	}
	/**
	 * odd
pivot >>>3
1,5,45,111,4,7,3,89,31,90,12,9,10,
1,3,45,111,4,7,5,89,31,90,12,9,10,
1,3,45,111,4,7,5,89,31,90,12,9,10,
odd
pivot >>>5
1,3,5,111,4,7,45,89,31,90,12,9,10,
1,3,4,111,5,7,45,89,31,90,12,9,10,
1,3,4,5,111,7,45,89,31,90,12,9,10,
1,3,4,5,111,7,45,89,31,90,12,9,10,
odd
pivot >>>45
1,3,4,5,10,7,45,89,31,90,12,9,111,
1,3,4,5,10,7,9,89,31,90,12,45,111,
1,3,4,5,10,7,9,45,31,90,12,89,111,
1,3,4,5,10,7,9,12,31,90,45,89,111,
1,3,4,5,10,7,9,12,31,45,90,89,111,
1,3,4,5,10,7,9,12,31,45,90,89,111,
odd
pivot >>>9
1,3,4,5,9,7,10,12,31,45,90,89,111,
1,3,4,5,7,9,10,12,31,45,90,89,111,
1,3,4,5,7,9,10,12,31,45,90,89,111,
odd
pivot >>>10
1,3,4,5,7,9,10,12,31,45,90,89,111,
odd
pivot >>>10
1,3,4,5,7,9,10,12,31,45,90,89,111,
odd
pivot >>>10
1,3,4,5,7,9,10,12,31,45,90,89,111,
odd
pivot >>>10
1,3,4,5,7,9,10,12,31,45,90,89,111,
odd
pivot >>>10
1,3,4,5,7,9,10,12,31,45,90,89,111,
odd
pivot >>>10
1,3,4,5,7,9,10,12,31,45,90,89,111,
odd
pivot >>>10
1,3,4,5,7,9,10,12,31,45,90,89,111,
odd
pivot >>>10
1,3,4,5,7,9,10,12,31,45,90,89,111,

	 */
}
