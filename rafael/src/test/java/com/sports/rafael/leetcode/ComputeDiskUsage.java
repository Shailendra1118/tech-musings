package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class ComputeDiskUsage {

    @Test
    void FindMaxDiskInSegments() {
        int x = 2;
        List<Integer> list = List.of(8,2,4,6);
        int res = calculate(x, list);
        System.out.println("RES: "+res);
    }

    private int calculate(int x, List<Integer> disks) {
        int max = Integer.MIN_VALUE; //, min = Integer.MAX_VALUE;
        int right = 0, left = 0;
        TreeSet<Integer> window = new TreeSet<>();

        while (right < x) {
            window.add(disks.get(right));
            right++;
        }
        max = Math.max(max, window.first());

        while (right < disks.size()) {
            window.remove(disks.get(left));
            window.add(disks.get(right));
            max = Math.max(max, window.first());
            right++;
            left++;
        }


        return max;
    }

    @Test
    void testTreeSet() {
        TreeSet<Integer> set = new TreeSet<>(Comparator.comparingInt(Integer::intValue).reversed());
        set.add(100);
        set.add(400);
        set.add(50);
        set.add(-100);
        System.out.println(set);
        System.out.println(set.last());
        set.remove(50);
        System.out.println(set);
    }

    @Test
    void testTreeMap() {
        TreeMap<Integer, Integer> map = new TreeMap();
        map.put(100, map.getOrDefault(100, 0)+1);
        map.put(50, map.getOrDefault(50, 0)+1);
        map.put(100, map.getOrDefault(100, 0)+1);
        map.put(-40, map.getOrDefault(-40, 0)+1);
        System.out.println(map);
        System.out.println("---");
        System.out.println(map.lastKey());
        map.put(100, map.get(100)-1);
        System.out.println(map);

    }
}
