package com.sports.rafael.basics;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class MMT {

    @Test
    public void islandCost() {
        int[][] mat = {{1,1,1,0,0,},
                       {0,1,0,0,1},
                       {1,0,0,1,1},
                       {0,0,0,0,0},
                       {1,0,1,0,1}};

        int cost = 0;
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat.length; j++){
                if(mat[i][j] == 1){
                    process(mat, i, j);
                    cost++;
                }

            }
        }
        System.out.println("Cost: "+cost);

    }

    private void process(int[][] mat, int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        mat[r][c] = 0; //visited
        int[] ri = {-1,0,1,0};
        int[] ci = {0,1,0,-1};
        while(!queue.isEmpty()) {
            int[] land = queue.poll();
            for(int i=0; i<ri.length; i++){
                int newR = land[0]+ri[i];
                int newC = land[1]+ci[i];
                if(isValid(newR, newC, mat.length) && mat[newR][newC] == 1){
                    queue.offer(new int[]{newR, newC});
                    mat[newR][newC] = 0; //visited
                }
            }

        }
    }

    private boolean isValid(int r, int c, int N) {
        if(r >=0 && r<N && c>=0 && c<N)
            return true;
        return false;
    }
}
