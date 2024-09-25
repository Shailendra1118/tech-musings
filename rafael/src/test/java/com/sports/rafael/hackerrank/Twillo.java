package com.sports.rafael.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Twillo {

    @Test
    void testEncodedStrings() {
        String input1 = "12(3)45(2)11#(5)";
        String input2 = "1226#(2)24#";

        List<Integer> res = getEncodedFrequency(input1);
        System.out.println(res);
    }

    private List<Integer> getEncodedFrequency(String str) {
        Deque<Character> stack = new LinkedList<>();
        int[] resArray = new int[26];
        //Arrays.fill(resArray, 0); //no need

        char[] arr = str.toCharArray();
        for (int i=0; i<arr.length; i++) {
            char curr = arr[i];
            if (curr == ')') {
                int times = stack.pop()-'0';
                stack.pop(); //opening bracket
                char ch = stack.pop();
                if (ch == '#') {
                    setDoubleDigits(resArray, stack, times);
                } else {
                    resArray[ch - '0' - 1] = times;
                }
            } else {
                stack.push(curr);
            }
        }

        while (!stack.isEmpty()) {
            int ch = stack.pop();
            if (ch == '#') {
                setDoubleDigits(resArray, stack, 1);
            } else {
                resArray[ch - '0' - 1] = 1;
            }

        }

        return Arrays.stream(resArray).boxed().collect(Collectors.toList());
    }

    private void setDoubleDigits(int[] resArray, Deque<Character> stack, int times) {
        int fr = stack.pop()-'0';
        int sec = stack.pop()-'0';
        int val = (sec*10)+fr;
        System.out.println("val: "+val);
        resArray[val-1] = times;
    }
}
