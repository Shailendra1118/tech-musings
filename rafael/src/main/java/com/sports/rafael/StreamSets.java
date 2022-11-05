package com.sports.rafael;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StreamSets {

    private static Map<Character,String> map = Map.of('1', "ab",
            '2',"cd",
            '3', "e");

    public static void main(String[] args) {
        String s = "1";
        List<String> result = new ArrayList<>();
       //find recurrences relation
        combinationUtil(s, result, 0, new StringBuilder());
        System.out.println("Result: "+result);

    }

    private static void combinationUtil(String digits, List<String> result, int start, StringBuilder sb) {
        if(sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String possibleLetters = map.get(digits.charAt(start));
        for(int i=0; i<possibleLetters.length(); i++) {
            sb.append(possibleLetters.charAt(i));
            combinationUtil(digits, result, start+1, sb); //move to next Index that's
            sb.deleteCharAt(sb.length()-1);
        }
    }

    private static List<String> combination(String strA, String strB) {  // "[a, b]", [c, d, e]
        List<String> res = new ArrayList<>();
        char[] arrA = strA.toCharArray();
        char[] arrB = strB.toCharArray();
        StringBuilder sb;
        for(int i=0; i<arrA.length; i++) {
            for(int j=0; j<arrB.length; j++) {
                sb = new StringBuilder();
                sb.append(arrA[i]);
                sb.append(arrB[j]);
                res.add(sb.toString());
            }
        }
        return res;
    }

}
