package com.sports.rafael.algos;

import java.util.Arrays;

public class MinCostStairs {

    int[] memo;
    public static void main(String[] args) {
        MinCostStairs main = new MinCostStairs();
        int cost[] = {1,100,1,1,1,100,1,1,100,1};
        int res = main.minCostClimbingStairs(cost);
        System.out.println("Min cost: "+res);
    }

    public int minCostClimbingStairs(int[] cost) {
        this.memo = new int[cost.length+1];
        Arrays.fill(this.memo, -1);
        return minCostClimbingStairsUtil(cost, cost.length);

    }

    private int minCostClimbingStairsUtil(int[] cost, int currentStep) {
        //base case
        if(currentStep == 0)
            return 0;
        if(currentStep == 1)
            return 0;;
        if(memo[currentStep] != -1) {
            return memo[currentStep];
        }
        else
            return memo[currentStep]
                    = Math.min(cost[currentStep-1] + minCostClimbingStairsUtil(cost,currentStep-1),
                    cost[currentStep-2]+ minCostClimbingStairsUtil(cost,currentStep-2));
    }
}
