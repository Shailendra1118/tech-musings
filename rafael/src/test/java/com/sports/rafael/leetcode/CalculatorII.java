package com.sports.rafael.leetcode;

import java.util.*;

public class CalculatorII {
    public static void main(String[] args) {
        CalculatorII calculatorII = new CalculatorII();
        int res = calculatorII.calculate("33+2 * 2");
        System.out.println("Res: "+res);
        System.out.println(Integer.valueOf("12345"));
    }

    public int calculate(String s) {
        Deque<Character> operatorStack = new LinkedList<>();
        Deque<Integer> operandStack = new LinkedList<>();
        Map<Character,Integer> precMap = new HashMap<>();
        precMap.put('/', 1);
        precMap.put('*', 1);
        precMap.put('+', 2);
        precMap.put('-', 2);
        s = s.replace(" ", "");
        char[] chars = s.toCharArray();
        for(char c : chars) {
            if(Character.isDigit(c)) {
                operandStack.push(c-48);
            }else {
                //operator
                while(! operatorStack.isEmpty() && precMap.get(operatorStack.peek()) <= precMap.get(c)) {
                    char optr = operatorStack.pop();
                    eval(optr, operandStack);
                }
                operatorStack.push(c);
            }
        }

        while(! operatorStack.isEmpty()) {
            eval(operatorStack.pop(), operandStack);
        }

        return operandStack.pop();

    }

    private void eval(char operator, Deque<Integer> operandStack) {
        int frst = operandStack.pop();
        int sec = operandStack.pop();
        switch(operator) {
            case '*':
                operandStack.push(sec * frst);
                break;
            case '/':
                operandStack.push(sec / frst);
                break;
            case '+':
                operandStack.push(sec + frst);
                break;
            case '-':
                operandStack.push(sec - frst);
                break;
        }
    }
}
