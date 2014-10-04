package com.knowledgebase.company.youtube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortBuckets {

    public static void main(String... argv) {
        Comparator<Integer> min = new MinComparator();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(10, min);
        List<Integer> bucket1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> bucket2 = Arrays.asList(6, 7);
        List<Integer> bucket3 = Arrays.asList(10, 11);
        List<Integer> bucket4 = Arrays.asList(5, 6, 7, 10, 11);
        List<Integer> bucket5 = Arrays.asList(1, 5, 14, 15, 17);

        List<Integer> result = new ArrayList<Integer>();

        List<List<Integer>> buckets = Arrays.asList(bucket2, bucket1, bucket3,
                bucket4, bucket5);

        int maxLength = 1;
        for (List<Integer> bucket : buckets) {
            if (maxLength < bucket.size()) {
                maxLength = bucket.size();
            }
        }
        int ctr = 0;
        while (maxLength > 0) {
            for (List<Integer> bucket : buckets) {
                if (ctr < bucket.size()) {
                    minHeap.add(bucket.get(ctr));
                }
            }
            ctr++;
            System.out.println(" min heap >>>> " + minHeap);
            result.add(minHeap.poll());
            maxLength--;
        }
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        System.out.println(" result  >>>>>" + result);

    }
}

class MinComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 == null) {
            return 1;
        }
        if (o2 == null) {
            return -1;
        }
        return o1.compareTo(o2);
    }
}