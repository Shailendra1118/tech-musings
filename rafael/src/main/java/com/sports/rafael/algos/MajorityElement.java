package com.sports.rafael.algos;

import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int nums[] = {1};
        int res = findMajority(nums);
        System.out.println("Majority: "+res);
    }

    private static int findMajority(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        Arrays.sort(nums);
        int counter = 0;
        int currentCandidate = -1;
        int i = 0;
        boolean repeated = false;
        while(i < nums.length) {
            counter = 1;
            repeated = false;
            while(i < nums.length-1 && nums[i] == nums[i+1] ) {
                i++;
                counter++;
                repeated = true;
            }
            if(counter > nums.length/2) {
                currentCandidate = nums[i-1];
                break;
            }
            if(!repeated){
                i++;
            }
        }
        return currentCandidate;
    }
}
