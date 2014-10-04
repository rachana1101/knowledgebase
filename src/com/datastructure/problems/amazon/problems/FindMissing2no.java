package com.datastructure.problems.amazon.problems;

public class FindMissing2no {
	public static void main(String argc[]) {
	Integer A[] = new Integer[]{1,2,3,5,6,8,9,10};
	Integer B[] = new Integer[]{1,2,3,4,5,6,7,8,9,10};
	int var = 0;
	int i=0, j=0;
	/*while(i<A.length && j<B.length) {
		if((var ^ B[j]) == 1) {
			System.out.println("B"+B[i]);
		} else {
			System.out.println(A[i]);
		}
		i++;j++; 
		//System.out.println(A[i] ^ B[j]);
		//j++; i++;
	}*/
	
	int result = 0 ;
	for(i=0;i<A.length;i++) {
		result^=A[i];
		if(j<B.length) {
			result^=B[j++];
			if(result==1) {
				System.out.println("1");
			}
		}
		
	}
	    System.out.println(result);                                              
	}
}
