package com.sports.rafael.basics.java.streams;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicsFunc {

    @Test
    public void shortCircuiting() {
        Stream<Integer> stream = Stream.iterate(2, i->i*2);
        List<Integer> list = stream.skip(2).limit(10).collect(Collectors.toList());
        list.forEach(n -> System.out.println(n));
    }
}
