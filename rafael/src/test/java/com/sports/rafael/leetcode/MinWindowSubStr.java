package com.sports.rafael.leetcode;

public class MinWindowSubStr {

    public static void main(String[] args) {

        String source = "ADOBECODEBANC";
        String target = "ABC";

        int uniqueCount = 0;
        int[] map = new int[256]; //could use HashMap<Character,Integer> to keep track of frequency
        for(int i=0; i<target.length(); i++){
            if(map[target.charAt(i)] == 0)
                uniqueCount++;
            map[target.charAt(i)]++;
        }


        int i=0, j=0, res = source.length(), startIdx = 0;
        while(j < source.length()) {

            map[source.charAt(j)]--;
            if(map[source.charAt(j)] == 0)
                uniqueCount--;

            while(uniqueCount == 0) {
                //check first min window
                if(res > j-i+1) {
                    res = Math.min(res, j-i+1);
                    startIdx = i; //
                }
                //now shrink
                map[source.charAt(i)]++;
                if(map[source.charAt(i)] > 0)
                    uniqueCount++;
                //increment i
                i++;
            }

            //expand to right
            j++;
        }

        System.out.println(source.substring(startIdx, startIdx+res));

    }
}
