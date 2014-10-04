package com.knowledgebase.company.youtube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * -Following problems she gave me to write a code for it. First she asked me the algorithm, then she asked me the time complexity.:
Given a lists of strings, group them by last two letters.
i.e. input :
cat, top, bat, hop, rot, sat, food

op:
cat, bat, sat
top, hop

 * @author rachana
 *
 */
public class SortByLast2Characters {
    
    public static void main(String... argv) {
        List<String> data = Arrays.asList("cat", "top", "bat", "hop", "rot", "sat", "food");
        usingMultiMap(data);
        usingMap(data);
        
    }
    
    public static void usingMultiMap(List<String> data) {
        Multimap<String,Object> result = ArrayListMultimap.create();
        for(String value : data) {
            String last2Chars = value.substring(value.length()-2);
            result.put(last2Chars, value);
        }
        System.out.println(result);
    }
    
    public static void usingMap(List<String> data) {
        TreeMap<String, List<String>> results = new TreeMap<String, List<String>>();
        for(String value : data) {
            String last2Chars = value.substring(value.length()-2);
            if(results.containsKey(last2Chars)) {
                List<String> bucket = results.get(last2Chars);
                bucket.add(value);
                results.put(last2Chars, bucket);
            } else {
                List<String> bucket = new ArrayList<String>();
                bucket.add(value);
                results.put(last2Chars, bucket);
            }
        }
        System.out.println(results.toString());
    }

}
