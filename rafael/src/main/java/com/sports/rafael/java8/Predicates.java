package com.sports.rafael.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Predicates {
    public static void main(String[] args) {
        String input = "This is a beautiful world";
        String[] arr = Arrays.stream(input.split(" "))
                .sorted(Comparator.comparingInt(String::length))
                .toArray(String[]::new);
        System.out.println("Arr: "+Arrays.toString(arr));

        List<String> friends = Arrays.asList("Bhaskar", "Manoj", "Pramod", "Pankaj");
        List<String> res = friends.stream().filter(startsWithVerbose.apply("M")).collect(Collectors.toList());
        System.out.println(res);

        Optional<String> longest = friends.stream()
                .sorted(Comparator.comparingInt(String::length)
                        .reversed()).findFirst();
        System.out.println("Longest: "+longest.get());
    }

    //Higher order function that returns as predicate
    public static Predicate<String> checkIfStartsWith(final String letter){
        return name -> name.startsWith(letter);
    }

    public static Function<String, Predicate<String>> startsWithLetter = letter -> name -> name.startsWith(letter);
    //Is equivalent to
    public static final Function<String, Predicate<String>> startsWithVerbose = (String letter) -> {
        Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
        return checkStarts;
    };
}


