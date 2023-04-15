package com.sports.rafael.algos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicates {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1}; //{1,1,2};
        List<Integer> res = findDuplicates(nums);
        System.out.println(res);
    }
    public static List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {

            int idx = Math.abs(nums[i]-1);
            nums[idx] = nums[idx] * -1;
            if(nums[idx] > 0 && !set.contains(idx+1)) {
                set.add(idx+1);
            }
        }

        return set.stream().collect(Collectors.toList());
    }
}
