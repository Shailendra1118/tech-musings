package com.sports.rafael.basics.collections;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

    }
}
