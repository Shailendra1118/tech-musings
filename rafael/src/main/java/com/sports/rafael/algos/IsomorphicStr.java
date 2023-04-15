package com.sports.rafael.algos;

public class IsomorphicStr {
    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        boolean res = isIsomorphic(s, t);
        System.out.println("Res: " + res);
    }

    private static boolean isIsomorphic(String s, String t) {
        char[] arr = new char[128];
        for(int i=0; i<s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if((int)arr[sChar-'a'] == 0) {
                if((int) arr[tChar-'a'] != 0)
                    return false;
                else {
                    //is empty
                    arr[sChar-'a'] = tChar;
                }
            } else {
                //place is already fill, check if has same mapping
                if(arr[sChar-'a'] != tChar) {
                    return false;
                }
            }
        }
        return true;
    }
}
