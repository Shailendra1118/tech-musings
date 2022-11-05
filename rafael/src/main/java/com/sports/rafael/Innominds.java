package com.sports.rafael;

import java.util.Arrays;
public class Innominds {

    public static void main(String[] args) {

        char[] arr = {'a','e','f','d','c','g','h'};
        //You have to ensure that no letter is at a position equal to its position in the alphabet
        /**
         * Solutions -
         * 1. Assuming array length is fixed and input like all 1's (OR not distinct) we can not re-arrange all nums/chars,
         * because there is no candidate to fill the void, and we can not increase the size of input array.
         *
         * 2. Swap with adjacent element but to ensure it does not break the rule we need to sort it before swapping.
         *
         */

        //int[] input = {1,1,3,4,5,6,7}; // won't work
        int[] input = new int[]{1,2,3,4,5,6};
        // Validate if all elements
        int len = input.length;
        Arrays.sort(input);
        for(int i=0; i<len-1; i++) {
            if(input[i] == i+1) {
                int temp = input[i];
                input[i] = input[i+1];
                input[i+1] = temp;
            }
        }

        //swap last one
        if(input[len-1] == len) {
            int temp = input[len-1];
            input[len-1] = input[len-2];
            input[len-2] = temp;
        }
        System.out.println("Result: "+Arrays.toString(input));

    }
}
