package com.knowledgebase.company.ebay;
/**
 * 
 *
 */
public class FindSumof100 {
    public static void main(String[] args) {
        String seq = "123456789";
        findSum(seq, 100,"");
    }
    private static void findSum(String seq,int currSum, String finalSeq) {
        if(seq.length() == 0) {
            if(currSum == 0) {
                System.out.println("Found ---> "+finalSeq);  
            }
            return;
        }
        for(int i = 1; i <= seq.length();i++) {
            String subsequence = seq.substring(0, i);
            int number = Integer.parseInt(subsequence);
            findSum(seq.substring(i),currSum - number, subsequence +"+"+finalSeq );
            findSum(seq.substring(i), number- currSum, subsequence +"-"+finalSeq );
        }   
    }
}
