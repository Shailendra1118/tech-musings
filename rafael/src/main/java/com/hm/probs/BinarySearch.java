package com.hm.probs;

public class BinarySearch {

    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5,6};
        int toFind = 6;

        int l = 0;
        int h = arr.length-1;
        int mid = 0;
        // if first or last is the one element
        while(l < h) {
            mid = l+(h-l)/2;
            if(arr[mid] == toFind) {
                System.out.println("found: "+toFind);
                break;
            }else {
                if(arr[mid] < toFind) {
                    l++;
                }else{
                    h--;
                }
            }
        }

    }
}
