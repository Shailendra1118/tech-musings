package com.sports.rafael;

import org.junit.jupiter.api.Test;

public class BitManipulation {


    @Test
    public void testShift() {

        int val = 10 << 2;
        System.out.println("Value: "+val);

        System.out.println(10 >> 2);
    }
}
