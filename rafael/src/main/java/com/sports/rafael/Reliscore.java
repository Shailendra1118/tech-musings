package com.sports.rafael;


/* Do not add a package declaration */
import java.util.*;
import java.io.*;

/* You may add any imports here, if you wish, but only from the
   standard library */

public class Reliscore {
    public static int processArray(ArrayList<Integer> array) {
        /*
         * Modify this function to process `array` as indicated
         * in the question. At the end, return the appropriate
         * value.
         *
         * Please create appropriate classes, and use appropriate
         * data structures as necessary.
         *
         * Do not print anything in this method
         *
         * Submit this entire program (not just this function)
         * as your answer
         */
        int maxTillNow = array.get(0);
        int maxLoss = Integer.MIN_VALUE;
        for(int val : array) {
            if(val < maxTillNow) {
                int loss = maxTillNow - val;
                if(loss > maxLoss){
                    maxLoss = loss;
                }
            }else {
                maxTillNow = val;
            }
        }
        return maxLoss;
    }

    public static void main (String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int num = in.nextInt();
            if (num < 0)
                break;
            arrayList.add(Integer.valueOf(num));
        }
        int result = processArray(arrayList);
        System.out.println(result);
    }
}
