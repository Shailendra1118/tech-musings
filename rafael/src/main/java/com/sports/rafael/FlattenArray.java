package com.sports.rafael;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlattenArray {

    public static void main(String[] args) {

       // [ [[[[4]], 5]], [[[2]]], 7, [[3], 9], [1] ];
        String str ="[[[[[4]], 5]], [[[2]]], 7, [[3], 9], [1]]";

        Object[] arr = new Object[]{1, 2, new Object[]{3, 4, new Object[]{5}, 6, 7}, 8, 9, 10};
        List<Object> list = new ArrayList<>(); //input

        Object obj = new ArrayList<>();
        Object o1 = Integer.valueOf(10);
        Object o2 = Integer.valueOf(20);
        List<Object> intList = (List) obj;
        intList.add(o1);
        intList.add(o2);

        Object outer = Integer.valueOf(30);

        Object obj1 = new ArrayList<>();
        Object obj2 = new ArrayList<>();
        Object obj3 = new ArrayList<>();
        Object o11 = Integer.valueOf(100);
        Object o21 = Integer.valueOf(201);
        List<Object> intList3 = (List) obj3;
        intList3.add(o11);
        intList3.add(o21);
        List<Object> intList2 = (List) obj2;
        intList2.add(intList3);
        List<Object> intList1 = (List) obj1;
        intList1.add(intList2);



        list.add(intList);
        list.add(outer);
        list.add(intList1);
        System.out.println("Input: "+list);


        List<Integer> output = new ArrayList<>();
        //parse(list, output);

        System.out.println("Output: "+output);

        System.out.println("Input Arr: "+ Arrays.deepToString(arr));
        Integer[] outputArr = new Integer[20];
        List<Integer> outList = new ArrayList<>();
        //parseObjectArray(arr, outList);
        System.out.println("Output List: "+outList);

        Object[] outArr1 = parseStream(arr).toArray();
        System.out.println(Arrays.toString(outArr1));

    }

    private static Stream<Object> parseStream(Object[] arr) {
        return Arrays.stream(arr).flatMap(o-> o instanceof Object[] ? parseStream((Object[]) o) : Stream.of(o));
    }

    private static void parseObjectArray(Object[] arr, List<Integer> list) {
        for(Object o: arr) {
            if(o.getClass().isArray()) {
                Object[] oArr = (Object[]) o;
                parseObjectArray(oArr, list);
            }else
                list.add((Integer)o);
        }

    }

    public static void parse(List<Object> objList, List<Integer> output) {
        for(Object o : objList) {
            if (o instanceof List) {
                List oList = (List) o;
                parse(oList, output);
            }
            else
                output.add((Integer) o);
        }

    }
}
