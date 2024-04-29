package com.sports.rafael.pract;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CommonPrefix {

    @Test
    public void testIt() {
        String[] strings = {"flower", "fzona", "flight"};
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));
    }
}
