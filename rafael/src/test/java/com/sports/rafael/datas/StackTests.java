package com.sports.rafael.datas;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

public class StackTests {

    @Test
    public void testStackMethods() {
        Deque<String> deque = new LinkedList<>(); //Deque is an interface, extending Queue interface
        // push and pop methods are implemented by ArrayDeque class
        // LinkedList implemented push and pop
        deque.push("element");
        //System.out.println(deque.pop());
        deque.forEach(e -> System.out.println(e));
    }

    @Test
    public void testLL() {
        LinkedList<String> stack = new LinkedList<>();
        stack.push("element1");
        System.out.println(stack.peek());
        stack.forEach(e -> System.out.println(e));
    }
}
