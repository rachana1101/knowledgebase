package com.knowledgebase.company.ebay;

public class LongestPalindrome {
    
    public static void main(String... argv) {
        System.out.println(longestPalindrome("south indian lagnuage which is palindrome malayalam"));
        //System.out.println(longestPalindrome("malayalam"));
    }
    
    public static String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return null;
        }
     
        if (s.length() == 1) {
            return s;
        }
     
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            System.out.println(tmp);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
     
            // get longest palindrome with center of i, i+1
//            tmp = helper(s, i, i + 1);
//            System.out.println(tmp);
//            if (tmp.length() > longest.length()) {
//                longest = tmp;
//            }
        }
     
        return longest;
    }
     
    // Given a center, either one letter or two letter, 
    // Find longest palindrome
    public static String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }
}
