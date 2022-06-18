package com.sports.rafael.pracs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ShortestUnsorted {

    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        int res = shortedArray(nums);
        System.out.println("Result: "+res);
        int dup[] = nums.clone();

        List<Integer> list = new LinkedList<>();
        list.add(100);
        list.add(500);


        Queue<Integer> que = new LinkedList<>();
        que.add(100);
        que.offer(200);
        que.isEmpty();

        Stack<Integer> stack = new Stack<>();
        stack.peek();
        StringBuilder sb = new StringBuilder();
        sb.reverse();


    }

    private static int shortedArray(int nums[]) {
        int prev = nums[0];
        int i = 1;
        while(i < nums.length && nums[i] > prev) {
            prev = nums[i];
            i++;
        }
        i--;

        if(i == nums.length)
            return 0;

        int j = nums.length-1;
        prev = nums[j];
        j = nums.length-2;
        while(j >= 0 && nums[j] < prev) {
            prev = nums[j];
            j--;
        }
        j++;

        if(j == 0)
            return 0;

        int[] temp = new int[j-i+1];
        System.out.println(Arrays.toString(temp));
        return temp.length;
    }
}
