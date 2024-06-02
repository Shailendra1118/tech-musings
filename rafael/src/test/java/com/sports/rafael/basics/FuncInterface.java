package com.sports.rafael.basics;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

public class FuncInterface {
    @Test
    void testSupplier() {
        //deferred execution and dynamic value generation
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
        Logger logger = new Logger(true);
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
}
