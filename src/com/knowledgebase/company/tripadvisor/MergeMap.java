package com.knowledgebase.company.tripadvisor;

import java.util.HashMap;
import java.util.Map;

public class MergeMap {
    @SuppressWarnings("serial")
    public static void main(String... args) {

        /*
         * dict_a = {'a': 1, 'b': {'x': 2}, 'c': {'x': {'q': 3}, 'y': 9}}
         * 
         * dict_b = {'d': 2, 'b': 6, 'c': {'x': {'p': 9}, 'z': 10}}
         * 
         * 
         * # m returns a dictionary "result": result = {'a': 1, 'b': {'x': 2},
         * 'd': 2, 'c': {'x': {'q': 3, 'p': 9}, 'y': 9, 'z': 10}}
         */

        HashMap<String, Object> dictA = new HashMap<String, Object>();
        dictA.put("a", 1);
        dictA.put("b", new HashMap<String, Object>() {
            {
                put("x", 2);
            }
        });
        dictA.put("c", new HashMap<String, Object>() {
            {
                put("y", 9);
                put("x", new HashMap<String, Object>() {
                    {
                        put("q", 3);
                    }
                });
            }
        });
        System.out.println(dictA.toString());

        HashMap<String, Object> dictB = new HashMap<String, Object>();
        dictB.put("d", 2);
        dictB.put("b", 6);
        dictB.put("c", new HashMap<String, Object>() {
            {
                put("z", 10);
                put("x", new HashMap<String, Object>() {
                    {
                        put("p", 9);
                    }
                });
            }
        });
        System.out.println(dictB.toString());

        HashMap<String, Object> result = merge(dictA, dictB);
        System.out.println(result.toString());

    }

    public static HashMap<String, Object> merge(HashMap<String, Object> dictA,
            HashMap<String, Object> dictB) {

        HashMap<String, Object> result = new HashMap<String, Object>();
        result.putAll(dictA);

        for (Map.Entry<String, Object> entry : dictB.entrySet()) {
            if (!result.containsKey(entry.getKey())) { // this is the case for
                                                       // 'd'
                result.put(entry.getKey(), entry.getValue());
            } else {
                Object value = result.get(entry.getKey());
                if (value.getClass().isAssignableFrom(Map.class)
                        && entry.getValue().getClass()
                                .isAssignableFrom(Map.class)) {
                    // case for key 'c'
                    result.put(
                            entry.getKey(),
                            merge((HashMap<String, Object>) value,
                                    (HashMap<String, Object>) entry.getValue()));
                } else {
                    // case for b, since its a either case, just leave it
                }
            }
        }
        return result;
    }
}
