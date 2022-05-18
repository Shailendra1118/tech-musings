package com.sports.rafael;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*

Given a list of non-negative integers, arrange them such that they form the largest number.


// Start thinking from BASIC - Fundamentals - Focus on the problem

example:
Input: [3,30,34,5,9]
Output: "9 5 34 3 30"

3000000
3000000
3400000
5000000
9000000 -
9,
300000
300000
340000
500000
5 -> (9 5 ..)

30000
30000
34000
9 5 34

3 000
30 00

eg 9, 5, 11

9000 -> 5,11
5000 -> 9, 11
1100 -> 5,9

9,--
5, 11
511-
115

9511

--> 9511
1195


 */
public class Problems {


    static Map<Integer, String> map = new TreeMap<>();
    static int arr[] = {90, 50, 40, 10, 9, 5, 4, 1};

    public static void main(String[] args) {

        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");

        StringBuilder res = new StringBuilder();
        convertToRoman(72, res);
        System.out.println(res);
    }


    private static void convertToRoman(int input, StringBuilder res) {
        if(input <= 0){
            return;
        }

        int temp = 0;
        for(int num : arr){
            if(num <= input){
               temp = num;
               break;
            }
        }

        int d = input / temp;
        int r = input % temp;
        //append to result
        for(int i=0; i<d; i++){
            res.append(map.get(temp));
        }
        // recur
        convertToRoman(r, res);
    }




}


