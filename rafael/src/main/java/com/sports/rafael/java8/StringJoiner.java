package com.sports.rafael.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class StringJoiner {


    public static void main(String[] args) {
        java.util.StringJoiner obj = new java.util.StringJoiner(",","[", "]");
        obj.add("Shailendra");
        obj.add("Singh");
        obj.add("Yadav");
        obj.setEmptyValue("Empty it is");
        System.out.println(obj); //[Shailendra,Singh,Yadav]
        System.out.println("Length is "+obj.length());


        TreeSet<Integer> set = new TreeSet<>();
        set.add(199);
        set.add(239);
        set.add(23);

        int nums[] = {-7, -3, 2, 3, 11};
        TreeSet<Integer> sortedSet = new TreeSet<>();
        for(int i =0; i<nums.length; i++){
            sortedSet.add(nums[i]*nums[i]);
        }
        ArrayList<Integer> list = new ArrayList<>(nums.length);
        sortedSet.forEach(e -> list.add(e));





        Integer[] intArray = list.toArray(new Integer[10]);
        for (Integer integer : intArray) {
            System.out.println(integer);
        }

        int arr[] = {1,2,3,4,5,6,7};
        int k = 3;
        rotateIt(arr, k);

    }

    private static void rotateIt(int[] nums, int k){
        int idx = nums.length-k;
        //reverse first half
        int l=0;
        int r=idx-1;
        int temp=0;
        while(l<r){
            temp = nums[r];
            nums[r--] = nums[l];
            nums[l++] = temp;
        }
        System.out.println("First rotate: "+Arrays.toString(nums));

        //second half
        l=idx;
        r=nums.length-1;
        while(l<r){
            temp = nums[r];
            nums[r--] = nums[l];
            nums[l++] = temp;
        }
        System.out.println("Second rotate: "+Arrays.toString(nums));

        //full reverse at the end
        l=0;
        r=nums.length-1;
        while(l<r){
            temp = nums[r];
            nums[r--] = nums[l];
            nums[l++] = temp;
        }

        System.out.println("Full rotate: "+Arrays.toString(nums));
    }
}
