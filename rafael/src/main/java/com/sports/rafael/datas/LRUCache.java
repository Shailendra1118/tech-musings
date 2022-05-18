package com.sports.rafael.datas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache implements Cache {

    private LinkedList<Integer> queue;
    private Map<Integer, String> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
        this.map = new HashMap<>(capacity);


    }

    private void temp() {
        LinkedList<Integer> list = new LinkedList<>();
        Iterator<Integer> iter = list.iterator();
        Integer curr = iter.next();
        int res = list.get(curr);
        int arr[][] = new int[2][];
        for(int[] temp : arr) {
            System.out.println(Arrays.toString(temp));
        }

    }


    @Override
    public void put(Integer key, String value) {

        if(map.containsKey(key)) {
            queue.remove(key); // Is it O(1)?

        }else{
            // did not find
            if(this.capacity == queue.size()) { //and cache is full
                int last = queue.removeLast();
                map.remove(last);
            }
        }
        //add new
        queue.addFirst(key);
        map.put(key, value);
    }

    //@Override
    public void putOld(Integer key, String value) {
        //if cache miss
        if(! map.containsKey(key)) {
            if(this.capacity == queue.size()) {
                //remove LRU item
                queue.removeLast();
                //remove from map
                map.remove(key);
            }
        }else{
            //cache hit, detach it
            queue.remove(key);
        }
        //update access order
        queue.addFirst(key);
        map.put(key, value);

    }

    @Override
    public String get(Integer key) {
        String value = map.get(key);
        queue.remove(key);
        queue.addFirst(key);
        return value;
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.size() == 0;
    }

    @Override
    public void clear() {
        queue.clear();
        map.clear();
    }

    @Override
    public void display() {
        this.queue.stream().forEach(n -> System.out.println(n));
        this.map.entrySet().stream().forEach((e -> System.out.println("Key: "+e.getKey() +", Value: "+e.getValue())));
    }
}


interface Cache {
    void put(Integer key, String value);
    String get(Integer key);
    int size();
    boolean isEmpty();
    void clear();
    void display();

}

