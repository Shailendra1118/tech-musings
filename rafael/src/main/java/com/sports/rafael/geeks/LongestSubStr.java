package com.sports.rafael.geeks;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStr {
    public static void main(String[] args) {
        String input = "dvdf";
        int output = findLSS(input);
        System.out.println("max len: "+output);
    }

    private static int findLSS(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        int start = 0, end = 0;

        while(end < s.length()) {
            if(!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
            }else{
                set.remove(s.charAt(start));
                start++;
            }
            max = Math.max(max, end-start); //,set.size());
        }
        return max;
    }
}
