package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConversionMany {

    @Test
    public void convertListToArray() {
        List<Integer> list = Arrays.asList(100, 23, 20, 231, 87); //new ArrayList(); Java 8
        list = List.of(199, 87, 9, 87, 29); // Java 11 onwards

        Integer[] arr = list.stream().toArray(Integer[] ::new);
        arr = list.toArray(Integer[]::new);
        List<Integer> tempList = new ArrayList<>();
        Integer[] temp = tempList.toArray(new Integer[tempList.size()]);
        System.out.println("Temp:: "+temp);
        System.out.println(arr); // Integer[] object = [Ljava.lang.Integer;@60a4e70
        System.out.print(Arrays.toString(arr));
        Arrays.stream(arr).forEach(System.out::print);
    }

    @Test
    public void IntegerListToIntegerArray() {

    }

    @Test
    public void listToIntArray() {
        List<Integer> list = List.of(199, 87, 9, 87, 29); // Java 11 onwards
        int arr[] = list.stream().mapToInt(Integer::intValue).toArray();

        System.out.println(Arrays.toString(arr));

        Arrays.stream(arr).forEach(System.out::println);
    }

    @Test
    public void IntArrayToList() {
        int arr[] = {29, 8, 89, 23, 23};
        List<Integer> list = new ArrayList();
        Arrays.stream(arr).forEach(e -> list.add(e)); // if add to existing list
        List<Integer> temp = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println("New List: "+temp);
        System.out.println(list);
    }

    @Test
    public void IntegerArrayToList() {
       Integer[] arr = {23, 8, 230, 82};
       Arrays.stream(arr).collect(Collectors.toList()).forEach(System.out::println);
    }

    @Test
    public void intArrayToIntegerArray() {
        int arr[] = {29, 8, 89, 23, 23};
        Integer[] temp = new Integer[arr.length];
        Arrays.setAll(temp, i -> arr[i]); // internally does the same thing like populating in for loop
        System.out.println(Arrays.toString(temp));

        Integer[] temp1 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        // OR
        temp1 = IntStream.of(arr).boxed().toArray(Integer[]:: new);
        System.out.println(Arrays.toString(temp1));

    }

    @Test
    public void IntegerToIntArray() {
        Integer[] arr = {23, 9, 78, 2, 34, 11};
        int temp[] = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
        System.out.println(temp); //[I@5e84f35f
        System.out.println(Arrays.toString(temp));

    }


    @Test
    public void IntegerSum() {
        Integer[] arr = {23, 9, 78, 2, 34, 11};
        int sum = Arrays.stream(arr).reduce(0, Integer::sum);
        System.out.println("sum: "+sum);

        sum = Arrays.stream(arr).collect(Collectors.summingInt(Integer::intValue));
        Arrays.stream(arr).mapToInt(Integer::intValue).sum();

        int temp1[] = {2, 2, 3, 4,};
        int sum2 = Arrays.stream(temp1).sum();
        System.out.println("sum2: "+sum2);
        System.out.println("sum1: "+sum);

        double avg = Arrays.stream(temp1).average().getAsDouble();
        System.out.println("Avg: "+avg);
    }
}
