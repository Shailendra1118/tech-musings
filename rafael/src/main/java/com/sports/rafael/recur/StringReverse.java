package com.sports.rafael.recur;

public class StringReverse {

    public static void main(String[] args) {
        String str = "Shailendra";
        String res = reverseIt(str);
        System.out.println("Reversed: "+res);

        //recursiveString
        char arr[] = "Shailendra".toCharArray(); //"str.toCharArray();"
        reverseString(arr);
        System.out.println("Recur: "+String.valueOf(arr));
    }

    private static void reverseString(char arr[]) {
        util(arr, 0);
    }

    private static void util(char[] arr, int index) {
        //base case
        if(index == arr.length/2) {
            return;
        }
        //swap
        swap(arr, index, arr.length-index-1);
        //recur
        util(arr, index+1);
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static String reverseIt(String str) {
        StringBuilder sb =new StringBuilder();
        helper(str, 0, sb);
        return sb.toString();
    }

    private static void helper(String str, int index, StringBuilder sb) {
        if(index >= str.length()) {
            return;
        }
        helper(str, index+1, sb);
        sb.append(str.charAt(index));
    }
}
