package com.sports.rafael.algos;

public class BreakPalindrome {
    public static void main(String[] args) {
        String res = breakPalindrome("abccba");
        System.out.println(res);
    }

    public static String breakPalindrome(String palindrome) {
        if(palindrome.length() == 0 || palindrome.length() == 1)
            return "";

        char[] arr = palindrome.toCharArray();
        boolean foundDiff = false;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != 'a') {
                foundDiff = true;
                arr[i] = 'a';
                break;
            }
        }
        if(! foundDiff) {
            arr[arr.length-1] = 'b';
        }
        return new String(arr);
    }
}
