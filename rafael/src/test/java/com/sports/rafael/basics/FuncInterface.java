package com.sports.rafael.basics;

import org.junit.jupiter.api.Test;
import org.springframework.jmx.export.metadata.JmxMetadataUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

public class FuncInterface {
    @Test
    void testSupplier() {
        //deferred execution and
        // dynamic value generation
        // Lazy initialization, init values on first request
        // create dependency on demand
        Supplier<String> supplier = () -> "This is supplied text"; //has just single method get()
        System.out.println(supplier.get());

        String res = doSomething("Input string", supplier);
        System.out.println("Res:"+ res);
    }

    String doSomething(String input, Supplier supplier) {
        return new StringBuilder().append(input).append("**").append(supplier.get()).toString();
    }

    @Test
    void testAnotherUseCaseSupplier() {
        //delay the computation or retrieval of a value until it is actually needed.
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println(randomSupplier.get());
        System.out.println(randomSupplier.get());
    }

    @Test
    void testLoggingScenario() {
        Logger logger = new Logger(false);
        Supplier supplier = () -> expensiveText();
        logger.debug("Something happened", supplier);

    }

    class Logger {
        private boolean isDebugEnabled;

        public Logger(boolean isDebugEnabled) {
            this.isDebugEnabled = isDebugEnabled;
        }

        public void debug(String msg, Supplier<Integer> messageExtender) {
            if (isDebugEnabled) {
                //do expensive and dynamic computation
                System.out.println(messageExtender.get()+":"+msg);
            }
            System.out.println("Plain:"+ msg);
        }

    }

    public static String expensiveText() {
        return "XXXX computation heavy test";
    }

    @Test
    void testConsumer() {
        //Why consumer
        // define operation to be passed around and execute later
        // pass piece of logic as a parameter in functional programming
        processString("This is input", System.out::println);

        Stream.of(1,2,3,4,4).forEach(n -> System.out.println());
        // forEach expect a consumer function

    }

    void processString(String input, Consumer<String> consumer) {
        consumer.accept(input);

    }

    @Test
    void testBiConsumer() {
        //encapsulate the operation where two input are provided
        BiConsumer<String, String> consumer = (k, v) -> System.out.println(k+" ## "+v);
        consumer.accept("Shailendra", "Singh");

        List<Integer> list1 = List.of(100, 200, 300);
        List<Integer> list2 = Arrays.asList(1,2,3,4);

        list1.forEach(n -> list2.stream().forEach(s -> System.out.println(n+"::"+s)));

        //Use in ForEach, collect, peek etc in stream APIs
    }

    @Test
    void testFunctions() {
        //function accept a parameter and return a result
        // apply(input) method only
        BiFunction<String, String, Integer> calculator = (s1, s2) -> s1.length()+s2.length();

        Integer res = calculator.apply("Shailendra", "Singh");
        System.out.println("Res: "+res);
    }

    @Test
    void testPredicate() {
        Predicate<String> checker = (c) -> c.length() > 10;

        String input = "Shailendra singh yadav";
        if (checker.test(input)) {
            System.out.println("Very long string");
        }
    }

    @Test
    void testBiPredicate() {
        BiPredicate<String, Integer> lengthChecker = (a, b) -> a.length() == b;
        System.out.println(lengthChecker.test("Shailendra", 10));
        System.out.println(lengthChecker.test("Singh", 10));
    }

    @Test
    void testUnary() {
        UnaryOperator<String> tripleX = (a) -> a+":"+a+":"+a;
        System.out.println(tripleX.apply("Totaan!"));

    }

    @Test
    void testBinary() {
        //Unary and binary return results or same type
        BinaryOperator<Integer> multiplier = (a, b) -> a*b; //takes only one type
        int res = multiplier.apply(100, 5);
        System.out.println("res: "+res);

    }
}
