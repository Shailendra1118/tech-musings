package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class IPAddress {

    @Test
    void printValidIPAddress() {
        String input = "101023";
        List<String> res = restoreIpAddresses(input);
        System.out.println(res);
    }

    private List<String> restoreIpAddresses(String str) {
        List<String> res = new ArrayList<>();
        ipAddr(str, 3);


        return res;
    }

    private void ipAddr(String str, int dots) {


    }
}
