package com.sports.rafael.hackerrank;

import org.junit.jupiter.api.Test;

public class KSubarray {

    @Test
    void testKSubArrays() {
        int[] input = {1,2,3,4,1};
        int k = 3;
        int total = findSubArrays(input, k);
        System.out.println("Res: "+total);
    }

    private int findSubArrays(int[] input, int k) {
        //List<Integer> subarrays = new ArrayList<>();
        int subarrayCount = 0;
        // Outer loop for the start index
        for (int start = 0; start < input.length; start++) {
            // Inner loop for the end index
            for (int end = start; end < input.length; end++) {
                //List<Integer> subarray = new ArrayList<>();

                // Collecting the elements for subarray from start to end
                int sum = 0;
                for (int i = start; i <= end; i++) {
                    sum += input[i];
                    //subarray.add(input[i]);
                }

                // Adding the subarray to the result if it fits
                if (sum%k == 0) {
                    subarrayCount++;
                }
            }
        }

        return subarrayCount;
    }
}
