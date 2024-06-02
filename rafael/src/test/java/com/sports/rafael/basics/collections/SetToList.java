package com.sports.rafael.basics.collections;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SetToList {
    @Test
    void initSet() {
        Set<String> set = Set.of("Aman", "Vinayak", "Jain Saab");
        List<String> list = set.stream().collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    void withInitStream() {
        List<String> list = Stream.of("Shailendra", "Goa", "Will", "Rock").collect(Collectors.toList());
        System.out.println(list);
        List<String> sortedList = list.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted: "+sortedList);
    }
}
