package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class NextGreaterElementIII {

    @Test
    public void testGreaterElement() {
        int input = 212;
        int res = nextGreaterElement(input);
        System.out.println("RES: "+res);
    }

    public int nextGreaterElement(int n) {
        String input = Integer.toString(n);
        //System.out.println(input);

        //String[] nums = input.split("");
        char[] nums = (n + "").toCharArray();
        System.out.println(Arrays.toString(nums));

        //find break point
        //int breakIndex = -1;
        int i;
        //int cur = Integer.valueOf(nums.length-1);
        for(i=nums.length-1; i>0; i--) {
            if(nums[i] > nums[i-1]) {
                //breakIndex = i-1;
                break;
            }
        }
        if (i == 0) {
            return -1;
        }

        //find smallest digit on right side of breakIndex that is greater than nums[breakIndex]
        int breakPoint = nums[i-1];
        int smallestIndex = i;
        for(int j= i+1; j<nums.length; j++) {
            if(nums[j] > breakPoint && nums[j] <= nums[smallestIndex]) {
                smallestIndex = j;
            }
        }

        //swap
        char temp = nums[i-1]; //breakpoint
        nums[i-1] = nums[smallestIndex];
        nums[smallestIndex] = temp;

        //reverse
        reverse(nums, i, nums.length - 1);


        try {
            return Integer.valueOf(String.valueOf(nums));
        } catch (NumberFormatException e) {
            return -1;
        }

        //String newStr = new String(nums);
        //Arrays.sort(newStr.substring(breakIndex+1));

        //return 0;
    }

    private void reverse(char[] nums, int i, int j) {
        int l = i, h = j;
        while (l < h)
            swap(nums, l++, h--);
    }

    private void swap(char[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
