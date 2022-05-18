package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Roman {

    @Test
    public void testLargest(){
        int nums[] = {3, 30, 34, 5, 9};
        StringBuilder sb = new StringBuilder();
        for(int num : nums){
            sb.append(num);
        }
        System.out.println("String input: "+sb.toString());

        char arr[] = sb.toString().toCharArray();
        Integer[] array = new Integer[arr.length];
        int i=0;
        for(char c : arr){
            array[i++] = Integer.parseInt(String.valueOf(c));
        }
       // Integer[] array = IntStream.generate(arr);
        Arrays.sort(array, Collections.reverseOrder());

        sb.setLength(0);
        for(int num : array){
            sb.append(num);
        }
        System.out.println(sb.toString());
    }


    @Test
    public void largestNumber() {

        Integer arr[] = {3,30,34,5,9};
        System.out.println("Before sort...");
        Arrays.stream(arr).forEach(System.out::println);
        Arrays.sort(arr, (o1, o2) -> {
            String a = o1 + String.valueOf(o2);
            String b = o2 + String.valueOf(o1);
            Integer x = Integer.parseInt(a);
            Integer y = Integer.parseInt(b);

            if(x < y)
                return +1;
            else if(x > y)
                return -1;
            return 0;
        });
        System.out.println("After sort...");
        Arrays.stream(arr).forEach(System.out::println);

        String res = Arrays.stream(arr).map(Object::toString).collect(Collectors.joining(""));
        System.out.println("Res: "+res);


    }

    @Test
    public void sortAgain() {

        int nums[] = {3,30,34,5,9};
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, (a, b) -> (String.valueOf(b) + a)
                .compareTo(String.valueOf(a) + b));

        /*
        Arrays.sort(arr, (o1, o2) -> {
            String a = o1 + String.valueOf(o2);
            String b = o2 + String.valueOf(o1);
            Integer f = Integer.parseInt(a);
            Integer s = Integer.parseInt(b);
            if(f < s)
                return 1;
            else if(f > s)
                return -1;
            else
                return 0;
        });

         */

        int res[] = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(res));

        Integer res1 = Arrays.stream(arr).reduce((x,y) -> x.equals(0)? y : x+y).get();
        System.out.println(res1);

    }


}



