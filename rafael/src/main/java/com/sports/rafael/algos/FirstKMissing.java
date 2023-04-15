package com.sports.rafael.algos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstKMissing {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 0, 4, 9, 7};
        int k = 4;

        // Your code will replace this placeholder return statement
        for(int i=0; i<arr.length; i++) {
           if (arr[i] > 0 && arr[i] < arr.length && arr[i] != i) {
               swap(arr[i], i, arr);
           }
        }
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            if (arr[i] != i) {
                list.add(i);
            }
        }
        Set<Integer> set = new HashSet<>();
        int i = 0;
        for (; i<arr.length && list.size() < k; i++) {
            if(arr[i] != i) {
                list.add(i);
                set.add(arr[i]);
            }
        }

        for(int j=i; list.size() < k; j++) {
            if(! set.contains(j)) {
                list.add(j);
            }
        }

        System.out.println(list);

    }

    private static void swap(int id1, int id2, int[] arr) {
        int temp = arr[id1];
        arr[id1] =  arr[id2];
        arr[id2] = temp;
    }
}
