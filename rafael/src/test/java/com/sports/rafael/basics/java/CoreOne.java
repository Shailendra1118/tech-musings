package com.sports.rafael.basics.java;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class CoreOne {

    @Test
    public void testLinkedHM() {
        Map<Integer, Integer> map = new LinkedHashMap<>(10, 0.75f, true);
        map.put(1,200);
        map.put(3,100);
        map.put(3, 200);
        map.get(1);

        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" :: "+entry.getValue());
        }

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(100);

        Stack<Integer> stk = new Stack<>();
        stk.add(100);
        System.out.println(stk);
    }

    @Test
    public void testHMap() {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(500,5);
        map.put(30,4);
        map.put(11,2);
        map.put(244,2);

        List<Map.Entry<Integer,Integer>> sortedByValue =
                map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toList());
        System.out.println(sortedByValue);
    }
}
