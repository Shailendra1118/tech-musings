package com.sports.rafael.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterAtRight {
    // find the next greater element in the right side

    public static void main(String[] args) {
        int arr[] = {4, 0, 5, 11, 8, 12, 42};

        Stack<Integer> stack = new Stack<>();
        stack.push(0); //storing index
        int ans[] = new int[arr.length];
        Arrays.fill(ans, -1);

        for(int i=1; i<arr.length; i++) {
            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                //pop and store
                ans[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        System.out.println(Arrays.toString(ans));
    }
}
