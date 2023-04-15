package com.sports.rafael.algos;

public class MinJump {

    public static void main(String[] args) {
        int arr[] = {1,3,5,8,9,2,6,7,0,8,9};
        int res = minJumpToLastStep(arr, 0, arr.length-1);
        System.out.println("Res: "+res);
    }

    // There are maximum N possible ways to move from an element. O(n.n^n)
    public static int minJumpToLastStep(int[] arr, int start, int end) {

        //base
        if(start == end)
            return 0;
        if(arr[start] == 0)
            return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;
        // traverse all points reachable from arr[start]
        for(int i = start+1; i<=end && i <= start + arr[start]; i++) {
            int jumps = minJumpToLastStep(arr, i, end);
            if(jumps+1 < min) {
                min = jumps+1;
            }
        }
        return min;
    }
}
