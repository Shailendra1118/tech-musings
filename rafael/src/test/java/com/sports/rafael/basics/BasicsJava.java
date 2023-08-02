package com.sports.rafael.basics;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class BasicsJava {

    @Test
    public void testSet12() {
        HashSet<Integer> set = new HashSet();
        int a = 100;
        set.remove(a);
        System.out.println("Hello");

        Math.random();
        List<Integer> list = new Random().ints(10 ,20)
                .boxed().collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void testStream() {
        int[] cur = {12,3,4,5,5};
        List<Integer> list = new ArrayList<>();
        Arrays.stream(cur).forEach(val -> list.add(val));
        list.add(cur.length);
        System.out.println(list);
    }

    @Test
    public void testRegex() {
        List<String> notes = new ArrayList<>();
        notes.add("This is new CHG not required");
        notes.add("CHG1234456 is create now, hurrey, is new CHG not required");
        notes.add("CHG is not in valid format");
        notes.add("CHG is created and link is CHG1234556");

        List<String> filtered = notes.stream().filter(note -> note.matches("valid"))
                .collect(Collectors.toList());
        System.out.println(filtered);

        List<Optional<String>> list = new ArrayList<>();
        list.add(Optional.of("Hello"));
        list.add(Optional.of("Hello There"));
        list.add(Optional.empty());
        list.add(Optional.empty());

       Optional<String> list1 = list.stream().filter(s -> s.isPresent()).findFirst().get();
        System.out.println(list1.get());
    }

    @Test
    public void testSplit() {
        String str = "/a/b/c";
        System.out.println(Arrays.toString(str.split("/")));
    }
}
