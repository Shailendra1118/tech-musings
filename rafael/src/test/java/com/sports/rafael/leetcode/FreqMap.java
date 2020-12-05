package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

public class FreqMap {

    public static void main(String[] args) {
        String input = "badcead";
        String output = getFrequencyString(input);
        System.out.println("Output: "+output);
    }

    private static String getFrequencyString(String input) {
        Map<Character, Integer> map = new TreeMap<>();
        char arr[] = input.toCharArray();
        for(char c : arr) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        //build output
        StringBuilder sb  =  new StringBuilder();
        map.entrySet().stream().forEach(e -> sb.append(e.getKey()).append(e.getValue()));
        System.out.println("SB: "+sb.toString());
        return sb.toString();
    }

    @Test
    public void testChars() {
        char c = 'c';
         c = Character.toUpperCase(c);
        System.out.println(c);
    }
}
