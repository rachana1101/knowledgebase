package com.knowledgebase.company.tripadvisor;

import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer, DoubleLinkedNode<Integer,Integer>> map = new HashMap<Integer, DoubleLinkedNode<Integer,Integer>>();
    private DoubleLinkedNode<Integer,Integer> head;
    private DoubleLinkedNode<Integer,Integer> end;
    private int capacity;
    private int len;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.len = 0;
    }
    
    public Integer get(Integer key) {
        if(map.containsKey(key)) {
            DoubleLinkedNode<Integer,Integer> latest = map.get(key);
            removeNode(latest);
            setHead(latest);
            return (Integer) latest.value;
        } else {
            return -1;
        }
        
    }

    public void setHead(DoubleLinkedNode<Integer, Integer> node) {
        node.next = head;
        node.previous = null;
        if(head!=null) {
            head.previous = node;
        }
        head = node;
        if(end == null) {
            end = node;
        }
    }
    
    public void removeNode(DoubleLinkedNode<Integer, Integer> node) {
        DoubleLinkedNode<Integer, Integer> cur = node;
        DoubleLinkedNode<Integer, Integer> pre = cur.previous;
        DoubleLinkedNode<Integer, Integer> post = cur.next;
 
        if (pre != null) {
            pre.next = post;
        } else {
            head = post;
        }
 
        if (post != null) {
            post.previous = pre;
        } else {
            end = pre;
        }
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)) {
            DoubleLinkedNode<Integer,Integer> data = map.get(key);
            data.value = value;
            //remove the node from the existing position and put it from the front  
            removeNode(data);
            //put it on the head
            setHead(data);
        } else {
            DoubleLinkedNode<Integer,Integer> newData = new DoubleLinkedNode<Integer,Integer>(key, value);
            //Till we have a capacity keep adding the new entry at the head 
            if(len < capacity) {
                //set it at head
                setHead(newData);
                map.put(key, newData);
                len++;
            } else {
                /**
                 * map.remove(end.key);
                end = end.pre;
                if (end != null) {
                    end.next = null;
                }
 
                setHead(newNode);
                map.put(key, newNode);
                 */
                map.remove(end.key);
                end = end.previous;
                if(end !=null) {
                    end.next = null;
                }
                //removeNode(endNode);
                //set it at head
                setHead(newData);
                map.put(key, newData); //since we are just replacing we will not incrment
            }
        }
    }
}

class DoubleLinkedNode<K,V> {
    V value;
    K key;
    DoubleLinkedNode<K,V> previous;
    DoubleLinkedNode<K,V> next;
    
    public DoubleLinkedNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
