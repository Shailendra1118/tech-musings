package com.hm.probs;

public class Producer {

    private Buffer buffer;

    //constructor
    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void generateString() {
        String input = "message"; //TODO random generator
        //pushToBuffer
        this.buffer.addMessage(input);
    }
}
