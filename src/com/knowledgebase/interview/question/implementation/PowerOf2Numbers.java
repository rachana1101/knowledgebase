package com.knowledgebase.interview.question.implementation;

public class PowerOf2Numbers {
    public static void main(String[] argv) {
        System.out.println(power(3,5));
        System.out.println(" findPower method "+findPower(3, 2));
    }
    
    private static int power(int x, int y) {
        int pr = 1;
        for(int i=0;i<y;i++) {
            pr = pr * x;
        }
        return pr;
    }
    
    public static int findPower(int digit,int power) {
        int answer = digit << 2;
        return answer;
    }
}
