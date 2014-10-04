package com.knowledgebase.interview.question.implementation;

import java.util.Arrays;

/**
 * Given an array of numbers, return array of products of all other numbers (no
 * division)
 * 
 * 
 * Given an array of numbers, nums, return an array of numbers products, where
 * products[i] is the product of all nums[j], j != i.
 * 
 * Input : [1, 2, 3, 4, 5] Output: [(2*3*4*5), (1*3*4*5), (1*2*4*5), (1*2*3*5),
 * (1*2*3*4)] = [120, 60, 40, 30, 24]
 * 
 * You must do this in O(N) without using division.
 * 
 * reference :
 * http://stackoverflow.com/questions/2680548/given-an-array-of-numbers
 * -return-array-of-products-of-all-other-numbers-no-div
 * 
 * @author rachana
 * 
 */
public class ProductOfAllOtherNumbers {
    static int[] products(int... nums) {
        final int N = nums.length;
        int[] prods = new int[N];
        int[] finalResults = new int[N];
        Arrays.fill(prods, 1);
       
        //Simple approach
        int p = 1;
        for(int i =0;i< N; i++) {
            prods[i] *= p;
            p *= nums[i]; 
            //System.out.println(p); //1, 2, 6, 24, 120
        }
        System.out.println(Arrays.toString(prods)); //[1, 1, 2, 6, 24]
        
        int[] prod1s = new int[N];
        Arrays.fill(prod1s, 1);
        p = 1;
        for(int i=N-1;i>=0; i--) {
            prod1s[i] *= p;
            p *= nums[i]; 
            //System.out.println(p); //5 ,20, 60, 120, 120
        }
        System.out.println(Arrays.toString(prod1s)); //[120, 60, 20, 5, 1]
        
        // now combine both, prints [120, 60, 40, 30, 24]
        for(int k=0; k < N; k++) {
            finalResults[k] = prods[k] * prod1s[k];
        }
        
        return finalResults;
    }

    public static void main(String[] args) {
       // System.out.println(Arrays.toString(products(1, 2, 3, 4, 5))); // prints
                                                                      // "[120, 60, 40, 30, 24]"
        
        System.out.println(Arrays.toString(products(1, 2, 3, 0, 5))); // prints
    }
}
