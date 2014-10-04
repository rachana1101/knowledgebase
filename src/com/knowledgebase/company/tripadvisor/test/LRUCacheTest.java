package com.knowledgebase.company.tripadvisor.test;

import org.junit.Test;

import com.knowledgebase.company.tripadvisor.LRUCache;

public class LRUCacheTest {
    LRUCache cache = new LRUCache(2);
    @Test
    public void put() {
        cache.set(1, 100);
        cache.set(2, 200);
        //cache.set(3, 300);
        //cache.set(4, 400);
        //cache.set(5, 500);
        
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        //System.out.println(cache.get(3));
        //System.out.println(cache.get(4));
        //System.out.println(cache.get(5));
        
        cache.set(6, 600);
        System.out.println(cache.get(6));
        System.out.println(cache.get(1));
    }
    
}
