package com.sports.rafael.basics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Dell {

    @Test
    public void testStringToInteger() {
        String str = "00200";
        char[] chars = str.toCharArray();
        int res = 0;
        int multi = 1;
        //List<Integer> nums = new ArrayList<>();
        for(int i=chars.length-1; i>=0; i--) {
            int curr = chars[i]-'0';
            res = res + curr * multi;
            multi = multi * 10;
        }
        System.out.println(res);

    }
}
