package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

public class MaxConsecutiveOnes {

    @Test
    void findMaxConsecutiveOnes() {
        int arr[] = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        int left = 0, right = 0, options = k;
        while (right < arr.length) {
            if (arr[right] == 1) {
                right++;
                //counter++; // no need we can do (right-left) if sliding window
            } else if (arr[right] == 0 && options > 0) {
                right++;
                //counter++;
                options--;
            } else {
                //counter = 0;
                if (arr[left] == 0)
                    options++;
                left++;
            }
        }
        System.out.println("Res: "+ (right-left));
    }

    @Test
    void findConsecutiveOnesSimple() {
        int arr[] = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        int left = 0, right = 0, options = k;
        while (right < arr.length) {
            if (arr[right] == 0) {
                options--;
            }
            if (options < 0) {
                //check left
                if (arr[left] == 0) {
                    options++;
                }
                left++;
            }
            //always increase
            right++;
        }
        System.out.println("Res: "+ (right-left));
    }
}
