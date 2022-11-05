package com.sports.rafael.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class Celligo {
    public static void main(String[] args) {

        int[][] matrix = {{1,1,0,1},
                          {0,1,0,1},
                          {0,0,0,0},
                          {1,1,0,1}};


        int counter = 0;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix.length; j++) {
                if(matrix[i][j] == 1){
                    process(i,j, matrix);
                    counter++;
                }
            }
        }
        System.out.println("Islands: "+counter);
    }

    private static void process(int r, int c, int[][] matrix) {

        int[] rowi = {-1,0, 1, 0};
        int[] coli = {0,1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r,c});

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            for(int i=0; i<rowi.length; i++) {
                int newR = cell[0]+rowi[i];
                int newC = cell[1]+coli[i];
                if(isValid(newR, newC, matrix.length) && matrix[newR][newC] == 1){
                    queue.offer(new int[]{newR, newC});
                    matrix[newR][newC] = 0;
                }
            }
        }

    }

    private static boolean isValid(int newR, int newC, int N) {
        if(newR >= 0 && newR <N && newC >=0 && newC <N)
            return true;
        return false;
    }

    private void money() {
        int[] money = {2,5,7,8,3,8}; //11 ,21 , 23
        // money(n) = max(money(i) + money(i+2 to n), money(i+1 to n)
        // total-i 1->n



    }
}
