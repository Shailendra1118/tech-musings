package com.sports.rafael.leetcode;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation obj = new NextPermutation();
        int[] input =  {1,3,2}; //{4,2,0,2,3,2,0}; // [4,2,0,3,0,2,2]
        obj.nextPermutation(input);
        System.out.println(Arrays.toString(input));
    }

    public void nextPermutation(int[] nums) {
        int breakPoint = -1;
        for(int i=nums.length-2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                breakPoint = i;
                break;
            }
        }

        //find the smallest number on right
        for(int i=nums.length-1; i>breakPoint; i--) {
            if(nums[i] > nums[breakPoint]) {
                int temp = nums[i];
                nums[i] = nums[breakPoint];
                nums[breakPoint] = temp;
                break;
            }
        }

        //reverse, no need to sort it
        int left=breakPoint+1;
        int right = nums.length-1;
        while(left < right) {
            int temp = nums[left];
            nums[left]= nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
