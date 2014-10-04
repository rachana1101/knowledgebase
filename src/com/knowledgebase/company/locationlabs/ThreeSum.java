package com.knowledgebase.company.locationlabs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * For example, given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 * 
 * @author rachana
 * 
 */
public class ThreeSum {
    public static void main(String... argc) {
        System.out.println(threeSumInSequence(0, -1, 0, 1, 2, -1, -4));
    }

    public static List<String> threeSumInSequence(int target, int... values) {
        List<String> results = new ArrayList<String>();
        for(int i =0;i < values.length-2;i++) {
            if(values[i] + values[i+1] + values[i+2] == target) {
                String temp = "("+ values[i] + " , " + values[i+1] + " , " + values[i+2] + ")";
                results.add(temp);
            }
        }
        return results;
    }
    
    
}
