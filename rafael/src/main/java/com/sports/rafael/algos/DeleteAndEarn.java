package com.sports.rafael.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DeleteAndEarn {

    Map<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        DeleteAndEarn obj = new DeleteAndEarn();
        int nums[] = {3,4,2};
        List<Integer> list = new ArrayList<>();
        Arrays.stream(nums).forEach(x ->list.add(x));

        int res = obj.deleteAndEarn(list, nums.length-1);
        System.out.println("MaxPoints: "+res);
    }

    private int deleteAndEarn(List<Integer> nums, int current) {
        if(current == 0)
            return nums.get(0);
        if(current == 1)
            return Math.max(nums.get(0), nums.get(1));
        //int updatedNums[] =  Arrays.stream(nums).filter(x -> Math.abs(x-nums[current])!=1).toArray();
        int toCompare = nums.remove(current);
        nums = nums.stream().filter(x -> Math.abs(x-toCompare) != 1).collect(Collectors.toList());
        if(!map.containsKey(current)) {
            map.put(current, Math.max(toCompare + deleteAndEarn(nums, current-1),
                    deleteAndEarn(nums, current-1)));
        }
        return map.get(current);
    }
}
