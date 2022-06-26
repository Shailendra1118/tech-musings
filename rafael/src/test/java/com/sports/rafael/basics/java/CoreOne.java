package com.sports.rafael.basics.java;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
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

    @Test
    public void testTree() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(100);
        queue.add(200);
        queue.add(400);
        queue.remove(); //removeFirst
        System.out.println(queue);
        queue.element();

        Set<Integer> tree = new TreeSet<>();
        tree.add(100);
        tree.add(90);
        tree.add(200);
        System.out.println(tree);
        tree.remove(90);
        System.out.println("Post removal: "+tree);

    }

    @Test
    public void testLinkedList() {
        List<Integer> list = new LinkedList<>();
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);
        list.remove(1);
        list.remove(Integer.valueOf(300));
        System.out.println(list);


        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(100); //same as queue, add from the tail, addLast(x)
        ll.addFirst(200);
        ll.addLast(300);
        System.out.println(ll);

        Deque<Integer> deq = new LinkedList<>();

    }


    @Test
    public void testStreamFilter() {
        int nums[] = {2,2,3,3,3,4};
        int toCompare = nums[2];

        int updatedNums[] = Arrays.stream(nums).filter(x -> Math.abs(x-nums[5])!=1).toArray();
        System.out.println(Arrays.toString(updatedNums));
    }
}
