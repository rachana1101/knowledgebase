package com.knowledgebase.company.apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * given 2 arrays wrds[] , chars[] as an input to a function such that wrds[] =
 * [ "abc" , "baa" , "caan" , "an" , "banc" ] chars[] = [ "a" , "a" , "n" , "c"
 * , "b"] Function should return the longest word from words[] which can be
 * constructed from the chars in chars[] array. for above example - "caan" ,
 * "banc" should be returned
 * 
 * Note: Once a character in chars[] array is used, it cant be used again. eg:
 * words[] = [ "aat" ] characters[] = [ "a" , "t" ] then word "aat" can't be
 * constructed, since we've only 1 "a" in chars[].
 * 
 * @author rachana
 * 
 */
public class WordGame {

    public static void main(String... strings) {
        List<String> list = Arrays.asList("abc", "baa", "caan", "an", "banc");
        List<String> chars = Arrays.asList("a", "a","n", "c", "b");
        List<String> required = new ArrayList<String>();
 
        int max = 0;
        for (String word : list) {
            if (max < word.length()) {
                max = word.length();
                required.add(word);
            }
        }
        System.out.println(Arrays.toString(required.toArray()));
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        for (String word : list) {
            if (word.length() == max) {
                String[] letOfWords = word.split("");
                boolean isGood = false;
                map1.putAll(map);
                for (String c : letOfWords) {
                    if (map1.containsKey(c) && map1.get(c) > 0) {
                        isGood = true;
                        map1.put(c, map1.get(c) - 1);
                    } else {
                        isGood = false;
                    }
                }
                if(isGood) {
                    System.out.println(Arrays.toString(letOfWords));
                }
            }
        }
    }
}
