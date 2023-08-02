package com.sports.rafael.basics.java;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomUtils {

    @Test
    public void testRandom() {
        Random random = new Random();
        double val = random.nextInt(50);
        System.out.println(val);
        Set<Map.Entry<Integer,Integer>> set = new HashSet<>();
        set.add(Map.entry(1,2));
        set.add(Map.entry(1,2));
        System.out.println(set.size());
        set.clear();
        System.out.println(set.size());

    }
}
