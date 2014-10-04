package com.knowledgebase.company.ebay;

import java.util.ArrayList;
import java.util.List;

/**
 * Given 78 cents (target) you need to tell how many ways it is possible to make
 * the change using 25 cents(quarter), 10 cents(nickel), 5cents(dime),
 * 1cents(penny)
 * 
 */
public class FindChange {
    public static void main(String argv[]) {
        System.out.println(findChange(91).toString());
        System.out.println(findChange(78).toString());
        System.out.println(findChange(36).toString());
        System.out.println(findChange(49).toString());
    }
    
    private static List<Integer> findChange(int num) {
        List<Integer> list = new ArrayList<Integer>();
        int sub = num;
        while((sub - 25) > 0) {
            sub = sub - 25;
            list.add(25);
        }
        while((sub -10) > 0) {
            sub = sub -10;
            list.add(10);
        }
        while((sub-5) > 0) {
            sub = sub -5;
            list.add(5);
        }
        while((sub-1) >= 0) {
            sub = sub -1;
            list.add(1);
        }
        return list;
    }
}
