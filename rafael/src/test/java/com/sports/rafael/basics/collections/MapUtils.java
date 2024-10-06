package com.sports.rafael.basics.collections;

import org.junit.jupiter.api.Test;

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
}
