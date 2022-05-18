package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestCore {


    @Test
    public void testStrBuilder() {
        StringBuilder sb = new StringBuilder();
        String str = "Shailendra ";
        System.out.println(str);
        System.out.println(str.trim());
        System.out.println(str.strip());
    }


    @Test
    public void testSet() {
        Set<Character> set = new HashSet<>();
        boolean val = set.add(" str".toCharArray()[0]);
        System.out.println(set);

        String s = " ";
        char arr[] = s.toCharArray();
        System.out.println(Arrays.toString(arr));
    }
}
