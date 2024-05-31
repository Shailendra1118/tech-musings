package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class CalculatePerimeter {

    @Test
    public void calPerimeter() {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        //int perimeter = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    //is land
                    int res = calcPerimeter(grid, i, j);
                    System.out.println("RES: "+res);
                    break;
                }
            }
        }
    }

    private int calcPerimeter(int[][] grid, int row, int col) {
        int[] rowDir = {-1,0,1,0};
        int[] colDir = {0,1,0,-1};
        int perimeter = 0;
        //BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        int totalR = grid.length;
        int totalC = grid[0].length;
        boolean[][] visited = new boolean[totalR][totalC];
        while(! queue.isEmpty()) {
            int[] cell = queue.poll();
            if (cell[0] == 0 || cell[0] == totalR-1) {
                perimeter++;
            } else if (grid[cell[0]-1][cell[1]] == 0 || grid[cell[0]+1][cell[1]] == 0) {
                perimeter++;
            } else if (cell[1] == 0 || cell[0] == totalC-1) {
                perimeter++;
            } else if (grid[cell[0]][cell[1]-1] == 0 || grid[cell[0]][cell[1]+1] == 0) {
                perimeter++;
            }
            //check and add neighbour cells
            for(int i=0; i<4; i++) {
                int nRow = cell[0]+rowDir[i];
                int nCol = cell[1]+colDir[i];
                int[] nCell = new int[]{nRow, nCol};
                if (isValid(grid, nRow, nCol) && grid[nRow][nCol] == 1 && !visited[nRow][nCol]) {
                    queue.offer(nCell);
                    visited[nRow][nCol] = true;
                }
            }

        }
        return perimeter;
    }

    private boolean isValid(int[][] grid, int r, int c) {
        if (r>=0 && r<grid.length && c>=0 && c<grid[0].length) {
            return true;
        }
        return false;
    }
}
