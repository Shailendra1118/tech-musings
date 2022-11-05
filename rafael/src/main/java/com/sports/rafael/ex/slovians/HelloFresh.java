package com.sports.rafael.ex.slovians;

import com.google.common.math.PairedStats;

import java.util.Arrays;

public class HelloFresh {
    public static void main(String[] args) {
        HelloFresh obj = new HelloFresh();
        int arr[] = {2, -4, 2, -1, 3, -3, 10, -1, -11, -100, 8, -1};
        //int arr[] = {-1,-2,-3,-4,-5};
        int res = obj.getMaxSum(arr);
        System.out.println("Result: "+res);

        int indices[] = obj.getMaxSumIndices(arr);
        System.out.println("Indices: "+ Arrays.toString(indices));
    }

    /**
     *
     * @param arr
     * @return
     */
    public int getMaxSum(int arr[]) {
        if(arr == null || arr.length == 0)
            return 0;
        int maxTillNow = arr[0];
        int sum = arr[0];

        for(int i=1; i<arr.length; i++) {
            sum = sum + arr[i];
            if(sum < 0)
                sum = 0;
            if(sum > maxTillNow)
                maxTillNow = sum;
        }
        return maxTillNow;
    }

    public int[] getMaxSumIndices(int arr[]) {
        int res[] = new int[2];
        if(arr == null || arr.length == 0)
            return res;
        int maxTillNow = arr[0];
        int sum = arr[0];
        int start = 0;
        int end = 0;
        boolean inProgress = false;
        for(int i=1; i<arr.length; i++) {

            sum = sum + arr[i];
            if(sum < 0) {
                sum = 0;
                start = i;
            }
            if(sum > maxTillNow) {
                maxTillNow = sum;
                end = i;
            }
        }
        return new int[]{start,end};
    }
}
