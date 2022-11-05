package com.sports.rafael.leetcode;

import java.util.Arrays;

public class DutchFlag {
    public static void main(String[] args) {
        String[] colors= {"G", "G", "G", "B", "R","R","G"};

        sortColors(colors);
        System.out.println(Arrays.toString(colors));
    }

    //R --> G --> B
    //0     1     2
    private static void sortColors(String[] colors) {
        int left = 0, mid = 0, right = colors.length-1;
        while(mid <= right){
            String color = colors[mid];
            switch(color) {
                case "R":
                {
                    //swap left with mid
                    String temp = colors[left];
                    colors[left] = colors[mid];
                    colors[mid]=temp;
                    mid++;
                    left++;
                    break;
                }
                case "G":
                {
                    mid++;
                    break;
                }
                case "B":
                {
                    //swap mid with right
                    String temp = colors[mid];
                    colors[mid] = colors[right];
                    colors[right]=temp;
                    right--;
                    break;
                }
            }

        }
    }
}
