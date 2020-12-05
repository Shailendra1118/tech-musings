package com.sports.rafael.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MaxSumK {

    public static void main(String[] args) {
        int arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        MaxSumK obj = new MaxSumK();
        int res = obj.findMaxSubArray(arr, k);
        System.out.println("max: "+res);
    }

    private int findMaxSubArray(int arr[], int size) {

        int l =0, r=size-1;
        if(size > arr.length) {
            throw new IllegalArgumentException("Invalid Size");
        }
        //first candidate
        int sum = 0;
        for(int i=0; i<size; i++){
            sum += arr[i];
        }
        int max = sum;
        for(r=size; r<arr.length;){
            sum = sum + arr[r] - arr[l];
            l++;
            r++;
            if(sum > max){
                max = sum;
            }
        }
        return max;
    }

    @Test
    public void testWithInvalidSize() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MaxSumK obj = new MaxSumK();
            int arr[] = {1, 4, 2};
            obj.findMaxSubArray(arr, 4);
        });
        assertTrue(exception.getMessage().contains("Invalid Size"));
    }

    @Test
    public void testWithValidSizeSuccess() {
        int arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        MaxSumK obj = new MaxSumK();
        int res = obj.findMaxSubArray(arr, k);
        assertEquals(res, 39);
    }

    @Test
    public void testWithValidSizeFailure() {
        int arr[] = {100, 200, 300, 400};
        int k = 2;
        MaxSumK obj = new MaxSumK();
        int res = obj.findMaxSubArray(arr, k);
        assertNotEquals(res, 500);
    }
}
