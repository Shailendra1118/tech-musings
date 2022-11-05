package mocks;

import java.util.LinkedList;
import java.util.Queue;

public class TestClass {
    public static void main(String[] args) {

        int[][] mat = {
                {1,1,1,0,0},
                {0,1,0,0,1},
                {1,0,0,1,1},
                {0,0,0,0,0},
                {1,0,1,0,1}};

        boolean[][] visited = new boolean[mat.length][mat.length];
        int cost = 0;
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat.length; j++){
                if(mat[i][j] == 1 && !visited[i][j]){
                    process(mat, i, j, visited);
                    cost++;
                }
            }
        }
        System.out.println("Cost: "+cost);
    }

    private static void process(int[][] mat, int r, int c, boolean[][]visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        int[] ri = {-1,0,1,0};
        int[] ci = {0,1,0,-1};
        while(!queue.isEmpty()) {
            int[] land = queue.poll();
            // visited[land[0]][land[1]] = 1;
            // mat[land[0]][land[1]] = 0; //visited
            for(int i=0; i<ri.length; i++){
                int newR = land[0]+ri[i];
                int newC = land[1]+ci[i];
                if(isValid(newR, newC, mat.length, mat) && !visited[newR][newC]){
                    queue.offer(new int[]{newR, newC});
                    visited[newR][newC] = true;
                }
            }
        }
    }

    private static boolean isValid(int r, int c, int N, int[][] mat) {
        if(r >=0 && r<N && c>=0 && c<N && mat[r][c] == 1)
            return true;
        return false;
    }
}
