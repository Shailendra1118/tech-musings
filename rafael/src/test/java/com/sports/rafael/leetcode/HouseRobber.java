package com.sports.rafael.leetcode;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int[] money = {2,5,7,8,3,8}; //11 ,21 , 23

        int[] memo = new int[money.length];
        Arrays.fill(memo, -1);
        int max = robFrom(0, money, memo);
        System.out.println("Max: "+max);

    }

    private static int robFrom(int i, int[] money, int[] memo) {

        //base condition
        if(i >= money.length)
            return 0;

        //return cached result
        if(memo[i] != -1)
            return memo[i];

        int res = Math.max(robFrom(i+1, money, memo), // current house not considered
                robFrom(i+2, money, memo) + money[i]); // considered so include current house's money
        return memo[i] = res;
    }
}
