package com.knowledgebase.company.evernote;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MostFrequentWordsInDoc {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader(
                        "/Users/rachana/Workspaces/board_temp/knowledgebase/src/com/knowledgebase/company/evernote/data.txt"));
        String line = null;
        TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
        while ((line = reader.readLine()) != null) {
            if (tm.containsKey(line)) {
                tm.put(line, tm.get(line) + 1);
            } else {
                tm.put(line, 1);
            }
        }
        
        Map<String, Integer> result = sortByValue(tm);
        System.out.println("===== using map ======");
        System.out.println(result);
        System.out.println(" =====================");
        
        result = usingPriorityQueue(tm);
        System.out.println("===== using priority queue ======");
        System.out.println(result);
        System.out.println(" =====================");
        
        
    }

    static Map sortByValue(Map map) {
        List list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator() {
             public int compare(Object o1, Object o2) {
                  return - ((Comparable) ((Map.Entry) (o1)).getValue())
                 .compareTo(((Map.Entry) (o2)).getValue());
             }
        });

       Map result = new LinkedHashMap();
       for (Iterator it = list.iterator(); it.hasNext();) {
           Map.Entry entry = (Map.Entry)it.next();
           result.put(entry.getKey(), entry.getValue());
       }
       return result;
   } 
    
    public static Map usingPriorityQueue(Map map) {
        List list = new LinkedList(map.entrySet());
        PriorityQueue<Entry> heap = new PriorityQueue<>(list.size(), new Comparator() {
            public int compare(Object o1, Object o2) {
                return - ((Comparable) ((Map.Entry) (o1)).getValue())
               .compareTo(((Map.Entry) (o2)).getValue());
           }
      });
        heap.addAll(list);
        
        Map result = new LinkedHashMap();
        for (Iterator it = heap.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry)it.next();
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
