package com.sports.rafael.algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlidingWin {
    public static void main(String[] args) {
        SlidingWin obj = new SlidingWin();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> res = obj.findAnagrams(s, p);
        System.out.println(res);
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> pMap = getFreqMap(p.toCharArray());
        int sLen = s.length();
        int pLen = p.length();

        int startId = 0;
        int endId = 0;
        Map<Character, Integer> sMap = new HashMap<>();
        char[] sArr = s.toCharArray();
        while (endId < pLen) {
            char ch = sArr[endId];
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
            endId++;
        }
        //startId++;
        endId--;

        while (startId < (sLen - pLen)) {
            if (sMap.equals(pMap)) {
                res.add(startId);
            }
            char oldC = sArr[startId];
            char newC = sArr[endId + 1];
            sMap.put(oldC, sMap.get(oldC) - 1);
            if(sMap.get(oldC) == 0) {
                sMap.remove(oldC);
            }
            sMap.put(newC, sMap.getOrDefault(newC, 0) + 1);

            startId++;
            endId++;
        }

        if (sMap.equals(pMap)) {
            res.add(startId);
        }
        return res;
    }

    private Map<Character, Integer> getFreqMap(char[] arr) {
        //char[] arr = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
