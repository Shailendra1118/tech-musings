package com.sports.rafael;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Fiserv {

    public static void main(String[] args) {
        int a = 0x000F; //Hexadecimal numbers
        int b = 0x2222;
        System.out.println("a "+a);
        System.out.println("b "+b);
        System.out.println(a & b);

        //Octal
        a = 012;
        System.out.println(a);

        int output = new Fiserv().testException();
        System.out.println(output);

        List<Integer> list = new ArrayList<>();
        list.add(1,100);
        list.forEach(integer -> System.out.println(integer));
        list.remove(Integer.valueOf(1));

    }


    public int testException() {
        try{
            throw new IOException("IO error");
        }catch (RuntimeException e) {
            throw e;
        }finally {
            return -1;
        }
    }
}
