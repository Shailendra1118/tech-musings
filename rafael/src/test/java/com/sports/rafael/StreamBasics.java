package com.sports.rafael;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBasics {

    @Test
    public void testStreamBasic() {
        // listeners are attached to stream
        // gets to process each element in the stream, stream processing
        Stream<Integer> stream = List.of(10, 19, 4, 53, 23).stream();
        System.out.println(stream);

        // terminal operation - starts internal iteration, calling listeners and returns result.
        long count = 0;
        List<Integer> nList = stream.map(i -> i+1000)
                .map(i -> i+999)
                .collect(Collectors.toList());
        System.out.println("Count: "+count);
        System.out.println(nList);
        Stream.of(1, 2, 3, 4, 5)
                // map an element to another object
                .map(i-> String.valueOf(i)+" value").collect(Collectors.toList())
                .forEach(System.out::println);


    }


    @Test
    public void testPredicateFilter() {
        Stream.of("Shailendra", "Singh", "Yadav")
                .filter(s -> s != "Yadav")  //predicate inside filter should result into true
                // then only resulted stream will contain that element
                .collect(Collectors.toList()).forEach(System.out::println);

        // A ---> B mapping
        // Takes Function<T, R>

        // each element of the stream converted into a new stream

        // <R> Stream<R> map(Function<? super T,? extends R> mapper)
        // Generics fundamentals
        // R is type of new steam that is returned
        // Mapper Function takes T ===> as input ==> ? super T, as Consumer, stuffing items in of this type
        // PECS - Producer extends, Consumer Super
        // ? extends R ===> as output - elements will be only pulled from collection.




        // From client point of view, client of my library, methods
        // If they want to go through collection and do things with each item
            // then this is a producer Collection<? extends Thing> - can only hold any subtype of Thing
    }


    @Test
    public void testFlatMaps() {
        Stream.of(List.of("Shailendra", "Singh", "Yadav"), List.of("Anjani", "Sharan", "Yadav"))
                // if transformation has to be used (through map)
                // then first stream has to be flattened to something else
                .flatMap(List::stream)
                .map(s -> s+" adder")
                .forEach(System.out::println);

        // A --> Stream<B> concatenating
        // Takes Function<T,R> T = type with which stream can be built from
        // <R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)


    }

    @Test
    public void funStreams() {
        Stream.of(List.of("Shailendra", "Singh", "Yadav"), List.of("Anjani", "Sharan", "Yadav"), List.of("Abdul", "Kalam", "Azad"))
                //.map(l -> List.of(l.get(0), l.get(1)))
                //.flatMap(List::stream)
                // OR same as
                .flatMap(l -> {
                    System.out.println(l);
                    return List.of(l.get(0), l.get(1)).stream(); // mapper function produces multiple values for each input value
                }).forEach(System.out::println);

        System.out.println("Flatting...");
        Stream.of(List.of("Shailendra", "Singh", "Yadav"), List.of("Anjani", "Sharan", "Yadav"), List.of("Abdul", "Kalam", "Azad"))
                .flatMap(List::stream)
                .forEach(System.out::println);
    }


    @Test
    public void arrayToMap() {
        int arr[] = {1,2,3,4,5,6};
        //Arrays.stream(arr).boxed().collect(Collectors.toMap())
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

    }

    @Test
    public void testBinarySearch() {
        int arr [] = { 2, 4, 5, 6, 7, 8};
        int res = Arrays.binarySearch(arr, 0); // overridden method with range, to and from index
        System.out.println("Res: "+res);
    }
}
