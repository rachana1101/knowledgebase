package com.knowledgebase.company.ebay;
/**
 * Leetcode: Jump Game.
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.
 * @author rachana
 *
 */
public class JumpGame {
    
    public static void main(String argv[]) {
        // usecases 
        //int[] values = new int[]{1,2,0,3,1,0};
        //int[] values = new int[]{1,1,1,1,1,1};
        //int[] values = new int[]{1,1,1,1,1,0};
        //int[] values = new int[]{1,1,0,1,1,0};
        int[] values = new int[]{1,2,1,3,1,0};
        if(canJump(values)) {
            System.out.println(" Can jump");
        } else {
            System.out.println(" CANNOT jump");
        }
    }
    
    private static boolean canJump(int[] values) {
      
        //now check
        for(int i=0;i<values.length-1;) {
            if(values[i]>0) {
                i = i+values[i];
            } else if(i < values.length-2 && values[i]==0) {
                return false;
            }
            if(i>=values.length-1) {
                return true;
            }
        }
        return false;
    }
}
