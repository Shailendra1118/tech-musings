package com.sports.rafael.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WhatFuture {

    public static void main(String[] args) {
        List<String> messages = Arrays.asList("Msg1", "Msg2", "Msg3", "Msg4", "Msg5", "Msg6", "Msg7", "Msg8", "Msg9",
                "Msg10", "Msg11", "Msg12");
        MessageService messageService = new MessageService();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        /*
         If not passed then tasks are run in ForkJoinPool.commonPool() 's thread
            sending notification...Msg10 pool-1-thread-1
            sending notification...Msg11 pool-1-thread-2
            sending notification...Msg12 pool-1-thread-1
         */

        List<String> mapResult = new ArrayList<>();

        CompletableFuture<?>[] fanoutRequestList = new CompletableFuture[messages.size()];
        int count = 0;
        for (String msg : messages) {
            CompletableFuture<?> future = CompletableFuture
                    .supplyAsync(() -> messageService.sendNotification(msg)).exceptionally(ex -> "Error")
                    .thenAccept(mapResult::add);

            fanoutRequestList[count++] = future;
        }

        CompletableFuture.allOf(fanoutRequestList).join();

        /*
        try {
            CompletableFuture.allOf(fanoutRequestList).get();
            //CompletableFuture.allOf(fanoutRequestList).join();
           } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
           }
         */


    }

    static class MessageService {
        public String sendNotification(String input) {
            System.out.println("sending notification..."+input+" "+Thread.currentThread().getName());
            // wait
            long i = 0;
            while(i < Long.MAX_VALUE-12313)
                i++;
//            try {
//                Thread.sleep(3000);
//            }catch(InterruptedException exp) {
//                System.out.println("OMG InterruptedException Occurred...");
//            }
            return "processed "+input;
        }
    }
}
