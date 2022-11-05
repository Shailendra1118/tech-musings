package com.sports.rafael.algos;

import java.util.ArrayList;
import java.util.List;

public class PermuteString {
    public static void main(String[] args) {
        String str = "abcd";
        List<String> res = new ArrayList<>();
        permute(str.toCharArray(), res, 0 );
        System.out.println(res);
    }

    private static void permute(char[] str, List<String> res, int start) {
        //base case
        if(start >= str.length) {
            res.add(new String(str));
        }else{
            for(int i=start; i<str.length; i++) {
                swap(str, i, start);
                permute(str, res, start+1);
                swap(str, start, i);
            }
        }
    }

    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
