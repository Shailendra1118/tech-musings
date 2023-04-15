package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LongestBitonicSub {

    @Test
    public void testLBS() {
        int arr[] = {9,8,1,7,6,5,4,3,2,1};
        int res = findLongestBitonic(arr);
        System.out.println(res);
    }

    public int findLongestBitonic(int[] arr) {
        // base case
        if (arr.length == 0) {
            return 0;
        }
        int[] dpI = new int[arr.length];
        Arrays.fill(dpI, 1);
        int[] dpD = new int[arr.length]; //to store LDS that starts with arr[i]
        Arrays.fill(dpD, 1);


        for(int i=1; i<arr.length; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j]) {
                    dpI[i] = Math.max(dpI[i], dpI[j] + 1);
                }
            }
        }
        int max = 0;
        int n = arr.length;
        for(int i=n-2; i >= 0; i--) {
            for(int j=n-1; j> i; j--) {
                if(arr[i] > arr[j]) {
                    dpD[i] = Math.max(dpD[i], dpD[j] + 1);
                }
            }
            if(dpI[i] > 1 && dpD[i] > 1) { //Otherwise even if the array is strictly increasing or strictly decreasing, still it will be considered as bitonic sequence.
                max = Math.max(dpI[i] + dpD[i] -1, max);
            }
        }

        // It will work when we just need to find the longest decreasing subseq separately
        // but with bitonic we need to find dp[i] = LDS starting at i, so need to start from last
//        dpD[0] = 1;
//        for(int i=1; i < arr.length; i++) {
//            for(int j=0; j<i; j++) {
//                if(arr[i] < arr[j] && dpD[j] > dpD[i]) {
//                    //dpD[i] = Math.max(dpD[i], dpD[j] + 1);
//                    dpD[i] = dpD[j];
//                }
//            }
//            dpD[i]++;
//        }

        System.out.println(Arrays.toString(dpI));
        System.out.println(Arrays.toString(dpD));

//        int lbs = 1;
//        for (int i = 0; i < arr.length; i++) {
//            lbs = Integer.max(lbs, dpI[i] + dpD[i] - 1);
//        }

        return max;
    }
}
