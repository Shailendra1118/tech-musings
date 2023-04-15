package com.sports.rafael.basics;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BasicsJava {

    @Test
    public void testSet12() {
        HashSet<Integer> set = new HashSet();
        int a = 100;
        set.remove(a);
        System.out.println("Hello");

        Math.random();
        List<Integer> list = new Random().ints(10 ,20)
                .boxed().collect(Collectors.toList());
        System.out.println(list);
    }
}
