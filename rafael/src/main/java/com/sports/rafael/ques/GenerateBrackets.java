package com.sports.rafael.ques;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateBrackets {

    public static void main(String[] args) {
        int n = 1;
        int open = 2;
        int close = 2; //open and close both should be same to be balanced/well-formed
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        generateBrackets(open, close, "", res);
        System.out.println(res);

        //System.out.println(isValid("(())()"));
    }

    private static List<String> generateBrackets(int open, int close, String sb, List<String> res) {

        if(open == 0 && close == 0 && isValid(sb)) {
            res.add(sb);
            //sb = new StringBuilder();
            return res;
        }

        if(open > 0) {
            generateBrackets(open - 1, close, sb+"(", res);
        }
        if(close > 0)
            generateBrackets(open, close-1, sb+")", res);
        return res;
    }

    private static boolean isValid(String str) {
        Stack<Character> st = new Stack<>();
        char arr[] = str.toCharArray();
        System.out.println(arr);
        int i =0;
        while(i< arr.length){
            if(arr[i] == '('){
                st.push(arr[i]);
            }else{
                //closing
                if(!st.isEmpty() && st.peek() == '('){
                    st.pop();
                }else
                    return false;
            }
            i++;
        }

        return st.isEmpty();

    }
}
