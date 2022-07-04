package com.sports.rafael;

import java.util.stream.Stream;

public class LambdaMagic {

    public static void main(String[] args) {
        Xtream[] arr = Stream.generate(() -> {
            Xtream o = new Xtream();
            o.name = "streamSample";
            return o;
                }).limit(10)
                .toArray(Xtream[]::new); //will give OOM Error-Heap Space without limit
        System.out.println(arr.getClass().getCanonicalName());
    }
}

class Xtream {
    String name;
    int size;
}
