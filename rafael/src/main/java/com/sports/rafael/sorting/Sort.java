package com.sports.rafael.sorting;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        Sort sort = new Sort();
        int arr0[] = {2, 22, 11, 33, 8, 23, 4};
        sort.selectionSort(arr0);
        System.out.println("selectionSort: "+Arrays.toString(arr0));

        int arr1[] = {2, 22, 11, 33, 8, 23, 4};
        sort.insertionSort(arr1);
        System.out.println("insertionSort: "+Arrays.toString(arr1));

        int arr2[] = {2, 22, 11, 33, 8, 23, 4};
        sort.bubbleSort(arr2);
        System.out.println("bubbleSort: "+Arrays.toString(arr2));

        int arr3[] = {2,1,1,33333,9,0,};
        sort.mergeSort(arr3);
        System.out.println("mergeSort: "+Arrays.toString(arr3));

        int arr4[] = {2, 22, 11, 0, 8, 0, 4};
        sort.quickSort(arr4);
        System.out.println("quickSort: "+Arrays.toString(arr4));
    }

    private void quickSort(int[] arr) {
        quickUtil(arr, 0, arr.length-1);
    }

    private void quickUtil(int[] arr, int low, int hi) {
        if(low >= hi)
            return;
        int partitionIdx = partition(arr, low, hi);
        quickUtil(arr, low, partitionIdx-1);
        quickUtil(arr,partitionIdx+1, hi);
    }

    private int partition(int[] arr, int low, int hi){
        int pIndex = low;
        int pivot = arr[hi]; // pivot is take as end element of array
        int i = low;
        for(; i<hi; i++){
            if(arr[i] <= pivot){
                int temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;
                pIndex++;
            }
        }
        //swap pIndex's value with pivot
        int temp = arr[pIndex];
        arr[pIndex] = arr[hi];
        arr[hi] = temp;
        return pIndex;
    }

    private void mergeSort(int[] arr) {
        mergeUtil(arr, 0, arr.length-1);
    }

    private void mergeUtil(int[] arr, int lo, int hi) {
        //int N = arr.length;
        //base condition
        if(arr.length < 2)
            return;
        int mid = lo + (hi-lo)/2;
        int[] left = Arrays.copyOfRange(arr, lo, mid+1); //to is exclusive index
        int[] right = Arrays.copyOfRange(arr, mid+1, arr.length); //from is inclusive
        mergeUtil(left, 0, left.length-1);
        mergeUtil(right, 0, right.length-1);

        //merge
        int i=0, j=0, k=0;
        while(i<left.length && j<right.length) {
            if(left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while(i<left.length)
            arr[k++] = left[i++];
        while(j<right.length)
            arr[k++] = right[j++];
    }

    private void bubbleSort(int[] arr) {
        int i = 0;
        while(i < arr.length-2){
            for(int j=0; j<arr.length-i-1; j++){ // improvement arr.length-i-1
                if(arr[j] > arr[j+1]){
                    //swap
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
            //System.out.println("After "+i+"th pass: "+ Arrays.toString(arr));
            i++;
        }
    }

    private void insertionSort(int[] arr) {
        int val; //inside method variable initialization is redundant
        int index;
        for(int i=0; i< arr.length; i++){
            val = arr[i];
            index = i;
            for(;index > 0 && arr[index-1] > val; index--){
                arr[index] = arr[index-1];
            }
            arr[index] =val;
        }
    }

    private void selectionSort(int[] arr) {
        int minIndex = 0;
       // boolean found = false; we don't need to store the value, only keeping track of index is sufficed
        for(int i=0; i< arr.length; i++){
            minIndex = i;
            for(int j=i+1; j< arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    //found = true;
                    //min = arr[j];
                    minIndex = j;
                }
            }
            //swap
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            //found = false;


        }

    }


}
