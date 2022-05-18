package com.sports.rafael.basics.threading;

public class Threading {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();

        try{
            t1.join();
        }catch(Exception e){
            System.out.println("Main thread exception...");
        }

        t2.start();

    }
}

class MyThread extends Thread {
    public void run() {
        for(int i=1; i<=3; i++) {
            try{
                Thread.sleep(2000);
            }catch(Exception e){
                System.out.println("hello from exception");
            }
            System.out.println("No exception hello: i is -> "+i);
        }
    }
}
