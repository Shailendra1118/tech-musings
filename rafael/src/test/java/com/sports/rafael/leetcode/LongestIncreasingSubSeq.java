package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LongestIncreasingSubSeq {

    @Test
    public void testLIS() {
        int arr[] = {1,2,4,3,5,4,7};
        int arr1[] = {2,2,2,2,2};
        int res = findNumberOfLIS(arr1);
        System.out.println(res);
    }

    public int findNumberOfLIS(int[] nums) {
        if(nums.length == 1)
            return 1;
        boolean repeatedArray = true;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                repeatedArray =false;
                break;
            }
        }
        if(repeatedArray) {
            return nums.length;
        }

        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(dp, 1); //because each place is a subsequence of length 1
        Arrays.fill(count, 1);

        int maxLen = 0;
        for(int i=1; i<nums.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    if(dp[i] < dp[j]+1) {
                        dp[i] = dp[j]+1;
                        if(maxLen < dp[i]) {
                            maxLen = dp[i];
                        }
                        count[i] = count[j];
                    }else if (dp[i] == dp[j]+1) {
                        count[i] += count[j];
                    }
                }
            }
        }
        System.out.println("MaxLen: "+maxLen);
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(count));
        int res = 0;
        for(int i=0; i<dp.length; i++) {
            if(dp[i] == maxLen) {
                res += count[i];
            }
        }
        return res;
    }
}
