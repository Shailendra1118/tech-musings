package com.sports.rafael.datas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class RateLimiterApp {

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(10, 1000);
        Thread consumer = new Thread(rateLimiter);
        consumer.start();

        //Thread producer = new Thread(rateLimiter); use main thread as producer?
        int session = 20;
        Random random = new Random();
        while(session > 0) {
            String req = "Request num: "+random.nextInt(100);
            rateLimiter.call(req);
            session--;
        }

        try {
            System.out.println("Waiting for 8 seconds..."+Thread.currentThread().getName()+" "
                    + LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            Thread.sleep(8000);
            System.out.println("Done with 8 seconds..."+Thread.currentThread().getName() + " "
                    + LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        rateLimiter.stop();
        System.out.println("Existing main...");

    }
}


class RateLimiter implements Runnable {
    private int bucketSize = 0;
    private int outFlowRate = 0;
    private Queue<String> queue; //can be custom type
    private volatile boolean notStopped = true; //volatile?

    public RateLimiter(int bucketSize, int outFlowRate) {
        this.bucketSize = bucketSize;
        this.outFlowRate = outFlowRate;
        System.out.println("Bucket: "+bucketSize+", outFlowRate: "+outFlowRate);
        this.queue = new LinkedList<>();
    }

    public void call(String request) {
        if(this.queue.size() == bucketSize) {
            System.out.println("Dropped: "+request+" "+Thread.currentThread().getName() + " "
                    + LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            return;
        }
        this.queue.add(request);
        System.out.println("Added: "+request+" "+Thread.currentThread().getName() + " "
                + LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
    public void stop() {
        //System.out.println("Marking stopped in rate limiter");
        System.out.println("Queue items left: "+this.queue.size());
        this.notStopped = false;
        System.out.println("Stopped in rate limiter");
    }

    @Override
    public void run() {
        while(notStopped) {
            if(! queue.isEmpty()) {
                String req = queue.poll();
                System.out.println("Picked: "+req);
                try {
                    System.out.println("Waiting for "+outFlowRate+" millis..."
                            +Thread.currentThread().getName() + " "
                            + LocalDateTime.now()
                            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                    Thread.sleep(outFlowRate);
                    System.out.println("Done for "+outFlowRate+" millis..."
                            +Thread.currentThread().getName() + " "
                            + LocalDateTime.now()
                            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Sent: "+req);
            }
        }
    }
}

