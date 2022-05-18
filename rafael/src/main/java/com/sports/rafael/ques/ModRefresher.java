package com.sports.rafael.ques;

public class ModRefresher {

    public static void main(String[] args) {
        int a = 2;
        int b = 1;
        System.out.println(a%b); // 2%1 == 0 because it gets divided with no remainder
        System.out.println(a/b); // 2/1 == 2 because it gets divided when 1 two-za 2

        System.out.println(b%a); // 1%2 == 1 not divided, remainder still 1
        System.out.println(b/a); // 1/2 == 0 not divided


        boolean res = Character.isLetterOrDigit('!');
        System.out.println(res);
    }
}
