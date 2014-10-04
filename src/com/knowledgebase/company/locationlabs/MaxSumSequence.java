package com.knowledgebase.company.locationlabs;

import java.util.Arrays;

/**
 * Find a sequence of the numbers in a series which gives the maximum Sum.
 * The sequence consists of the negative and positive numbers.
 * @author rachana
 */
public class MaxSumSequence {
    
    public static void main(String... argc) {
        System.out.println(Arrays.toString(findMaxSumSequence(-2, 1, -3, 4,-1,2,1,-5,4)));
        System.out.println(Arrays.toString(findMaxSumSequence(-4, -1, -2,-2,-5)));
        System.out.println(Arrays.toString(findMaxSumSequence(4, -1, 2,-2,-5)));
        System.out.println(Arrays.toString(findMaxSumSequence(-4, -7, 10,-2,5)));
        System.out.println(Arrays.toString(findMaxSumSequence(4, -1, 2,-2,5)));
    }
     
    private static int[] findMaxSumSequence(int... values) {
        int max = 0; int current = 0 ;
        int start = 0, end = 0 ;
        int[] result = new int[values.length];
        for(int i=0, j = 0;j<values.length;j++) {
            current += values[j];
            if(current > max && current > 0) {
                max = current;
                start = i;
                end = j;
            } else if (current < 0) {
                current = 0;
                i = j+1;
            }
        }
        for(int i= start, j= 0; i<=end; i++, j++) {
            result[j] = values[i];
        }
        System.out.println("max -> "+max);
        return result;
    }

}
