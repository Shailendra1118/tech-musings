package com.hm.probs;

public class Consumer {

    private Buffer buffer;
    private Producer producer;
    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public String receiveMessage() {
        String msg = this.buffer.receiveMessage();
        if(msg == null) {
            //is empty then
            producer.generateString();
        }
        return msg;
    }
}
