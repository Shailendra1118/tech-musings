package com.sports.rafael;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicOne {

    @Test
    public void arrayIt() {
        char arr[] = {'a', 'b'};
        System.out.println(arr.length);
    }

    @Test
    public void largestNum() {
        int arr[] = {1,2,3,4};
        permute(arr, 0, 3);
    }

    private void permute(int[] arr, int left, int right) {
        if (left == right) {
            System.out.println("Got it");
            System.out.println(Arrays.toString(arr));
        } else {
            for(int i=left; i<right; i++) {
                swap(arr, left, i);
                permute(arr, left+1, right);
                swap(arr, left, i);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void forLoop() {
        String temp = "This is Sparta!";
        String arr[]  = temp.split(" ");
        for(String s : arr){
            System.out.println(s);
        }
        System.out.println(Arrays.toString(arr));
    }


    @Test
    public void divide() {
        int a = 1;
        int b = 2;
        System.out.println(a/b);
        System.out.println(a%b);
    }

    @Test
    public void listForEach() {
        List<Integer> list = new ArrayList<>();
        for(int i : list) {
            System.out.println("i: "+i);
        }
    }
}
