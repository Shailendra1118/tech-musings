package com.sports.rafael.basics.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.parameters.P;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapUtils {
    @Test
    void testInit() {
        //Of functions give Immutable Map and Set
        Map<String, Integer> map = Map.of("Shailendra", 10,
                "Singh", 100,
                "Aman", 99,
                "Jain Saab", 144);
        System.out.println(map);
        //map.put("Aman", 99); Compilation error
        //map.put("Jain Saab", 144);

        Map<String,Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));

        //map.entrySet().stream().
        System.out.println(sortedMap);

        sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByKey().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap:: new));
        System.out.println("default: "+sortedMap);

    }

    @Test
    void testReverse() {
        int[] arr = {1,2,3,4,5};
        //Collections.reverse(Arrays.asList(arr));
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.reverse(list);
        System.out.println("List: "+list);

        //Arrays.stream(arr).map()


        Integer[] intArray = {1,2,4,45,5};
        Collections.reverse(Arrays.asList(intArray));

        System.out.println(Arrays.toString(arr));
        int[] reversed = IntStream.range(0, arr.length).map(i -> arr[arr.length-i-1]).toArray();
        System.out.println(Arrays.toString(reversed));
    }

    @Test
    void testMapKeys() {
        Map<String,Integer> map = new HashMap<>();
        map.put("Soham", 100);
        map.put("Soorya", 200);
        Set<String> oldKeys = map.keySet();
        System.out.println("Old keys: "+oldKeys);

        map.put("Aman", 300);
        System.out.println("After adding new: "+oldKeys);

    }

    @Test
    void testReverseNumber() {
        int input = 1009;
        int rev = getReverse(input);
        System.out.println("Output: "+ rev);
        Assertions.assertTrue(rev == 9001);
    }

    private int getReverse(int input) {
        int rev = 0, rem = 0;
        while (input > 0) {
            rem = input % 10;
            rev = (rev * 10) + rem;
            input = input/10;
        }
        return rev;
    }

    private void method1(List<Integer> list) {
        //list = new ArrayList<>();
        list.add(500);
    }
    @Test
    void testListReference() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);

        method1(list);
        System.out.println(list);
    }
}
