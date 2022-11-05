package com.sports.rafael.algos;

import java.util.Arrays;

public class SortingEx {
    public static void main(String[] args) {

        SortingEx obj = new SortingEx();
        int arr[] = {3,5,2,6,8};
        obj.selectionSort(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{25,3,5,6,98, 34};
        obj.insertionSort(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{25,3,1,6,38,9};
        obj.mergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private void mergeSort(int[] arr) {

    }


    // Best algo for almost sorted array
    private void insertionSort(int[] arr) {
        for(int i=1; i<arr.length; i++) {
            int j = i;
            int val = arr[j];
            while(j>0 && val < arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = val;
        }
    }


    private void selectionSort(int arr[]) {
        int i=0;
        while(i < arr.length) {
            int iMin = i; //consider ith, first index from remaining arr is the minimum
            int j = i+1;

            while(j<arr.length) {
                if(arr[j] < arr[iMin]) {
                    iMin = j;
                }
                j++;
            }
            //swap
            int temp = arr[i];
            arr[i] = arr[iMin];
            arr[iMin] = temp;
            // increment i
            i++;
        }

    }

}
