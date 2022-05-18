package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

public class StringManipulations {


    @Test
    public void exampleOfValueOf() {

        String s = "HoldMyBeer";
        String res = String.valueOf(s.toCharArray(), 4, 2);
        System.out.println(res);

    }
}
