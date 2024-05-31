package com.sports.rafael.datas;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class LinkedListTests {

    @Test
    void testBasics() {
        LinkedList<Integer> ll = new LinkedList<>();

        PriorityQueue<String> pq = new PriorityQueue<>(2); // able to set fixed size first
        pq.offer("2");
        pq.offer("3");
        pq.offer("4");
        pq.forEach(e -> System.out.println(e));

        StringBuilder sb = new StringBuilder();
    }

    @Test
    public void testLL() {
        LinkedList<int[]> q = new LinkedList<>();
        q.offer(new int[]{1,1});
        q.offer(new int[]{2,2});
        System.out.println(Arrays.toString(q.poll()));
    }


}
