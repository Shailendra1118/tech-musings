package com.hm.probs;

public class App {

    public static void main(String[] args) {

        Buffer buffer = new Buffer(5);
        Consumer consumer = new Consumer(buffer);
        Producer producer = new Producer(buffer);

    }
}
