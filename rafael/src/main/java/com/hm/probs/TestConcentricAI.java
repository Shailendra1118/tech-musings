package com.hm.probs;

import java.util.*;

public class TestConcentricAI {
    public static void main(String[] args) {
        //list of integers - input, non-duplicate
        // pair sum = target

        int[] arr = {1,2,3,4,5};
        int sum = 10;

        Set<Integer> map = new HashSet<>();
        for(int i=0; i<arr.length; i++) {
            int complement = sum - arr[i];
            if(map.contains(complement)) {
                System.out.println("Pair is "+arr[i] +" and "+complement);
            }else {
                map.add(arr[i]);
            }
        }
        testStream();
    }

    private static void testStream() {
        int[] arr = {1,4,5,612,45, 512, 999};
        int max = Arrays.stream(arr).max().getAsInt();
        int max1 = Arrays.stream(arr).reduce(0, (a, b) -> Math.max(a, b));
        System.out.println(max1);
        int sum = Arrays.stream(arr).sum();
        System.out.println("Sum: "+sum);
    }
}
