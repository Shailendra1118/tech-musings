package com.hm.probs;

public class RingBuffer {

    private int head = -1;
    private int tail = -1;
    private int[] values;
    private int size;

    public RingBuffer(int k) {
        values = new int[k];
        size = k;
    }

    public static void main(String[] args) {
        RingBuffer queue = new RingBuffer(6);
        queue.enQueue(6);
        System.out.println(queue.Rear());
        System.out.println(queue.Rear());
        queue.deQueue();
        queue.enQueue(5);
        System.out.println(queue.Rear());
        queue.deQueue();

    }


    public boolean enQueue(int value) {
        if(! isFull()) {
            tail = (tail+1)%size;
            values[tail] = value;
            if(head == -1) {
                head = tail;
            }
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if(! isEmpty()) {
            if(head == tail) {
                head = -1;
                tail = -1;
            }else {
                head = (head+1)%size;
            }
            return true;
        }
        return false;
    }

    public int Front() {
        if(!isEmpty()) {
            return values[head];
        }
        return -1;

    }

    public int Rear() {
        if(!isEmpty()) {
            return values[tail];
        }
        return -1;
    }

    public boolean isEmpty() {
        if(head == tail && head == -1)
            return true;
        return false;
    }

    public boolean isFull() {
        if((tail+1)%size == head)
            return true;
        return false;
    }
}
