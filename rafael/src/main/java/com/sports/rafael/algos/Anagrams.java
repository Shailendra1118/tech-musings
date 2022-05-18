package com.sports.rafael.algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

    //"aaaaaaaaaa"
    //"aaaaaaaaaaaaa"
    public static void main(String[] args) {
        Anagrams app = new Anagrams();
        String s = "ab";
        String p = "a";
        List<Integer> res = app.findAnagrams(s, p);
        System.out.println("Res: "+res);

        res = app.findAnagramsSliding(s, p);
        System.out.println("Res: "+res);

    }

    private List<Integer> findAnagramsSliding(String s, String p) {
        List<Integer> res = new ArrayList<>();
        /**
         * input validation and boundaries check are important
         */
        if(p.length() > s.length()) {
            return res;
        }
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        int i =0;
        int startedAt = 0;
        for (; i<p.length(); i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        if(sMap.equals(pMap)) {
            res.add(startedAt);
        }

        while (i < s.length()) {
            //Map<Character, Integer> tempMap = new HashMap<>();
            startedAt++;
            char sKey = s.charAt(i);
            sMap.put(sKey, sMap.getOrDefault(sKey, 0) + 1);
            char mKey = s.charAt(i - p.length());
            sMap.put(mKey, sMap.getOrDefault(mKey, 0) - 1);
            // if freq is zero remove entry
            if(sMap.get(mKey) < 1)
                sMap.remove(mKey);

            //check if equal for updated window
            if(sMap.equals(pMap)) {
                res.add(startedAt);
            }
            i++;
        }
        return res;
    }

    private List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> freqMap = new HashMap<>();

        for (Character c : p.toCharArray()) {
            if (freqMap.containsKey(c)) {
                freqMap.put(c, freqMap.get(c) + 1);
            } else
                freqMap.put(c, 1);
        }

        int i = 0;
        int j;
        int startedAt;
        while (i <= s.length() - p.length()) {
            startedAt = i;
            Map<Character, Integer> tempMap = new HashMap<>();
            j = i;
            while (j < startedAt + p.length()) {
                if (tempMap.containsKey(s.charAt(j))) {
                    tempMap.put(s.charAt(j), tempMap.get(s.charAt(j)) + 1);
                } else
                    //tempMap.put(s.charAt(j), tempMap.getOrDefault(s.charAt(j), 0) - 1);
                    tempMap.put(s.charAt(j), 1);
                j++;
            }
            //match both maps
            if (freqMap.equals(tempMap)) {
                res.add(startedAt);
            }
            i++;
        }
        return res;
    }



}
