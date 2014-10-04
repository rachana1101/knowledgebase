package com.knowledgebase.interview.question.implementation;

/**
 * 
 * @author rachana
 *
 */
public class OddManOut {
    public static void main(String argv[]) {
        int[] list = new int[]{1,1,2,3,3,4,4,5,5,6,6,7,7};
        int val = 0;
        for(int i=0; i<list.length; i++) {
            val ^=list[i];
            System.out.println(val);
        }
        System.out.println(val);
    }
}
