package com.sports.rafael.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountGoodSubArray {

    public static void main(String[] args) {
        int[] arr = {1,2,1,2,3};
        int k = 2;

        int res = countGood(arr, k);
        System.out.println("Res: "+res);
    }

    private static int countGood(int[] arr, int k) {
        Window win1 = new Window();
        Window win2 = new Window();

        int res = 0, left1 = 0, left2 = 0, right = 0;
        while(right < arr.length) {

            win1.add(arr[right]);
            win2.add(arr[right]);

            //while bcoz loop
            while(win1.getDifferent() > k) {
                win1.remove(arr[left1]);
                left1++;
            }
            while(win2.getDifferent() >= k) {
                win2.remove(arr[left2]);
                left2++;
            }

            res = res + left2-left1;

            right++;
        }

        return res;

    }

    static class Window {
        Map<Integer, Integer> countMap = new HashMap<>();
        int distinct = 0;

        public void add(int x){
            countMap.put(x, countMap.getOrDefault(x, 0)+1);
            if(countMap.get(x) == 1) //single element left
                distinct++;
        }

        public void remove(int x) {
            countMap.put(x, countMap.get(x)-1);
            if(countMap.get(x) == 0)
                distinct--;
        }

        public int getDifferent() {
            return distinct;
        }
    }
}
