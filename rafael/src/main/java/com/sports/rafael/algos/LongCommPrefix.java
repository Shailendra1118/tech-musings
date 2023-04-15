package com.sports.rafael.algos;

public class LongCommPrefix {

    public static void main(String[] args) {
        String[] arr = {"d","dog","dogma",};
        int maxSize = findMaxSize(arr);
        String prefix = "";
        for(int i=0; i<maxSize; i++) {
            //iterator till max length of string
            if(i >= arr[0].length()) {
                break;
            }

            char currChar = arr[0].charAt(i);
            boolean notMatched = false;
            for(int j=1; j<arr.length; j++) {
                if (arr[j].length() <= i || arr[j].charAt(i) != currChar) {
                    notMatched = true;
                    break;
                }
            }
            if(notMatched)
                break;
            prefix = prefix + currChar;
        }
        System.out.println("LCP: "+prefix);
    }

    private static int findMaxSize(String[] arr) {
        int maxTillNow = arr[0].length();
        for(int i=1; i<arr.length; i++) {
            if(arr[i].length() > maxTillNow) {
                maxTillNow = arr[i].length();
            }
        }
        return maxTillNow;
    }
}
