package com.knowledgebase.interview.question.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Anagram {

    public static void main(String argv[]) {
        System.out.println(anagrams(new String[]{"rachana"}));
    }
    public static ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
        for (String s : strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String tempStr = new String(temp);
            if (hm.containsKey(tempStr)) {
                hm.get(tempStr).add(s);
            } else {
                ArrayList<String> tempList = new ArrayList<String>();
                tempList.add(s);
                hm.put(tempStr, tempList);
            }
        }
        for (ArrayList<String> list : hm.values()) {
            if (list.size() > 1) {
                for (String str : list) {
                    result.add(str);
                }
            }
        }
        return result;
    }
}
