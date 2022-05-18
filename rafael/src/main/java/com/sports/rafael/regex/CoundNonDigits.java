package com.sports.rafael.regex;

import java.util.Arrays;

public class CoundNonDigits {

    public static void main(String[] args) {
        String str = "abc12asdf01sdf001asdflk989sdf97sdf002sdsf000002sdfsf00000002";
        String[] arr = str.split("\\D");
        for(String s : arr){
            s = s.trim();
            if(!s.equals("")){
                s = s.replaceAll("0*", ""); //replace take char, replaceAll() takes string(more than one char)
                System.out.println("Post replace: "+s);
            }
        }
        System.out.println(Arrays.toString(arr));


        // ^ starts with
        // n* matching zero to more occurranc like n, nn, nnn...

    }
}
