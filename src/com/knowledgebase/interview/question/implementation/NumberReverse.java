package com.knowledgebase.interview.question.implementation;

public class NumberReverse {
    public int reverseNumber(int number){
        
        int reverse = 0;
        while(number != 0){
            /**
             * 1. 8 
             * 2. 80 + 6 
             * 3. 860 + 8 = 868
             * 4. 8680 + 7
             * 
             * where everytime you divide by interger number will start loosing 
             * its last digit 
             * 1. 17868 / 10 = 1786
             * 2. 1786 /10 = 178
             *  
             */
            reverse = (reverse*10)+(number%10); 
            System.out.println("reverse >>>" + reverse);
            number = number/10;
            System.out.println("number >>>" + number);
        }
        return reverse;
    }
     
    public static void main(String a[]){
        NumberReverse nr = new NumberReverse();
        System.out.println("Result: "+nr.reverseNumber(17868));
    }
}
