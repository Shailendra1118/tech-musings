package com.sports.rafael.basics.java;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CollectionCore {

    @Test
    //@Disabled
    public void testAddSet() {
        Set<Character> set = new HashSet<>();
        String test = "ABCD";
        test.chars().forEach(c -> set.add((char)c));
        System.out.println(set);
        assertTrue(isDiff("ab", "cd"));

        int a = 10;
        int b = 12;
        int val = a & b;
        System.out.println(val);
    }

    private boolean isDiff(String a, String b) {
        Set<Character> set = new HashSet<>();
        a.chars().forEach(c -> set.add((char)c));
        for(char c : b.toCharArray()) {
            if(set.contains(c))
                return false;
        }
        return true;

    }


    @Test
    public void testWordsSorting() {
        String [] arr = {"Kiev", "Sydney", "Kualalampur"};
        Arrays.sort(arr);
        Arrays.sort(arr, (a,b) -> b.length()-a.length());
        System.out.println(Arrays.toString(arr));
    }


}
