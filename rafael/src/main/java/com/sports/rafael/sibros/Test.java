package com.sports.rafael.sibros;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        char arr1[] = {'A', 'B', 'B', 'A', 'C', 'A', 'A', 'C', 'B'};
        char arr[] = {'A', 'B', 'C', 'A', 'C'};

        int res = findMaxDistinctive(arr);
        System.out.println(res);
    }

    private static int findMaxDistinctive(char[] arr) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i =0;
        int j= i+1;
        map.put(arr[i], 1);

        while(i< j && j< arr.length){
            int curMax = map.size();

            while(map.size() <= 2 && j < arr.length){
                map.put(arr[j], map.getOrDefault(arr[j]+1, 0));
                curMax++;
                j++;
            }

            if(curMax > max)
                max = curMax;

            while(map.size() > 2 && i < j){
                map.put(arr[i], map.getOrDefault(arr[i]-1, 0));
                i++;

                if(map.get(arr[i]) == 0){
                    map.remove(arr[i]);
                }
            }

        }


        return max;
    }
}
