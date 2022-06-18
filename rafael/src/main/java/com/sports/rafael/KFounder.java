package com.sports.rafael;

public class KFounder {

   /* N = 10;
    M = 2;

    k = 3

    m^k nearest to the value of N */

    public static void main(String[] args) {

        int n = 17;
        int m = 2;
        int res = findK(n, m);

    }

    private static int findK(int n, int m) {
        //int minDiff = Integer.MAX_VALUE;
        int k = 1;
        double currDiff = 0;
        double prevDiff = m;
        while(true){
            double out = Math.pow(m, k);
            currDiff = Math.abs(out-n);
            if(currDiff > prevDiff)
                return k;
            prevDiff = currDiff;
            k++;
        }

    }
}
