package com.sports.rafael.leetcode;

import java.util.List;


/**
 * 
 */
public class Fivtron {

    public static void main(String[] args) {

        int[] arr = {0,-10,-20,-30,50};
        int res = maxGameScore(arr);
        System.out.println("Res: "+res);
    }

    public static int maxGameScore(int[] cell) {
        // Write your code here
        //nt maxScore = Integer.MIN_VALUE;
        int scores[] = new int[cell.length+1];
        scores[0] = 0;
        scores[1] = 0;
        int currCostWithPrime = Integer.MIN_VALUE;
        for(int i=1; i<cell.length; i++) {
            //System.out.println("currCostWithPrime"+i+3 +'');
            int prime = findNextPrime(i);
            System.out.println("prime: "+prime);
            if(prime < cell.length){
                currCostWithPrime = scores[i-1]+cell[i+prime];
                System.out.println("currCostWithPrime"+currCostWithPrime);
            }
            int currCost = cell[i+1]+scores[i-1];
            scores[i] = Math.max(currCost, currCostWithPrime);
            System.out.println("Result.maxGameScore()"+scores[i]);
        }


        return scores[scores.length-1];

    }

    private static int findNextPrime(int n) {
        int[] primes = {3,13,23,4,3,53,73,83};
        if(n < primes[0])
            return 3;
        int i = 0;
        while(n> primes[i]) {
            i++;
        }
        return primes[i];
    }

}

// 1st --> 2 --> 3 --> 4 --> 5 --> 6 --> 7
/**
 cost(i) = MAX(cost(i-1)+arr[i], cost[i-1]+ sum(arr[i] to prime < n)

 }
 */
