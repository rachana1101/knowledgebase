package com.knowledgebase.company.ebay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Find Top k most frequent elements
 */
public class TopKthElement {
    public static void main(String argv[]) {
        int[] array = new int[] { 1, 2, 1, 1, 3, 4, 5, 3, 3, 3, 3, 3, 5, 6, 7,
                2, 9, 7, 5 };
        System.out.println(Arrays.toString(findTopKthElements(array, 2))
                .toString());
    }

    public static int[] findTopKthElements(int A[], int K) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length - 1; i++) {
            if (map.containsKey(A[i])) {
                int v = map.get(A[i]);
                map.put(A[i], ++v);
            } else {
                map.put(A[i], 1);
            }
        }
        HashMap<Integer, Integer> sortedMap = (HashMap<Integer, Integer>) sortByValues(map);

        int[] B = new int[K];
        List<Integer> list = new ArrayList<Integer>(sortedMap.keySet());
        for (int i = 0; i < list.size() - 1; i++) {
            if (i < K) {
                B[i] = (int) list.get(i);
            }
        }
        return B;
    }

    public static <K extends Comparable<Integer>, V extends Comparable<Integer>> Map<K, V> sortByValues(
            Map<K, V> map) {
        List<Map.Entry<K, V>> entries = new LinkedList<Map.Entry<K, V>>(
                map.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<K, V>>() {

            @Override
            public int compare(Entry<K, V> o1, Entry<K, V> o2) {
                return -o1.getValue().compareTo((Integer) o2.getValue());
            }
        });
        Map<K, V> sortedMap = new LinkedHashMap<K, V>();

        for (Map.Entry<K, V> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
