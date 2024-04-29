package com.sports.rafael.geeks;

import java.util.Arrays;

public class MaxWater {
    public static void main(String[] args) {
        int[] water = {1,8,6,2,5,4,8,25,7};
        int res = findMaxWater(water);
        System.out.println("Max water: "+res);
    }

    private static int findMaxWater(int[] water) {
        Pair[] left = new Pair[water.length];
        Pair[] right = new Pair[water.length];

        int maxSeen = water[0];
        int maxSeenIdx = 0;
        left[0] = new Pair(maxSeen, maxSeenIdx);
        for(int i=1; i<water.length; i++) {
            left[i] = new Pair(maxSeen, maxSeenIdx);
            if (water[i] > maxSeen) {
                maxSeen = water[i];
                maxSeenIdx = i;
            }
            System.out.println(left[i]);
        }

        maxSeen = water[water.length-1];
        maxSeenIdx = water.length-1;
        right[water.length-1] = new Pair(maxSeen, maxSeenIdx);
        for(int i=water.length-2; i>=0; i--) {
            right[i] = new Pair(maxSeen, maxSeenIdx);
            if (water[i] > maxSeen) {
                maxSeen = water[i];
                maxSeenIdx = i;
            }
            System.out.println(right[i]);
        }
        int maxWater = -1;
        for(int i=0; i<water.length; i++) {
            int minLine = Math.min(left[i].val, right[i].val);
            int totalWater = minLine * Math.abs(left[i].index - right[i].index);
            if (totalWater > maxWater) {
                maxWater = totalWater;
            }
        }



        return maxWater;
    }

    static class Pair{
        int val;
        int index;
        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
        public String toString() {
            return this.val+", "+this.index;
        }
    }

}
