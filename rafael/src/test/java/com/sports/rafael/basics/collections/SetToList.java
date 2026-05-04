package com.sports.rafael.basics.collections;

import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Test
    void testArrayListToSet() {
        Set<String> set = Set.of("One", "Two","Three");
        List<String> res = new ArrayList<>(set);
        System.out.println(res);

        List<Integer> list = List.of(1,3,4,5);
        List<Integer> listA = Arrays.asList(1,2,4,5);
        System.out.println(listA);

        List<List<Integer>> resList = new ArrayList<>();
        resList.add(Arrays.asList(1,2,3));
        resList.add(Arrays.asList(100,200,300));

        int[][] twoDArray; // = new int[resList.size()][];
        twoDArray = resList.stream().map(xlist -> xlist.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
        System.out.println(Arrays.deepToString(twoDArray));

    }

}
