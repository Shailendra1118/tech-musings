package com.sports.rafael.leetcode;

import java.util.Arrays;

public class RainWater {

    public static void main(String[] args) {
        int arr[] = {1,0,2,1,0,1,3,2,1,2,1};

        int left[] = new int[arr.length];
        int right[] = new int[arr.length];

        //fill left
        left[0] = arr[0];
        int leftMax = arr[0];
        for(int i=1; i<arr.length; i++) {
            left[i] = leftMax;
            if(arr[i] > leftMax) {
                leftMax = arr[i];
            }
        }

        System.out.println(Arrays.toString(left));

        //fill right
        right[arr.length-1] = arr[arr.length-1];
        int rightMax = arr[arr.length-1];
        for(int i=arr.length-2; i>=0; i--) {
            right[i] = rightMax;
            if(arr[i] > rightMax)
                rightMax = arr[i];
        }
        System.out.println(Arrays.toString(right));

        //calculate water
        int water = 0;
        for(int i=0; i<arr.length; i++){
            int cur = arr[i];
            if(cur < right[i] && cur < left[i]) {
                water += Math.min(left[i], right[i]) - cur;

            }
        }
        System.out.println("Water: "+water);

    }
}
