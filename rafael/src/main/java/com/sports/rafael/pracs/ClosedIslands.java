package com.sports.rafael.pracs;

import java.util.LinkedList;
import java.util.Queue;

public class ClosedIslands {
    public static void main(String[] args) {
        int[][]grid = {
                {1, 1, 1, 1, 0},
                {1, 0, 0, 1, 0},
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 0}
        };

        int res = findClosedIslands(grid);
        System.out.println("Number of Closed Islands: "+res);
    }

    private static int findClosedIslands(int[][] grid) {
        int closedIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 0 && !visited[i][j] && bfs(grid, visited, i, j, rows, cols)) {
                    closedIslands++;
                }
            }
        }
        return closedIslands;
    }

    private static boolean bfs(int[][] grid, boolean[][] visited, int r, int c, int rows, int cols) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;

        int[] rDir = {-1, 0, 1, 0};
        int[] cDir = {0, 1, 0, -1};
        boolean isClosed = true;
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tR = temp[0];
            int tC = temp[1];
            if(tR == 0 || tR == rows-1 || tC == 0 || tC == cols-1) {
                isClosed = false;
            }
            for(int i=0; i<4; i++) {
                int nR = tR + rDir[i];
                int nC = tC + cDir[i];
                if(isValid(nR, nC, rows, cols) && grid[nR][nC] == 0 && !visited[nR][nC]) {
                    queue.offer(new int[]{nR, nC});
                    visited[nR][nC] = true;
                }
            }
        }
        return isClosed;
    }

    private static boolean isValid(int r, int c, int rows, int cols) {
        if(r >=0 && r < rows && c >=0 && c <cols)
            return true;
        return false;
    }
}
