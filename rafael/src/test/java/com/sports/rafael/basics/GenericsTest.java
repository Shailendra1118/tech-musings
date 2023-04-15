package com.sports.rafael.basics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsTest {

    @Test
    public void testConstructor() {
        List<Number> list = new ArrayList<>();
        //list.add(new Integer(10));
        //list.add(new Double(10d)); deprecated
        list.add(Integer.valueOf(10));
        list.add(Double.valueOf(239d));
        //It is all good
        for(Number n : list)
            System.out.println(n);
    }


    @Test
    public void testWildCard() {
        List<?> list = new ArrayList<>();
        //list.add(Integer.valueOf(10)); you can only insert null in List<?>
        List<Integer> lInt = Arrays.asList(1,2,3);
        printList(lInt);

    }

    private void printList(List<?> list) {
        for(Object obj : list)
            System.out.print(obj+" ");
    }


}
