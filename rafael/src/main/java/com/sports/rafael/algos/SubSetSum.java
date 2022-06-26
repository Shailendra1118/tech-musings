package com.sports.rafael.algos;

public class SubSetSum {

    public static void main(String[] args) {
        int arr[] = {3, 34, 4, 12, 5, 2};

        //boolean res = isSubSetExists(arr, 1, 0, 0);
        boolean res = isSubSetExistsOne(0, arr, 0);
        System.out.println("Exists: "+res);

        System.out.println("ExitsTwo: "+isSubSetExistsTwo(arr, arr.length, 75));
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
            return target == 0; //can directly be return as false
        if(target < 0)
            return false;

        return isSubSetExistsOne(start+1, arr, target-arr[start]) //consider
            || isSubSetExistsOne(start+1, arr, target); // don't consider
    }

    /**
     * Start with last
     * @param arr
     * @param len
     * @param target
     * @return true or false
     */
    public static boolean isSubSetExistsTwo(int[] arr, int len, int target) {
        //base case
        if(target == 0)
            return true;
        if(len == 0)
            return false;

        return isSubSetExistsTwo(arr, len-1, target)
                || isSubSetExistsTwo(arr, len-1, target-arr[len-1]);
    }
}
