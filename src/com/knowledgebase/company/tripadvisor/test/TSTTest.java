package com.knowledgebase.company.tripadvisor.test;

import java.util.Iterator;

import org.junit.Test;

import com.knowledgebase.company.locationlabs.bogglegame.StdOut;
import com.knowledgebase.company.tripadvisor.TST;

public class TSTTest {
    @Test
    public void add() {
        TST<Integer> tree = new TST<Integer>();
        tree.put("rachana", 0);
        tree.put("rat", 1);
        tree.put("apple", 2);
        tree.put("apples", 3);

        for (String key : tree.keys()) {
            StdOut.println(key + " " + tree.get(key));
        }

        Iterator<String> itr = (Iterator<String>) tree.prefixMatch("ra").iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        
        itr = (Iterator<String>) tree.prefixMatch("r*").iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

}
