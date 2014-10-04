package com.datastructure.problems.amazon.problems;


/**
 * @author rachana
 * Given an array of ints, is it possible to divide the ints into two groups, so that the sums of the two groups are the same. 
 * Every int must be in one group or the other. Write a recursive helper method that takes whatever arguments you like, 
 * and make the initial call to your recursive helper from splitArray(). (No loops needed.)
 * splitArray({2, 2}) true
 * splitArray({2, 3})  false
 * splitArray({5, 2, 3})  true
 *
 */
public class FindSumInSubSet {
	
	public static void main(String argv[]) {
		//Integer[] ints = new Integer[] {5,2,4,0};
		Integer[] ints = new Integer[] {6,3,3};
		mergeSort(ints, 0, ints.length-1,0);
		
	}
	
	public static Integer sum(Integer[] sumList, int start, int end) {
		int sum =0;
		for(int i=start; i<=end;i++) {
			sum +=sumList[i];
		}
		return sum;
	}
	
	public static void mergeSort(Integer[] list, int start, int end, int ind) {
		if(ind ==end) {
			return;
		} else {
			int leftsum = sum(list,start,ind);
			int rightsum = sum(list,ind+1,end);
			System.out.println(" leftsum "+leftsum); 
			System.out.println(" rightsum "+rightsum); 
			if(leftsum != rightsum) {
				mergeSort(list,start, end, ind+1);
			} else {
				
				System.out.println(" found ");
				return;
			}
		}
	}

}
