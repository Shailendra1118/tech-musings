package com.sports.rafael;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Functional {

    class myClass implements Function<Long, Long> {

        @Override
        public Long apply(Long aLong) {
            return aLong + 10;
        }
    }
    @Test
    public void defaultFunctional() {

        Long res = new myClass().apply(20L);
        System.out.println(res);

        // Function take single parameter and return single value
        Function<Long,String> adder = (val) -> (val + "100L");
        System.out.println(adder.apply(78L));

    }


    @Test
    public void testPredicate() {
        // predicate returns true and false
        Predicate pred = val -> val != null;
        System.out.println(pred.test(null));
        System.out.println(pred.test("Not a Null you see!"));

        // if predicate pass that means its test condition returns true - then true
    }

    @Test
    public void testUnaryOperator() {
        // operations that takes a single parameter and return parameter of the same type
        //UnaryOperator op = num -> num += 100; Object
        UnaryOperator<Integer> op = num -> num += 100;
        System.out.println(op.apply(99));

        //modifies that object, and returns it again <<Same Type>> -
        //  possibly as part of a functional stream processing chain.
    }

    @Test
    public void binaryOperator() {
        // Binary operator, take two parameter with just one type and returns same type
        BinaryOperator<String> op = (a, b) -> a+"-added "+ b+"-later-added";
        System.out.println(op.apply("Shailendra", "Singh"));
    }


    @Test
    public void SupplierTest() {
        //factory interface
        Supplier<Double> randomValueSupplier = () -> Double.valueOf(Math.random() * 100);
        //Supplier randomValueSupplier = () -> Math.random() * 100;
        System.out.println(randomValueSupplier.get());

        Supplier<Integer> supplier = () -> Integer.valueOf((int) (Math.random() * 100D));
        System.out.println(supplier.get());


        Supplier<List<String>> names = () -> List.of("Shailendra", "Aman", "Geetika", "Vinayak");
        names.get().forEach(System.out::println);
        String c = names.get().stream().map(s -> (s != "Geetika")? s+" Good boy": s+" Good Girl")
                .collect(Collectors.joining(","));
        System.out.println("Res: "+c);
    }

    @Test
    public void testConsumer() {
        // consume a value without returning anything
        Consumer<List<Integer>> con = (list) -> System.out.println(list);
        con.accept(List.of(100, 200 ,300, 400, 400));
    }


    @Test
    public void testComposition() {

        Predicate<String> notNull = val -> val != null;
        Predicate<String> notEmpty = val -> !val.isEmpty(); // Given String as Generics so isEmpty is visible
        Predicate notNullAndNotEmpty = notNull.and(notEmpty);
        if(notNullAndNotEmpty.negate().test(null)) {
            System.out.println("Passed");
        }else
            System.out.println("is Empty or Null");
    }


    @Test
    public void testCompositionAnother() {

        Function<Integer, Integer> add10 = val -> (val +10);
        Function<Integer, String> convertToText = val -> String.valueOf(val);
        Function<Integer, String> composed = add10.andThen(convertToText); // compose is opposite
        String res = composed.apply(9999);
        System.out.println("Composed result "+res);

    }
}
