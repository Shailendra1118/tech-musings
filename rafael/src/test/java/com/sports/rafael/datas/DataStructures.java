package com.sports.rafael.datas;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DataStructures {

    @Test
    public void testList() {
        List<Integer> list = new ArrayList<>();
        list.add(50);
        list.add(30);
        list.add(80);
        list.add(1, 99); //it will make the other element shift from here
        System.out.println(list);
    }
}
