package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class DivideNConqure {

    @Test
    void testSubArraySum() {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int res = subArraySum(arr);
        System.out.println("RES: "+res);
        Assert.isTrue(res == 6, "Wrong answer");
    }

    private int subArraySum(int[] arr) {
        return subArraySumUtil(arr, 0, arr.length-1);
    }

    private int subArraySumUtil(int[] arr, int left, int right) {
        //int maxSum = 0;
        if (left > right) {
            return Integer.MIN_VALUE;
        }
        int mid = left + (right-left)/2;
        int leftMax = subArraySumUtil(arr, left, mid-1);
        int rightMax = subArraySumUtil(arr, mid+1, right);
        //check linearly if max is somewhere within leftHalf or rightHalf
        int midLeftMax = 0, midRightMax = 0;
        for(int i = mid-1, sum = 0; i>=left; i--) {
            sum += arr[i];
            //keep on calculating max
            midLeftMax = Math.max(midLeftMax, sum); // negative items can lower the sum
        }
        for(int i = mid+1, sum = 0; i<=right; i++) {
            sum += arr[i];
            midRightMax = Math.max(midRightMax, sum); // negative items can lower the sum
        }
        int middleMax = midLeftMax + midRightMax + arr[mid];
        return Math.max(Math.max(leftMax, rightMax), middleMax);
    }
}
