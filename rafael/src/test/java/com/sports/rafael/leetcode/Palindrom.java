package com.sports.rafael.leetcode;


import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Palindrom {

    public static void main(String[] args) {
        //System.out.println(Character.isAlphabetic('1'));
        //System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;
        boolean isPalindrome = true;
        while(i < j) {
            while(i < j) {
                if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                    break;
                if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                    break;
                i++;
            }
            while(i < j) {
                if(s.charAt(j) >= 'a' && s.charAt(j) <= 'z')
                    break;
                if(s.charAt(j) >= 'A' && s.charAt(j) <= 'Z')
                    break;
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                isPalindrome = false;
                break;
            }
            i++;
            j--;
        }

        return isPalindrome;

    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    @Test
    public void LLPalindrome() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);

        Stack<Integer> stack = new Stack<>();
        int size = 0;
        ListNode node = head;
        while(node != null) {
            size++;
            node = node.next;
        }

        boolean isOdd = size%2 == 1;
        int stackSize = size/2;
        node = head;
        while(node != null && stackSize > 0){
                stackSize--;
                stack.push(node.val);
                node = node.next;
        }

        boolean isPalindrome = true;
        if(isOdd){
            node = node.next;
        }
        while(node != null && !stack.isEmpty()) {
            if(node.val != stack.pop()){
                isPalindrome =false;
                break;
            }
            node = node.next;
        }
        if(!stack.isEmpty()){
            isPalindrome = false;
        }

        System.out.println(isPalindrome);
    }
}
