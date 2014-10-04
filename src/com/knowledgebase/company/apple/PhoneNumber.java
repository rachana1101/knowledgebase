package com.knowledgebase.company.apple;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class PhoneNumber {

    static Multimap<Integer, Character> map =ArrayListMultimap.create();
    static final int PHONE_NUMBER_LENGTH = 7;
    
    public static void main(String... str) {
        map.put(2, 'A');
        map.put(2, 'B');
        map.put(2, 'C');
        map.put(3, 'D');
        map.put(3, 'E');
        map.put(3, 'F');
        map.put(4, 'G');
        map.put(4, 'H');
        map.put(4, 'I');
        map.put(5, 'J');
        map.put(5, 'K');
        map.put(5, 'L');
        map.put(6, 'M');
        map.put(6, 'N');
        map.put(6, 'O');
        map.put(7, 'P');
        map.put(7, 'R');
        map.put(7, 'S');
        map.put(8, 'T');
        map.put(8, 'U');
        map.put(8, 'V');
        map.put(9, 'W');
        map.put(9, 'X');
        map.put(9, 'Y');
        
        int[] num = {4,0,8,6,8,5,1,0,3,5};
        printTelephoneWords(num);
        
    }

    static void printTelephoneWords(int[] phoneNum) {
        char[] result = new char[PHONE_NUMBER_LENGTH];
        doPrintTelephoneWords(phoneNum, 0, result);
    }

    static void doPrintTelephoneWords(int[] phoneNum, int curDigit, char[] result) {
        if (curDigit == PHONE_NUMBER_LENGTH) {
            System.out.println(new String(result));
            return;
        }
        for (int i = 1; i <= 3; i++) {
            result[curDigit] = getCharKey(phoneNum[curDigit], i);
            doPrintTelephoneWords(phoneNum, curDigit + 1, result);
            if (phoneNum[curDigit] == 0 || phoneNum[curDigit] == 1)
                return;
        }
    }

    static Character getCharKey(int digit, int position) {
        Collection<Character> list = map.get(digit);
        ArrayList<Character> result = new ArrayList<Character>();
        
        Iterator itr = list.iterator();
        while(itr.hasNext()) {
            result.add((Character) itr.next());
        }
        return result.get(position);
    }
}
