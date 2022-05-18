package com.sports.rafael;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class brackets {

    public static void main(String[] args) {
        String in1 = "()";//"{[()]()}";
        String in2 = "{[(])}";

        Map<Character, Character> map= new HashMap();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        char arr[] = in1.toCharArray();
        stack.push(arr[0]);
        Iterator iter = stack.iterator();

        //System.out.println(stack);
        for(int i=1; i<arr.length; i++){
            char c = arr[i];
            //System.out.println("curr char is: "+c);
            if(c == '{' || c == '[' || c == '('){
               // System.out.println("pushing the opening bracket "+c+" to stack");
                stack.push(c);
            }else{
                //if not opening
                //System.out.println("Peek is..."+stack.peek());
                if(stack.peek().equals(map.get(c))){
                    //System.out.println("Found matching "+stack.peek()+" with "+c);
                    stack.pop();
                }else{
                    //not matching
                    break;
                }
            }
        }

        if(stack.isEmpty()){
            System.out.println(true);
        }else
            System.out.println(false);


        System.out.println("NEW: "+isValid("()"));
    }


    public static boolean isValid(String s) {

        if(s == null || s.length() == 0){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        char arr[] = s.toCharArray();

        Map<Character,Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('(', ')');
        map.put('{', '}');


        //think first and verbalize your approach so that I will not fumble later on
        //think twice - code once
        int i = 0;
        while(i < arr.length){
            if(arr[i] == '(' || arr[i] == '[' || arr[i] == '{') {
                stack.push(map.get(Character.valueOf(arr[i])));
            }else{
                //if its closing one
                if(stack.peek().equals(arr[i])){
                    stack.pop();
                }else{
                    return false;
                }

            }
            i++;
        }

        if(stack.isEmpty()){
            return true;
        }else
            return false;

    }
}
