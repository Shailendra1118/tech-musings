package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class LongestAbsPath {

    @Test
    void testSplitRegex() {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext";
        String[] output = input.split("[//n//t]");
        System.out.println(input.lastIndexOf('\t'));
        System.out.println(Arrays.toString(output));

        //char[] arr = input.toCharArray();
        StringTokenizer tokenizer = new StringTokenizer(input, "/n/t");
        System.out.println(tokenizer.countTokens());
        while(tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
    }


    private int longestPath = 0;
    @Test
    void longestAbsolutePath() {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        int res = findLongestPath(input);
        System.out.println(res);
    }

    int findLongestPath(String path) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int result = 0;
        System.out.println(Arrays.toString(path.split("\n")));
        for (String s : path.split("\n")) {
            int level = s.lastIndexOf('\t') + 1;
            System.out.println("Level: "+level);
            int len = s.length() - level;
            while (stack.size() > level + 1) {
                stack.pop();
            }
            if (s.contains(".")) {
                result = Math.max(result, stack.peek() + len);
            } else {
                stack.push(stack.peek() + len + 1);
            }
        }
        return result;
    }



}
