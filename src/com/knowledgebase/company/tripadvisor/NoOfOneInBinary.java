package com.knowledgebase.company.tripadvisor;

/**
 * get number of 1's in the binary presentation of an integer. Using hamming
 * weight
 * 
 * @author rachana
 * 
 */
public class NoOfOneInBinary {

    public static int noOfOnes(int value) {
        return Integer.bitCount(value);
    }

    public static int ones() {
        int n;
        int number = 1100110111;

        n = 0;
        while (number != 0) {

            int temp = number % 10;
            System.out.println("temp"+temp);
            if (temp == 1)
                n++;
            number = number / 10;
            System.out.println("number"+number);
        }

        return n;
    }

    /*
     * public int ones( int number) { int n; for (n = 0; number != 0; number >>=
     * 1) { if (number & 1) { n++; } } return n; }
     */

    public static void main(String... argv) {
        System.out.println(noOfOnes(10));
        System.out.println(ones());
    }

}
