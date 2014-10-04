package com.knowledgebase.company.locationlabs;

import java.util.Arrays;

public class TwoSum {
    public static void main(String... argc) {
        System.out.println(Arrays.toString(findPairInSequence(9,4,6,8,1,0,1)));
        System.out.println(Arrays.toString(findPairInSequence(10,4,6,8,1,0,1)));
        System.out.println(Arrays.toString(findPairInSequence(14,4,6,8,1,0,1)));
        System.out.println(Arrays.toString(findPairInSequence(12,4,6,8,1,0,1)));
        
        System.out.println(" Find two sum not necessary to be in sequence ");
        
        System.out.println(Arrays.toString(findPair(12,4,6,8,1,0,1)));
    }
    
    private static int[] findPairInSequence(int target, int... values) {
        int start = 0, end = 0 ;
        int[] result = new int[values.length];
        for(int i=0, j = 1;j <values.length && i<j ;i++, j++) {
            if(values[i] + values[j] == target) {
                start = i;
                end = j;
            }
        }
        for(int i= start, j= 0; i<=end; i++, j++) {
            result[j] = values[i];
        }
        return result;
    }

    private static int[] findPair(int target, int... values) {
        int start = 0, end = 0 ;
        int[] result = new int[values.length];
        for(int i=0; i<values.length;i++) {
            int shouldbe = target - values[i];
            for(int j=i+1;j<values.length;j++) {
                if(shouldbe == values[j]) {
                    start = i;
                    end = j;
                }
            }
        }
        result[0] = values[start];
        result[1] = values[end];
        return result;
    }

    
}
