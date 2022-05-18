package com.sports.rafael.algos;


import java.sql.SQLOutput;
import java.util.Arrays;

public class PermutationInString {

    public static void main(String[] args) {

        boolean res = checkInclusion("ab", "eidboaoo");
        System.out.println("Result: "+res);
    }

    private static boolean checkInclusion(String s1, String s2) {
        char[] s1Chars = s1.toCharArray();
        Arrays.sort(s1Chars);
        System.out.println("S1: "+Arrays.toString(s1Chars));
        char[] s2Chars = s2.toCharArray();
        Arrays.sort(s2Chars);
        System.out.println("S2: "+Arrays.toString(s2Chars));

        int startedAt = 0;
        boolean started = false;
        int i = 0;
        int j = 0;
        while(i < s2.length()) {
            j = 0;
            while(j < s1Chars.length && s1Chars[j] == s2Chars[i]) {
                if(! started) {
                    started = true;
                    startedAt = i;
                }
                j++;
                i++;
            }

            if(started) {
                if(j == s1Chars.length) {
                    System.out.println("Found!!");
                    break;
                }
                started = false;
                i = startedAt;
            }
            i++;
        }

        if(j < s1Chars.length) {
            started = false;
        }

        return started;
    }
}
