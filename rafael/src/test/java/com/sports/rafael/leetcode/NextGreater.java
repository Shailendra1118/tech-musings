package com.sports.rafael.leetcode;

import java.util.Arrays;

public class NextGreater {

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        int[] res = findNextGreater(arr);
        System.out.println("Res: "+ Arrays.toString(res));
    }

    private static int[] findNextGreater(int[] arr) {
        //int[] res = new int[arr.length];
        int i = arr.length-1;
        int j = 0;
        while(i > 0) {
            if(arr[i] > arr[i-1]) {
                swapIt(arr, i, i-1);
                j = i;
                break;
            }
            i--;
        }

        if(j == 0) {
            Arrays.sort(arr);
            return arr;
        }
        //go rightwards
        while(j < arr.length-1) {
            if(arr[j] > arr[j+1]) {
                swapIt(arr, j, j+1);
            }
            j++;
        }
        return arr;
    }

    private static void swapIt(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
