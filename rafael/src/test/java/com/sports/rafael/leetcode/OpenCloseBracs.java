package com.sports.rafael.leetcode;

import java.util.ArrayList;
import java.util.List;

public class OpenCloseBracs {
    public static void main(String[] args) {
        int n = 3;
        //StringBuffer sb = new StringBuffer();
        List<String> list = new ArrayList<>();
        printAll(n, n, "", list);
        System.out.println(list);
    }

    private static void printAll(int open, int closed, String prefix, List<String> res) {
        if(open == 0 && closed == 0) {// open and closed should be both zero in a valid parentheses
            res.add(prefix);
            return;
        }
        if(open > 0)
            printAll(open-1, closed, prefix+"(", res); //send prefix appended with open bracket but when it returns
        // prefix should be with open bracket
        if(closed > open) // closed jyada bache hain
            printAll(open, closed-1, prefix+")", res);

    }
}
