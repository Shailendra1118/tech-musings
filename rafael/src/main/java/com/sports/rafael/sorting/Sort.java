package com.sports.rafael.sorting;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        Sort sort = new Sort();
        int arr[] = {2, 22, 11, 33, 8, 23, 4};
        //sort.selectionSort(arr);
        //System.out.println(Arrays.toString(arr));

        //sort.insertionSort(arr);
        //System.out.println(Arrays.toString(arr));

        sort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
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
            System.out.println("After "+i+"th pass: "+ Arrays.toString(arr));
            i++;
        }
    }

    private void insertionSort(int[] arr) {
        int val = -1;
        int index = -1;
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
       // boolean found = false; we dont need to store the value, only keeping track of index is sufficed
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
