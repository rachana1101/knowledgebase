package com.knowledgebase.own.datastructure.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * This is the homegrown implementation of hashmap
 * 
 * Works for normal condition 2 problem : Index collision and HashCode collision
 * TODO : FB and Ea will collision, add code for collision
 * 
 * @author rachana
 * 
 * @param <K>
 * @param <V>
 */
public class MyHashMap<K, V> {
    private static final int SIZE = 16;

    Object[] entries = new Object[SIZE];

    @SuppressWarnings("unchecked")
    public void put(K key, V value) {
//        System.out.println(" key hashcode " + key.hashCode());
        int index = h(key.hashCode());
        if (entries[index] == null) { // if there is no value, add it to the
                                      // entry
            List<Entry<K, V>> bucket = new ArrayList<Entry<K, V>>();
            bucket.add(new Entry<K, V>(key, value));
            entries[index] = bucket; // override the old one
        } else {
            //fetch the bucket 
            List<Entry<K, V>> bucket = (List<Entry<K, V>>) entries[index];
            for(Entry<K,V> entry : bucket) {
                if (key.equals(entry.getKey())) { // duplicate
                    entry.setValue(value); // if duplicate key than override the
                                           // value
                    entries[index] = entry; // override the old one
                    return;
                }  
            }
            bucket.add(new Entry<K, V>(key, value));
            entries[index] = bucket;
        }
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        if (entries[h(key.hashCode())].getClass().isAssignableFrom(
                Entry.class)) {
            Entry<K, V> entry = ((Entry<K, V>) entries[h(key.hashCode())]);
            return (V) entry.getValue();
        } else if (entries[h(key.hashCode())].getClass()
                .isAssignableFrom(ArrayList.class)) {
            List<Entry<K, V>> bucket = (List<Entry<K, V>>) entries[h(key
                    .hashCode())];
            Iterator<Entry<K, V>> itr = bucket.iterator();
            while (itr.hasNext()) {
                Entry<K, V> entry = (Entry<K, V>) itr.next();
                if (entry.getKey().equals(key)) {
                    return (V) entry.getValue();
                }
            }
        }
        return null;
    }

    public int getIndex(int hash) {
        int index = hash & SIZE - 1; // we are using & operator to get
        // the index in range of size
        return index;
    }

    static final int M = 11; // a prime

    public static int h(int x) {
        //return Math.abs(x) % M;
        return x & 0x7fffffff % SIZE-1 ;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MyHashMap [entries=" + Arrays.toString(entries) + "]";
    }

    public static void main(String[] argv) {
        MyHashMap<String, String> hashMap = new MyHashMap<String, String>();

        hashMap.put("one", "uno");
        hashMap.put("two", "Do");

        System.out.println(hashMap.get("one"));
        System.out.println(hashMap.get("two"));

        hashMap.put("two", "lalala");
        hashMap.put("three", "tro");

        System.out.println(hashMap.get("one"));
        System.out.println(hashMap.get("two"));
        System.out.println(hashMap.get("three"));

        System.out.println("FB".hashCode());
        System.out.println("Ea".hashCode());

        hashMap.put("FB", "FB");
        hashMap.put("Ea", "Ea");

        System.out.println(hashMap.get("FB"));
        System.out.println(hashMap.get("Ea"));
    }

}
