package com.sports.rafael;

import com.sports.rafael.ex.slovians.HelloFresh;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelloFreshTests {

    @Test
    public void testAllPositives() {
        HelloFresh hf = new HelloFresh();
        int input[] = {9,5,7,1};
        int res = hf.getMaxSum(input);
        assertTrue(res == 22);
    }

    @Test
    public void testEmptyInput() {
        HelloFresh hf = new HelloFresh();
        int input[] = {};
        int res = hf.getMaxSum(input);
        assertTrue(res == 0);
    }

    @Test
    public void testNullInput() {
        HelloFresh hf = new HelloFresh();
        int input[] = null;
        int res = hf.getMaxSum(input);
        assertTrue(res == 0);
    }

    @Test
    public void testWithLargeInputT() {
        HelloFresh hf = new HelloFresh();
        int input[] = {Integer.MAX_VALUE, Integer.MAX_VALUE, -11119347, 38, 8, 98734, Integer.MAX_VALUE, 4, 8, -4,};
        int res = hf.getMaxSum(input);
        assertFalse(res == Integer.MAX_VALUE+Integer.MAX_VALUE);
    }


    @Test
    public void tChar(){
        Deque<Character> deq = new LinkedList();
        deq.push('c');
        deq.push('m');
        System.out.println(deq.peek().equals(Character.valueOf('m')));
        System.out.println(deq.peek() == 'm');

       // List<Integer> list = new ArrayList<>();
        //list.set(0, 100);
        //System.out.println(list);

       // list.toArray(new Integer[0]);

//        List<String> l2 = "A->B".chars().filter(c-> Character.isAlphabetic(c))
//                .mapToObj(c -> String.valueOf(c))
//                .collect(Collectors.toList());
//        System.out.println(l2);
        String extract = "a->b".replaceAll("[^a-zA-Z]+", "");
        System.out.println(extract);
    }

    @Test
    public void testCollect() {
        Map<Integer,char[]> map = new HashMap<>();
        map.put(2, new char[]{'a','b','c'});
        map.put(3, new char[]{'d','e','f'});
        map.put(4, new char[]{'g','h','i'});
        map.put(5, new char[]{'j','k','l'});
        map.put(6, new char[]{'m','n','o'});
        map.put(7, new char[]{'p','q','r','s'});
        map.put(8, new char[]{'t','u','v'});
        map.put(9, new char[]{'w','x','y','z'});

        System.out.println(map.get(5));
        char[] tmep = map.get(7);
        System.out.println(tmep);
        // one way --> tmep.toString().chars().mapToObj(c -> String.valueOf(c)).collect(Collectors.toList());
        List<String> list = new ArrayList<>();
        Stream.of(tmep).forEach(arr -> System.out.println("Our:: "+Arrays.toString(arr)));
        //int[] arr = {1,2,4,5};
        //List<String> res = Arrays.stream(arr).mapToObj(n -> String.valueOf(n)).collect(Collectors.toList());
        //System.out.println(res);

        Map<Integer,String> map1 = new HashMap<>();
        map1.put(2, "abc");
        map1.put(3, "def");
        map1.put(4, "ghi");
        map1.put(5, "jkl");
        map1.put(6, "mno");
        map1.put(7, "pqrs");
        map1.put(8, "tuv");
        map1.put(9, "wxyz");

        map1.get(2).chars().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.toList()).forEach(str -> System.out.println(str));


    }

}
