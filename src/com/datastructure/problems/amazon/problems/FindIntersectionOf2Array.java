package com.datastructure.problems.amazon.problems;


public class FindIntersectionOf2Array {
	
	public static void main(String argv[]) {
		Integer[] listA = new Integer[]{10,2,4,6,7,3,1};
		Integer[] listB = new Integer[]{3,1,30,20,5,9,67};
		
		
		listA = sort(listA);
		listB = sort(listB);
		Integer[] result = findIntersectionOfArray(listA, listB);
		for(int i=0;i<result.length;i++) {
		System.out.println(result[i]);
	}
	}
	
	static Integer[] findIntersectionOfArray(Integer[] listA, Integer[] listB) {
		int i=0,j=0,z=0;
		Integer[] temp = new Integer[listA.length+listB.length];
		while(i<listA.length && j<listB.length) {
			if(listA[i] < listB[j]) {
				i++;
			} 
			else if(listB[j] < listA[i]) {
				j++;
			} 
			else {
				System.out.println(listA[i]);
				temp[z++] = listA[i];
				i++; j++;
			}
			
		}
		return temp;
	}

	static Integer[] sort(Integer[] list) {
		for(int i=1;i<list.length;i++) {
			for(int j=0;j<list.length;j++) {
				if(list[j]>list[i]) {
					Integer temp = list[j];
					list[j] = list[i];
					list[i] = temp;
				}
			}
			
		}
		return list;
	}

}
