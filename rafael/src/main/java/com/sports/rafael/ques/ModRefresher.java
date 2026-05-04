package com.sports.rafael.ques;

public class ModRefresher {

    public static void main(String[] args) {
        int a = 2;
        int b = 1;
        System.out.println(a%b); // 2%1 == 0 because it gets divided with no remainder
        System.out.println(a/b); // 2/1 == 2 because it gets divided when 1 two-za 2

        System.out.println(b%a); // 1%2 == 1 not divided, remainder still 1
        System.out.println(b/a); // 1/2 == 0 not divided

        System.out.println("0%3 :: "+0%3);
        System.out.println("1%3 :: "+1%3);
        System.out.println("2%3 :: "+2%3);
        System.out.println("3%3 :: "+3%3);
        System.out.println("4%3 :: "+4%3);
        System.out.println("5%3 :: "+5%3);


        boolean res = Character.isLetterOrDigit('!');
        System.out.println(res);
    }
}
