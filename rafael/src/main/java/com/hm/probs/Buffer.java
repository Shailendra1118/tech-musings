package com.hm.probs;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {

    private Queue<String> queue;
    private int size;

    public Buffer(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }

    public boolean addMessage(String input) {
        return this.queue.offer(input);
    }

    public String receiveMessage() {
        return this.queue.poll();
    }
}
