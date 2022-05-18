package com.sports.rafael.ques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sprinkler {

    public static void main(String[] args) {

        List<String> list= Arrays.asList("a","b","c");
        System.out.println(list);

        String digits = "23";
        char arr[] = digits.toCharArray();
        //List<Character> li = Arrays.stream(arr).box



    }

    int getMinRadius(int[] houses, int[] sprinklers) {
        int i = 0, j = 0;
        int minRadius = 0;
        while (i < houses.length) {
            int currentDiff = Math.abs(sprinklers[j] - houses[i]);
            int nextDiff = Integer.MAX_VALUE;

            if (j < sprinklers.length-1) {
                nextDiff = Math.abs(sprinklers[j+1] - houses[i]);
            }

            if (currentDiff > nextDiff) {
                j++;
            }
            minRadius = Math.max(minRadius, Math.min(currentDiff, nextDiff));
            i++;
        }
        return minRadius;
    }


}
