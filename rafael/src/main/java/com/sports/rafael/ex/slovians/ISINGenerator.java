package com.sports.rafael.ex.slovians;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ISINGenerator {

    /**
     * Algo to generate ISIN -
     * 1. Two Random Uppercase alphabet chars.
     * 2. 9 Random Alphanumeric chars.
     * 3. Check Digit calculation.
     *      a. Covert alphabet to number from lookup table
     *      b. Double the alternate digit starting from the right most digit
     *      c. calculate the sum for all the digits
     * @return
     */
    public String next() {

        return "a";
    }

    private static List<String> alphanumerics = Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
            "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
            "0","1","2","3","4","5","6","7","8","9");

    String getISINPrefix() {
        Optional<String> prefix = IntStream.range(0,2)
                .mapToObj(i -> getUpperCaseRandom())
                .reduce((a,b) -> {
                    System.out.println("a: "+a);
                    System.out.println("b: "+b);
                    return a+""+b;
                });
        if(prefix.isPresent())
            return prefix.get();
        return "";
    }

    String get9Alphanumerics() {
        Optional<String> alpha = IntStream.range(0,9).map(i -> ThreadLocalRandom.current().nextInt(0, 63))
                .mapToObj(index -> alphanumerics.get(index))
                .reduce((a,b) -> a+""+b);
        return alpha.isPresent() ? alpha.get() : "";

    }

    String getUpperCaseRandom() {
        int uppers = ThreadLocalRandom.current().nextInt(65, 91);
        char ascii = (char) uppers;
        return String.valueOf(ascii);
    }

    String getCheckDigit(String isinStr) {
        System.out.println("Input: "+isinStr);
        Stream<Integer> chars = isinStr.chars()
                .map(c -> {
                    System.out.println("input: "+Character.valueOf((char)c));
                    if(c >= 65 && c <= 90)
                        return c-'A'+10;
                    else if(c >=97 && c <= 122)
                        return c-'a'+10;
                    return Character.getNumericValue(c);
                }).mapToObj(ch ->
                {
                    Integer n = Integer.valueOf(ch);
                    System.out.println("Integer is n: "+n);
                    return n;
                });

        List<Integer> intsOnly = chars.collect(Collectors.toList());
        String reversedISIN = intsOnly.stream().map(n -> String.valueOf(n)).reduce((a,b)-> a+b).get();
        System.out.println("Reversed: "+reversedISIN);
        String[] reversedISINArr = reversedISIN.split("");
        for(int i=0; i<reversedISINArr.length; i++) {
            if(i%2 == 0) {
                Integer doubled = Integer.valueOf(reversedISINArr[i]) * 2;
                reversedISINArr[i] = String.valueOf(doubled);
            }
        }
        System.out.println("After alternative doubled: "+Arrays.toString(reversedISINArr));
        int digit = Arrays.stream(reversedISINArr).map(s -> Integer.valueOf(s)).reduce((a,b) -> a+b).get();
        System.out.println("digi: "+digit);
        return String.valueOf(digit%10);
    }


}
