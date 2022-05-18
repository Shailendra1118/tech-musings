package com.sports.rafael.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Examples {

    public static void main(String[] args) {


        testBrackets();

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(100);
        //list.forEach(i -> System.out.println(i));

        int arr[] = {1,2,3,4};
        List<Integer> intList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(intList);

        list.forEach(new Consumer<Integer>(){
            @Override
            public void accept(Integer integer) {
                System.out.println("Accepted integer is: "+integer);
            }
        });

    }

    private static void testBrackets() {

        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        char[] arr = "({}{[]})".toCharArray();
        Stack<Character> stack = new Stack<>();

        boolean isValid = true;
        for(int i=0; i<arr.length; i++) {
            if(map.containsKey(arr[i]) && !stack.isEmpty()) { // its closing bracket
                if(stack.peek() == map.get(arr[i])) {
                    stack.pop();
                }else
                    break;
            }else{
                //opening bracket
                stack.push(arr[i]);
            }
        }


        System.out.println("valid: "+stack.isEmpty());
    }


    interface ExClass {
        default void method1(){
            System.out.println("it is default method");
        }

        default void printIt(String param){
            System.out.println("printing..."+param);
        }

        void printWithoutImpl();

        // Object class method can't be override as default method
        // In an object hirarchy, default method in down the order will not be used, unnecessary so its compile time error
        /* default String toString() {
            System.out.println("This is overriding...");
        } */

        // method1 is already defined as default method
        /*static void method1(){
            System.out.println("static method with same name as default");
        } */
    }


}
