package com.sports.rafael.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Fivtran {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5 }; //{1, 1, 2, 2, 3, 3, 4, 5};
        int res = subarraysWithKDistinct(input, 3);
        System.out.println("RES: "+res);
    }


    public static int subarraysWithKDistinct(int[] nums, int k) {

        int minLen = nums.length;
        int i=0, j=0;
        Map<Integer,Integer> map = new HashMap<>();

        while(j<nums.length) {

            while(j<nums.length && map.size() < k) {
                map.put(nums[j], map.getOrDefault(nums[j],0)+1);
                j++;
                if(map.size() == k){
                    minLen = Math.min(minLen, ((j-1)-i+1));
                }


            }

            while(map.size() == k) {
                map.put(nums[i], map.get(nums[i]) -1);
                if(map.get(nums[i]) == 0)
                    map.remove(nums[i]);

                i++;
                if(map.size() == k){
                    minLen = Math.min(minLen, ((j-1)-i+1));
                }
            }

        }

        return minLen;
    }


}
