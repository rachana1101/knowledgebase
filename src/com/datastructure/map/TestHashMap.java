package com.datastructure.map;

public class TestHashMap<K,V> {
	
	public static int SIZE = 16;
	@SuppressWarnings("unchecked")
	Entry<K,V>[] table = new Entry[SIZE];
	
	public void put(K key, V value) {
		int index = findIndexFor(key.hashCode());
		if(table[index] ==null) {
			table[index] = new Entry<K,V>(key,value);
		} else {
			Entry<K,V> e = table[index];
			if(e.getKey().equals(key)) {
				e.setValue(value);
			}
			table[index] = e;
		}
	}
	
	public V get(K key) {
		Entry<K,V> e = table[findIndexFor(key.hashCode())];
		return e.getValue();
	}
	
	public int findIndexFor(int hash) {
		System.out.println("****"+hash);
		System.out.println("hash >>>"+(hash & SIZE-1));
		return hash & SIZE-1;
	}

	public static void main(String argc[]) {
		TestHashMap<String, String> map = new TestHashMap<String,String>();
		map.put("first", "first");
		map.put("second", "second");
		//map.put("1", "third");
		System.out.println(map.get("first"));
		System.out.println(map.get("second"));
	}
}
