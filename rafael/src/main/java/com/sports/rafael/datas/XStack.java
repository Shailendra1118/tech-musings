package com.sports.rafael.datas;

import java.util.Arrays;
import java.util.EmptyStackException;

public class XStack<E> {

    private int size = -1;
    private Object[] data;
    private int initialCapacity;

    public XStack(int initialCapacity){
        if(initialCapacity < 0)
            throw new IllegalArgumentException("Invalid initialCapacity "+ initialCapacity);
        this.initialCapacity = initialCapacity;
        data = new Object[initialCapacity];
    }

    public E push(E item){
        if(data.length == size+1){
            data = grow();
        }
        data[++size] = item;
        System.out.println("Pushed: "+item);
        return item;
    }

    public E pop() {
        if(isStackEmpty()) {
            throw new EmptyStackException();
        }
        E item = (E) data[size--];
        System.out.println("Popped: "+item);
        return item;
    }

    public boolean isStackEmpty() {
        return size == -1;
    }

    private Object[] grow() {
        System.out.println("Growing array...");
        Object[] temp = Arrays.copyOf(data, initialCapacity*2);
        System.out.println("new Array: "+Arrays.toString(temp));
        return temp;
    }
}
