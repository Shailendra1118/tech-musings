package com.sports.rafael.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

    private List<Integer> values;
    private List<Integer> minValues;
    private int index;
    private int minIndex;

    /** initialize your data structure here. */
    public MinStack() {
        values = new ArrayList<>();
        minValues = new ArrayList<>();
        index = -1;
        minIndex = -1;
    }

    public void push(int x) {
        values.add(x);
        index++;

        //adjust min
        if(minIndex == -1 || x < minValues.get(minIndex)) {
            minValues.add(x);
            minIndex++;
        }
    }

    public void pop() {
        int top = this.top();
        values.remove(index);
        index--;

        //adjust min
        if(top == minValues.get(minIndex)) {
            minValues.remove(minIndex);
            minIndex--;
        }
    }

    public int top() {
        return values.get(index);
    }

    public int getMin() {
        return minValues.get(minIndex);
    }


    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(0);
        stack.push(1);
        stack.push(0);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
