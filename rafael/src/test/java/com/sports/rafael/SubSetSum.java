package com.sports.rafael;

public class SubSetSum {

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2 };
        int sum = 9;

        boolean res = isSubSetSumFound(arr, sum, arr.length-1);
        System.out.println(res);
    }

    private static boolean isSubSetSumFound(int[] arr, int sum, int idx) {
        if(sum == 0)
            return true;
        if(idx == 0)
            return false;
        return isSubSetSumFound(arr, sum-arr[idx], idx-1)
                || isSubSetSumFound(arr, sum, idx-1);
    }
}
