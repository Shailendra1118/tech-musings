package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class VariableNames {

    public static void main(String[] args) {
        String var1 = "myVariableNameIsThis";
        String var2 = "my_variable_name_is_this";
        String var3 = "myVariable_name_isThis";
        String var4 = "_nameIsVariable";
        String var5 = "compositeKeyIs";

        String input = var5;
        if(input.indexOf('_') != -1) {
            System.out.println(input+" is C++, converting to java var...");
            convertToJava(input);
        }else{
            convertToCpp(input);
        }
    }

    // first approach
    private static void convertToCpp(String input) {
        boolean makeUpperCase = false;
        char arr[] = input.toCharArray();
        List<Character> list = new ArrayList<>();
        int index =0;
        for(;index<arr.length; index++) {
            if (Character.isUpperCase(arr[index])) {
                list.add('_');
                list.add(Character.toLowerCase(arr[index]));
            } else{
                //keep on adding
                list.add(arr[index]);
            }
        }

        StringBuilder sb = new StringBuilder();
        list.forEach(c -> sb.append(c));
        System.out.println(sb.toString());

    }

    private static void convertToJava(String input) {
        boolean makeUpperCase = false;
        char arr[] = input.toCharArray();
        List<Character> list = new ArrayList<>();
        int index = 0;
        if(arr[0] == '_')
            index++;

        for(; index<arr.length; index++) {
            if(arr[index] == '_') {
                makeUpperCase = true;
            } else {
                if(makeUpperCase) {
                    list.add(Character.toUpperCase(arr[index]));
                    makeUpperCase =false;
                } else {
                    list.add(arr[index]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        list.forEach(c -> sb.append(c));
        System.out.println(sb.toString());
    }

    @Test
    public void testCharInt() {
        char c = 'c';
        char d = (char)((int)c+1);
        System.out.println("C: "+c);
        System.out.println("D: "+d);
    }

}
