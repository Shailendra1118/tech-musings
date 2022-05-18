package com.sports.rafael.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public static void main(String[] args) {
        //LC40
        int[] nums = {1,2,2,5};
        int target = 5;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        System.out.println("Res:----");
        list.stream().forEach(l -> System.out.println(l));
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
