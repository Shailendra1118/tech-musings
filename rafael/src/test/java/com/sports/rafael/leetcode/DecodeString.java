package com.sports.rafael.leetcode;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        String input = "2[abc]3[cd]ef";
        DecodeString obj = new DecodeString();
        String res = obj.decodeIt(input);
        System.out.println("Res: "+res);
    }

    private String decodeIt(String input) {

        char[] arr = input.toCharArray();
        Stack<Character> stack = new Stack<>();

        StringBuilder res = new StringBuilder();
        StringBuilder cur = new StringBuilder();

        for(int i=0; i<arr.length; i++) {
            if(arr[i] != ']') {
                //keep on pushing to stack
                stack.push(arr[i]);
            }else {
                //encountered closed bracket
                StringBuilder temp = new StringBuilder(); //every time new when close bracket comes
                while(stack.peek() != '[') {
                    temp.append(stack.pop());
                }
                //remove opening bracket
                stack.pop();
                StringBuilder digitSb = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    digitSb.append(stack.pop());
                }
                //repeat with number of times
                int dig = Integer.valueOf(digitSb.reverse().toString());
                //StringBuilder repeated = new StringBuilder();
                String repeated = temp.reverse().append(cur).toString();

                StringBuilder newCur = new StringBuilder();
                while(dig >0) {
                    newCur.append(repeated);
                    dig--;
                }
                cur = newCur;

                //if stack is empty, it is a part of solution
                if(stack.isEmpty()) {
                    res.append(cur);
                    cur.setLength(0); //clear up cur
                }

            }
        }

        //append any remaining chars
        while(!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.toString();
    }
}
