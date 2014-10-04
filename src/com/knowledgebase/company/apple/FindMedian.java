package com.knowledgebase.company.apple;

import java.util.Arrays;

public class FindMedian {
    public static void main(String... str) {
        int[] array1 = { 1, 2, 3, 4, 5, 6 };
        int[] array2 = { 5, 6, 7, 9, 10, 13, 14, 15 };
        
        int med = median(array1, array2);
        System.out.println(med);
    }

    public static int median(int[] a1, int[] a2) {
        if(a1.length < 2 || a2.length<2) {
            int [] temp = a1;
            temp = a2;
            return findMedian(temp);
        }
        int med1 = findMedian(a1);
        int med2 = findMedian(a2);
        int[] temp;
        int[] temp1;
        if(med1 > med2) {
            temp = Arrays.copyOfRange(a1, 0, Arrays.binarySearch(a1, med1));
            temp1 = Arrays.copyOfRange(a2, Arrays.binarySearch(a2, med2), a2.length);
        } else if(med2 > med1) {
            temp = Arrays.copyOfRange(a1, Arrays.binarySearch(a1, med1), a1.length);
            temp1 = Arrays.copyOfRange(a2, 0, Arrays.binarySearch(a2, med2));
        } else {
            return med1;
        }
        return median(temp, temp1);
    }
    
    public static int findMedian(int[] array) {
        if(array.length == 1) {
            return array[0];
        }
        if (array.length % 2 == 1) {
            return array[(array.length + 1) / 2];
        } else {
            return array[(array.length) / 2];
        }
    }
}
