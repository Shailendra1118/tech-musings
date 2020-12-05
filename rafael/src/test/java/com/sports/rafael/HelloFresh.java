package com.sports.rafael;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class HelloFresh {

    public static void main(String[] args) {
        String str = "Sorting12345";
        // no validation required
        // Thinking should be clear -> coherent -> in the same direction w/o jumping from solutions midway
        // remember its all ascii chars
        StringBuilder lowers = new StringBuilder(str.length()); // default capacity is 16 chars
        StringBuilder uppers = new StringBuilder(str.length());
        StringBuilder odds = new StringBuilder(str.length());
        StringBuilder evens = new StringBuilder(str.length());
        // can work with chars only, no need to expensive boxing-unboxing
        char arr[] = str.toCharArray();
        Arrays.sort(arr);

        for(char c : arr){
            if(c >=97 && c <= 122){
                lowers.append(c);
            }else if(c >=65 && c <= 90){
                uppers.append(c);
            }else if(c >= 48 && c <= 57){
                if(c % 2 == 0){
                    evens.append(c);
                }else
                    odds.append(c);
            }
        }

       String output = lowers.append(uppers).append(odds).append(evens).toString();
        System.out.println(output);

    }


    @Test
    public void testStr(){
        HelloFresh hf = new HelloFresh();

    }

    @Test
    public void testTree() {
        TreeSet set = new TreeSet();
        set.add("A");
        set.add("B");
        set.add("A");
        System.out.println(set);
    }
}
