package com.sports.rafael.basics.generics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.sports.rafael.leetcode.Palindrom.isPalindrome;

public class GenericCounter {

    @Test
    public void testCounter() {

        List<String> list = new ArrayList<>();


    }

    class GenericClass<E> {

        private Predicate<String> isPalindrome = s -> {
            int i = 0;
            int j = s.length();
            while(i<j) {
                if(s.charAt(i) == s.charAt(j)) {
                    i++;
                    j--;
                }else
                    return false;
            }
            return true;
        };

        /*public int countPalindromes(List<E> list) {
            int count = list.stream().filter(s -> isPalindrome(s))
                    .collect(Collectors.toList())
                    .size();
            return count;
        }*/
    }
}
