package com.sports.rafael.datas;

import org.junit.jupiter.api.Test;

public class StackQueueUtilTest {

    @Test
    public void testQueueOffer() {
        XQueue<String> que = new XQueue(4);
        que.offer("A");
        que.offer("B");
        que.offer("C");
        que.offer("D");
        que.offer("D");
        String res = que.poll();
        System.out.println("res: "+res);
        que.poll();
        que.poll();
        que.poll();
        que.poll();

    }

    @Test
    public void testQueueOfferMix() {
        XQueue que = new XQueue(4);
        que.offer("A");
        que.offer("B");
        que.offer("C");
        que.offer("D");
        que.poll();
        que.poll();
        que.poll();
        que.poll();
        que.poll();
        que.poll();


    }

    @Test
    public void testFullCapacity() {
        XStack stack = new XStack(5);
        stack.push("Shailendra");
        stack.push("Singh");
        stack.push("Yadav");
        stack.push("Banglore");
        stack.push("Munich");
        stack.push("Lahore");

    }

    @Test
    public void testEmpty() {
        XStack stack = new XStack(5);
        stack.push(10);
        stack.pop();
        stack.push("Shailendra");
        stack.push("Singh");
        stack.pop();
        stack.pop();
        stack.push("Aman");
        stack.push("Chugh");
        stack.pop();
        stack.pop();
        System.out.println(stack.isStackEmpty());
    }



}
