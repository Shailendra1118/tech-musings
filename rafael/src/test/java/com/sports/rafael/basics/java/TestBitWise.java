package com.sports.rafael.basics.java;

import org.junit.jupiter.api.Test;

import java.util.TreeSet;

public class TestBitWise {

    @Test
    public void testShifts() {
        System.out.println(2 >>>1);
    }

    @Test
    public void testTree() {
        TreeSet<Integer> set = new TreeSet();
        set.add(14);
        set.add(9);
        set.add(4);
        set.add(9);
        set.add(121);
        for(Integer n : set){
            System.out.println(n);
        }
    }
}
