package com.knowledgebase.company.ebay;

/**
 * 
 * Given a string, reverse the word, but keep the comma, number and space
 * 
 * @author rachana
 * 
 */
public class ReverseSentence {
    public static void main(String argv[]) {
        String sentence = "a, yqo! qjktum ym. .fumuhau";
        System.out.println(reverseSentence(sentence));
    }

    private static String reverseSentence(String sentence) {
        StringBuffer reversed = new StringBuffer();
        char[] chars = sentence.toCharArray();
        if(chars.length==1) {
            reversed.append(chars[0]);
            return reversed.toString().trim();
        }
        for(int i=0;i<chars.length-1;i++) {
            if(!isChar(chars[i])) {
                reversed.append(chars[i]);
            } else {
                int j = i;
                StringBuffer word = new StringBuffer();
                while(isChar(chars[j]) && j < chars.length-1) {
                    word.append(chars[j]);
                    j++;
                }
                String wordR = reverse(word.toString());
                reversed.append(wordR);
                i=j-1;
            }
        }
        return reversed.toString().trim();
    }

    private static boolean isChar(char c) {
        if((c > 64 && c<90) || (c>96 && c<122)) {
            return true;
        }
        return false;
    }
    private static String reverse(String word) {
        char[] A = word.toCharArray();
        int max = word.length() - 1;
        int min = 0;

        while (min < max) {
            char temp = A[max];
            A[max] = A[min];
            A[min] = temp;
            max--;
            min++;
        }
        return new String(A);
    }
}
