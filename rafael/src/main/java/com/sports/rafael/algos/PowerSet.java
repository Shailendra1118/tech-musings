package com.sports.rafael.algos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleToIntFunction;

public class PowerSet {

    private static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int arr[] = {1,2,3};
        subSets(arr); // O(n * 2^n)
        //Arrays.sort(arr);


        //powerSetAnother(arr, new ArrayList<>(), 0);

        // List<Integer> temp = new ArrayList<>();

        // powerSetIncludingExcluding(arr, new ArrayList<>(), 0);

        System.out.println(res);

        //res.stream().forEach(list -> System.out.println(list));
    }

    private static void subSets(int arr[]) {
        List<List<Integer>> res = new ArrayList<>();
        subsetsUtil(arr, 0, res, new ArrayList<>());
        System.out.println("Total: "+res.size());
        System.out.println("Subsets: "+res);
    }

    private static void subsetsUtil(int[] arr, int start, List<List<Integer>> res, List<Integer> tempList) {

        if(start == arr.length) {
            res.add(tempList);
            return;
        }
        else{
            subsetsUtil(arr, start+1, res, new ArrayList<>(tempList));
            tempList.add(arr[start]);
            subsetsUtil(arr, start+1, res, new ArrayList<>(tempList));

        }
    }

    public static void powerSet(int[] arr, List<Integer> list, int start) {

        for(int i= start; i < arr.length; i++){
            //add
            list.add(arr[i]);

            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            res.add(temp);

            //recur
            powerSet(arr, list, i+1);
            //remove
            list.remove(Integer.valueOf(arr[i]));
        }
    }

    public static void powerSetAnother(int[] arr, List<Integer> list, int start) {

        //List<Integer> temp = new ArrayList<>();
        //temp.addAll(list);
        res.add(new ArrayList<>(list));
        for(int i= start; i < arr.length; i++){
            //add
            list.add(arr[i]);
            //recur
            powerSetAnother(arr, list, i+1);
            //remove
            list.remove(Integer.valueOf(arr[i]));
            //list.remove(list.size() - 1);
        }
    }

    public static void powerSetIncludingExcluding(int[] arr, List<Integer> list, int start) {

        //base condition
        if(start == arr.length) {
            res.add(list);
            return;
        }
        //not including value at start index
        powerSetIncludingExcluding(arr, new ArrayList<>(list), start +1);
        list.add(arr[start]);
        // including value at start index
        powerSetIncludingExcluding(arr, new ArrayList<>(list), start +1);


    }
}
