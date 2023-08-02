package com.sports.rafael.basics.java;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Sorting {

    @Test
    public void testStream() {
        int[] arr = {14,5,89,1};
        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println(max);
        int sum = Arrays.stream(arr).sum();
        System.out.println(sum);

        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        System.out.println(queue.size());
        Set<Integer> set = new HashSet<>();
        set.clear();

        String s = "Hello";
        int res = s.indexOf("e", 2);
        System.out.println("Res: "+res);
    }
    @Test
    public void testHM() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Shailendra", 5);
        map.put("Singh", 8);
        map.put("Yadav", 22);
        map.put("Papa", 22);
        map.put("Mr", 4);
        map.put("SuperHuman", 60);

        List<Map.Entry<String, Integer>> entryList =
                //map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
                // OR
                map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).collect(Collectors.toList());
        System.out.println(entryList);
        // OR
        List<String> keys = new ArrayList<>(map.keySet());
        keys.sort(Comparator.comparingInt(map::get).reversed());

        //OR custom comparator
        keys.sort((k1, k2) -> map.get(k1).equals(map.get(k2)) ? k1.compareTo(k2) : map.get(k1) - map.get(k2));
        System.out.println(keys);

    }


}
