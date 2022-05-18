package com.sports.rafael.ques;

import java.util.Arrays;

public class Unravel {

    public static void main(String[] args) {
        int cell[] = {1,1,1,0,1,1,1,1};
        //int cell[] = {1,0,0,0,0,1,0,0};
        int days = 2;

        int out[] = null;
        while(days > 0){
            out = new int[cell.length];
            for(int i=0; i<cell.length; i++){
                if(i ==0) {
                    if (cell[i + 1] == 0)
                        out[i] = 0;
                    else
                        out[i] = 1;
                }else if(i == cell.length-1){
                    if(cell[i-1] == 0)
                        out[i] = 0; //inactive
                    else
                        out[i] = 1;
                }
                else if(cell[i-1] == cell[i+1]){
                    out[i] = 0;
                }else
                    out[i] = 1;
            }
            days--;
            cell = out;
        }


        System.out.println(Arrays.toString(out));
    }
}
