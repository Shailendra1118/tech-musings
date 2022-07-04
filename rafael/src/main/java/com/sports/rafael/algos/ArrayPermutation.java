package com.sports.rafael.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPermutation {

    public static void main(String[] args) {
        int arr[] = {1,2,3};
        permute(arr);
    }

    private static void permute(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        permuteUtil(arr, res, new ArrayList<>(), new boolean[arr.length]);
        System.out.println("Result: "+res);
    }

    private static void permuteUtil(int[] arr, List<List<Integer>> res, List<Integer> list, boolean[] used) {

        if(list.size() == arr.length) {
            res.add(new ArrayList<>(list));
        }else {
            for(int i=0; i<arr.length; i++) {
                if(used[i] || (i>0 && arr[i] == arr[i-1] && !used[i-1]))
                    continue;
                used[i] = true;
                list.add(arr[i]);
                permuteUtil(arr, res, list, used);
                used[i] = false;
                list.remove(Integer.valueOf(arr[i]));
            }
        }

    }
}
