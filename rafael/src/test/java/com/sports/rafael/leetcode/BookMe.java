package com.sports.rafael.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class BookMe {
    public static void main(String[] args) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(100, 1);
        map.put(300, 3);
        //It returns the least key, greater than the specified key or null if there is no such key.
        System.out.println(map.ceilingKey(300)); // null

        //It returns the greatest key, less than or equal to the specified key,
        // or null if there is no such key.
        System.out.println(map.floorKey(100)); // null

        //It returns a key-value mapping associated with the greatest key strictly
        // less than the given key, or null if there is no such key.
        System.out.println(map.lowerEntry(100));

    }

    public boolean book(int start, int end){
        return false;
    }
}
