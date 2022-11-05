package com.sports.rafael.recursive;

public class PrintName {
    public static void main(String[] args) {

        String name = "Shailendra";
        int N = 5;
        //printName(name, N, 0);

        //printReverse(5, 1);
        int res = sumFirstNums(10, 0);
        System.out.println("Sum: "+res);

        int res1 = sumFirstFunction(10);
        System.out.println("REC: "+res1);
    }

    private static int sumFirstFunction(int n) {
        if(n < 1)
            return n;
        return n + sumFirstFunction(n-1);
    }

    private static int sumFirstNums(int n, int sum) {
        if(n <= 0)
            return sum;
        //sum = sum + n;
        return sumFirstNums(n-1, sum+n);
    }

    private static void printReverse(int n, int count) {
        //base condition
        if(count > n)
            return;
        //  System.out.println(n); for reverse order
        printReverse(n, count+1);
        System.out.println(count); // for increasing order, called while **backtracking** the call stack
    }

    private static void printName(String name, int n, int count) {
        //base condition
        if(count == n)
            return;
        System.out.println(name);
        printName(name, n,count+1);
    }
}
