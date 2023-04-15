package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class FactorsFind {

    @Test
    public void testFactors() {
        Set<List<Integer>> res = new HashSet<>();
        int n = 12;
        int counter = n-1; //12 = 11
        while(counter > 0) {
            if(n%counter == 0) {
                List<Integer> factors = findFactors(n, counter, new ArrayList<>());
                Collections.sort(factors);
                res.add(factors);
            }

            counter--;
        }

        System.out.println(new ArrayList<>(res));
    }

    private List<Integer> findFactors(int num, int val, List<Integer> facts) {
        //base case
        if(val <= 1 || num == 1) {
            return facts;
        }

        if(num % val == 0) {
            facts.add(val);
            num = num/val;
        }else{
            val--;
        }
        facts = findFactors(num, val, facts);
        return facts;
    }
}
