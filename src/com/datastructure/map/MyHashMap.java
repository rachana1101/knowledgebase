package com.datastructure.map;

import java.util.LinkedList;

/**
 * http://www.vogella.com/articles/JavaDatastructures/article.html#map
 * @author rachana
 *
 * @param <K>
 * @param <V>
 */

public class MyHashMap<K,V> {
	
	private LinkedList<Entry<K,V>> buckets;
	private int size;
	private int DEFAULT_CAPACITY = 16;
	
	public MyHashMap() {
		buckets = new LinkedList<Entry<K,V>>();
	}
	
	public void put(K key, V value) {
		Entry<K,V> entry = new Entry<K, V>(key, value);
		buckets.add(size++, entry);
	}
	
	public V get(K key) {
		for(Entry<K,V> e: buckets) {
			if(e.getKey().equals(key)) {
				 return e.getValue();
			}
		}
		return null;
	}
	
	public static void main(String argv[]) {
		MyHashMap<String, String> map = new MyHashMap<String, String>();
		map.put("firstkey", "firstvalue");
		map.put("secondkey", "secondvalue");
		map.put("thirdkey", "thirdvalue");
		
		System.out.println(map.get("firstkey"));
	}
	
		
}

