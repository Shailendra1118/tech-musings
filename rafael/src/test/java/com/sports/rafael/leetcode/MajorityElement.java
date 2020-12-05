package com.sports.rafael.leetcode;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MajorityElement {
    public static void main(String[] args) {
        int arr[] = {5,5,6,5,5,5,7,8,5,5,5,8,5,2,6,5,5};

        finMajor(arr);
    }

    private static void finMajor(int[] arr) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i : arr) {
            freq.put(i, freq.getOrDefault(i, 0)+1);
        }

        Map<Integer,Integer> sorted = freq.entrySet().stream()
                //.sorted(Map.Entry.comparingByValue(Collections.reverseOrder())) same
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(),(e1,e2) -> e1, LinkedHashMap::new));

        sorted.entrySet().forEach(e -> System.out.println(e.getKey()+":"+e.getValue()));
    }
}
