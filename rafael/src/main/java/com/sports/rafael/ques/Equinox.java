package com.sports.rafael.ques;

public class Equinox {
    public static void main(String[] args) {
        //Equinix HackerEarth

        int N = 11;
        int M = 25;

        long res = solve(N, M);
        System.out.println("Res: "+res);

    }

    private static long solve(int n, int m) {
        long yMinx;
        int x = 1;
        int y = Integer.MAX_VALUE;

        boolean foundX = false;
        for(; x<Integer.MAX_VALUE; x++) {
            if((n^x) < (m&x)) {
                foundX = true;
                break;
            }
        }
        System.out.println("MinX: "+x);

        boolean foundY = false;
        for(; y>0; y--) {
            if((n^y) < (m&y)) {
                foundY = true;
                break;
            }
        }
        System.out.println("MinY: "+y);

        if(foundX && foundY)
            return y-x;
        return -1;
    }
}
