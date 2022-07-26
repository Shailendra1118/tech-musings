package com.sports.rafael.java8;

import java.util.List;

public class TestClass<T> {

    static int counter = 0;
    //static T obj; Can not declare static generic type variable
    public void printList(List<T> list) {
        for(T e : list)
            System.out.println(e);
    }
}
