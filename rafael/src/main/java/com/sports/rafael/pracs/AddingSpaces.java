package com.sports.rafael.pracs;

public class AddingSpaces {

    public static void main(String[] args) {
        AddingSpaces obj = new AddingSpaces();
        int spaces[] = {8,13,15};
        String res = obj.addSpaces("LeetcodeHelpsMeLearn", spaces);
        System.out.println("Res:: "+res);
    }

    public String addSpaces(String s, int spaces[]){
        StringBuilder sb = new StringBuilder();
        char arr[] = s.toCharArray();
        int prev = 0;
        for(int i=0; i<spaces.length; i++){
            String temp = String.copyValueOf(arr, prev, spaces[i]-prev);
            System.out.println("TEMP:: "+temp);
            sb.append(temp);
            sb.append(" ");
            prev = spaces[i];
        }

        //last one
        String temp = String.copyValueOf(arr, prev, arr.length-prev);
        sb.append(temp);

        return sb.toString();
    }
}
