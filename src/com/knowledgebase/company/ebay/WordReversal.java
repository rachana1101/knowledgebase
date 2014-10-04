package com.knowledgebase.company.ebay;

public class WordReversal {
    public static void main(String argv[]) {
        String name = "rachana";
        System.out.println(reverseWithExtraSpace(name));
        System.out.println(reverseWithoutExtraSpace(name));
    }

    private static String reverseWithExtraSpace(String name) {
        StringBuffer reversed = new StringBuffer();
        for (int i = name.length() - 1; i >= 0; i--) {
            reversed.append(name.charAt(i));
        }
        return reversed.toString();
    }

    private static String reverseWithoutExtraSpace(String name) {
        char[] A = name.toCharArray();
        int max = name.length() - 1;
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
