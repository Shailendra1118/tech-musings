package com.sports.rafael.datas;

import java.util.Arrays;

public class XQueue<E> {
    int head = -1, tail = -1;
    private Object[] data;
    int capacity;

    public XQueue(int initCapacity){
        data = new Object[initCapacity];
        this.capacity = initCapacity;
    }

    public boolean offer(E item) {
        if(isFull()) {
            //throw new RuntimeException("Queue is full.");
            System.out.println("Queue is full: "+ Arrays.toString(data));
            return false;
        }
        tail = (tail+1) % capacity; // bracket is necessary as  % is higher precedence over +
        data[tail] = item;
        //update head
        if(head == -1){ // in case of head left behind
            head = tail;
        }
        System.out.println("Offered successfully: "+item);
        return true;
    }

    public E poll(){
        if(isEmpty()) {
            System.out.println("Queue is Empty: "+ Arrays.toString(data));
            return null;
        }
        E item = (E) data[head];
        // head = (head+1) % capacity;
        if(head == tail){
            head = -1; // single element left
            //head = tail-1;
        }else
            head = (head+1) % capacity;

        System.out.println("Polled: "+item);
        return item;
    }

    public boolean isEmpty() {
        //return head == tail; will not work in circular Queue
        return head == -1;
    }

    public boolean isFull() {
        return (head == (tail+1) % capacity);
    }



}
