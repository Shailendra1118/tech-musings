package com.sports.rafael.basics;

import org.junit.jupiter.api.Test;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class BullAndCow {

    @Test
    public void getHints() {
        String s1 = "3436"; //secret
        String s2 = "3563"; //guess
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        /*
            3 - 0,2
            4 - 1
            6 - 3

            0 - 3
            1 - 4
            2 - 5
            3 - 6
         */

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        for(int i=0; i<arr2.length; i++) {
            int val = arr1[i] ^ arr2[i];
            System.out.println(val);
        }
    }
}
