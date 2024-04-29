package com.sports.rafael.geeks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GCDStrings {

    public static void main(String[] args) {
        GCDStrings caller = new GCDStrings();
        String str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX";
        String str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        String output = caller.gcdOfStrings(str1, str2);
        System.out.println("Res: "+output);
        int[] arr = {1,4,5};
    }

    public String gcdOfStrings(String str1, String str2) {
        Set<Character> set = new HashSet<>();
        int len1 = str1.length();
        int len2 = str2.length();
        int i=0,j=0;
        StringBuilder sb = new StringBuilder();
        while(i < len1 && j < len2) {
            if(str1.charAt(i) != str2.charAt(j)) {
                return "";
            }else {
                if(!set.contains(str1.charAt(i))) {
                    set.add(str1.charAt(i));
                    sb.append(str1.charAt(i));
                }
            }
            i++;
            j++;
        }

        String res = sb.toString();
        if(i < len1) {
            //String remaining = str1.substring(i);
            while(i < len1) {
                int end = i + res.length();
                if (end > len1) {
                    return "";
                }
                String temp = str1.substring(i, i+res.length());
                if(!temp.equals(res)) {
                    return "";
                }
                //pick next block
                i += res.length();
            }
        }

        if(j < len2) {
            //String remaining = str2.substring(j);
            while(j < len2) {
                int end = j + res.length();
                if (end > len2) {
                    return "";
                }
                String temp = str2.substring(j, j+res.length());
                if(!temp.equals(res)) {
                    return "";
                }
                //pick next block
                j += res.length();
            }
        }
        return res;
    }
}
