package com.sports.rafael;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class Basic0 {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        String val = String.valueOf(map.get("Shailendra"));
        System.out.println(val);
        Map<String, List<Integer>> map1 = new HashMap<>();
        //map1.put(1, map1.getOrDefault(1, new ArrayList<>()).add(1));

        Map<Integer,List<Integer>> tree = new TreeMap<>(Collections.reverseOrder());
        tree.put(3, new ArrayList<>());
        tree.put(34343, new ArrayList<>());
        tree.putIfAbsent(343, new ArrayList<>());
        System.out.println(tree);




        //Heap
        int a = 5^2;
        System.out.println("A: "+a);

        Queue<Integer> que = new PriorityQueue<>(2, Collections.reverseOrder());
        que.add(399);
        que.add(4);
        que.add(400);
        System.out.println(que);
        que.offer(30);

        int mx = Integer.MIN_VALUE;
        System.out.println("mx: "+mx);
        List<Integer> list= new ArrayList<>();
        list.add(400);
        list.add(343);
        int[] resArray = list.stream().sorted().mapToInt(x->x).toArray();
        System.out.println("resArray: "+Arrays.toString(resArray));
        Integer res[] = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(res));

    }

}
