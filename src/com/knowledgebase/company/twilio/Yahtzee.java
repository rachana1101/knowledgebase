package com.knowledgebase.company.twilio;

import java.util.Arrays;


public class Yahtzee {
    
    public static void main(String... argv) {
        Yahtzee yatzee = new Yahtzee();
        int[] data = { 
                1,1,5,5,1,5,2,2,4,10
            };

        System.out.println(yatzee.isWin(data));
    }
       
    private boolean isWin(int[] data) {
        
        int start = 0;
        int mid = data.length/2; 
        int end = data.length;
        boolean isSame = false;
        //we have to sort data
        Arrays.sort(data);
        System.out.println(Arrays.toString(data));
        for(int i =start;i < mid; i++) {
            if(data[i] == data[i+1]) {
                isSame = true;
            } else {
                isSame = false; 
            }
        }
        
        for(int i =mid+1;i < end-1; i++) {
            if(i< end && data[i] == data[i+1]) {
                isSame = true;
            } else {
                isSame = false; 
            }
        }
        return isSame;
    } 
    
}
