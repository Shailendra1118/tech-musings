package com.sports.rafael.algos;

public class SubSetSum {

    public static void main(String[] args) {
        int arr[] = {3, 34, 4, 12, 5, 2};

        //boolean res = isSubSetExists(arr, 1, 0, 0);
        boolean res = isSubSetExistsOne(0, arr, 19);
        System.out.println("Exists: "+res);
    }

    public static boolean isSubSetExists(int arr[], int target, int sum, int start) {

        if(sum == target) {
            System.out.println("Found!!");
            return true;
        }
        if(sum > target)
            return false;

        if(start == arr.length)
            return target == 0;;

        boolean select = isSubSetExists(arr, target, sum+arr[start], start+1);
        //sum +=arr[start];
        boolean reject = isSubSetExists(arr, target, sum, start+1);
        return reject || select;
    }

    public static boolean isSubSetExistsOne(int start, int[] arr, int target) {
        if(target == 0) {
            System.out.println("Found!!");
            return true;
        }
        if(start == arr.length)
            return target == 0;
        if(target < 0)
            return false;

        return isSubSetExistsOne(start+1, arr, target-arr[start]) //consider
            || isSubSetExistsOne(start+1, arr, target); // don't consider
    }
}
