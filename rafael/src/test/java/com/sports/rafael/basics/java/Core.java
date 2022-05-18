package com.sports.rafael.basics.java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Core {

    @Test
    public void testIterator() {
        List<StringBuilder> list = new ArrayList<>();
        StringBuilder sb1 = new StringBuilder("Java");
        StringBuilder sb2 = new StringBuilder("Python");
        StringBuilder sb3 = new StringBuilder("Scala");
        StringBuilder sb4 = new StringBuilder("Angular");
        list.add(sb1);
        list.add(sb2);
        list.add(sb3);
        list.add(sb4);
        list.remove(1);

        //for(StringBuilder sb : list) {
        //    System.out.println(sb);
            //list.remove(sb3); // ConcurrentModificationException
        //}
        for(StringBuilder sb : list)
            System.out.println(sb);
        list.remove(sb3);
        list.remove(new StringBuilder("Angular"));

        System.out.println("-----");
        for(StringBuilder sb : list)
            System.out.println(sb);

    }


    @Test
    public void nullCheck() {

        System.out.println(testMethod("Shailendra"));
        System.out.println(testMethod("Singh"));
        System.out.println(testMethod(null));

        //Unary operator
        int i = 10;
        testMethod1(i++);
        System.out.println("i after the call: "+i);

        System.out.println("Pre-increment ---");
        testMethod1(++i);
        System.out.println("i after the call: "+i);

        int j = 100;
        System.out.println("From testMethod2:"+ testMethod2(j++));

    }

    private boolean testMethod(String str) {
        try{
            return str.length() > 5;
        }catch(NullPointerException npe) {
            System.out.println("NPE !!");
            return false;
        }
    }

    private void testMethod1(int i) {
        System.out.println("Got i: "+i);

    }

    private int testMethod2(int i) {
        System.out.println("testMethod2: "+i);
        return i++;
    }


    @Test
    public void checkMaps() {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        map1.put('c', 1);
        map1.put('d', 2);

        map2.put('c', 1);
        map2.put('d', 2);
        String str = "Shailendra";
        for(char ch : str.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0)+1);
        }
        System.out.println(map2);
        System.out.println(map1.equals(map2));

        int arr1[] = new int[10];
        int arr2[] = new int[10];
        System.out.println("Array equal....");
        arr1[0] = 1;
        arr1[1] = 2;
        arr2[0] = 1;
        arr2[1] = 3;
        System.out.println(arr1.equals(arr2));
        System.out.println(matches(arr1, arr2));


    }

    private boolean matches(int s1Map[], int s2Map[]) {
        for(int i=0; i<s1Map.length; i++) {
            if(s1Map[i] != s2Map[i])
                return false;
        }
        return true;
    }

    @Test
    public void twoDArray() {
        int intervals[][] = {{1,4}, {3,6}, {2,8}};
        System.out.println(intervals[0][0]);
        //Integer[] intObj = Arrays.stream(interval).boxed().toArray(Integer[] :: new);
        //intObj = IntStream.of(interval).boxed().toArray(Integer[] :: new);

        Arrays.sort(intervals, (a, b) -> {
            if(a[0] < b[0]) {
                return -1;
            }else if(a[0] > b[0])
                return +1;
            else
                return 0;
        });
        for(int arr[] : intervals)
            System.out.println(Arrays.toString(arr));

        int updated = 0;
        for(int i=0; i<intervals.length-1; i++) {
            if(intervals[i+1][1] <= intervals[i][1]) {
                updated++;
                intervals[i+1][1] = intervals[i][1];
                intervals[i+1][0] = intervals[i][0];
            }
        }
        System.out.println("Updated :: "+updated);
    }
}
