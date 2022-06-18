package com.sports.rafael;

public class GCD {

    public static void main(String[] args) {
        int a = 98, b = 56;
        System.out.println("GCD of " + a +" and " + b + " is " + gcd(a, b));

        System.out.println(98%56);
    }

    private static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
