package com.sports.rafael.basics.threading;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Pooling {

    @Test
    public void testCompletionStage() {
        CompletableFuture.supplyAsync(() -> {
                    try {
                        URL url = new URL("https://www.example.com/");
                        try (InputStream is = url.openStream()) {
                            return new String(is.readAllBytes());
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }).thenAccept(System.out::println)
                .thenRun(() -> System.out.println("Task finished"))
                .join();
    }

    @Test
    public void testCompletableFutureMethod() {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<Void> future = completableFuture
                .thenAccept(s -> System.out.println("Computation returned: " + s));

        future.join();
    }


    @Test
    public void testCompletableFuture() {
        Demo demo = new Demo();
        try{
            Future<String> result = demo.calculateAsync();
            System.out.println("Result is: "+result.get());
        }catch(InterruptedException | ExecutionException iexp) {
            System.out.println("Error: "+iexp.getMessage());
        }
    }

    class Demo {
        public Future<String> calculateAsync() throws InterruptedException {
            CompletableFuture<String> completableFuture = new CompletableFuture<>();

            Executors.newCachedThreadPool().submit(() -> {
                Thread.sleep(5000);
                completableFuture.complete("Hello");
                return null;
            });

            return completableFuture;
        }
    }
}
