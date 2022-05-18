package com.sports.rafael.pracs;

import java.util.Arrays;
import java.util.Comparator;

public class ParitySorting {

    public static void main(String[] args) {
        int arr[] = {3,1,2,4};
        int res[] = sortByParity(arr);
        System.out.println(Arrays.toString(res));

        //Stream API
        sortStream(arr);

    }

    private static void sortStream(int[] arr) {
        int res[] = Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.comparingInt(a -> a % 2))
                .mapToInt(i->i)
                .toArray();
        System.out.println(Arrays.toString(res));

    }

    private static int[] sortByParity(int[] A) {
        int[] arr = new int[A.length];
        int begin = 0;
        int end = A.length - 1;
        for(int i = 0;i < A.length;i++){
            //[3,1,2,4]
            if(A[i] % 2 == 0){
                arr[begin++] = A[i];
            }else{
                arr[end--] = A[i];
            }
        }
        return arr;
    }
}
