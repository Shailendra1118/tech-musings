package com.hm.probs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestMatrixPath {
    public static void main(String[] args) {
        ShortestMatrixPath obj = new ShortestMatrixPath();
        int[][] grid = {{0,0,0}, {1,1,0}, {1,1,0}};
        int res = obj.shortestPathBinaryMatrix(grid);
        System.out.println("Res: "+res);
    }


    private int shortestPathBinaryMatrix(int[][] grid) {
        // Firstly, we need to check that the start and target cells are open.
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }

        int[] rd = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] rc = {0,   1, 1, 1, 0,-1,-1, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        //int pathStops = 1;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;

        while(! queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            int distance = cell[2];
            // Check if this is the target cell.
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return distance;
            }
            //find neighbours
            for(int i=0; i<rd.length; i++) {
                int nr = row + rd[i];
                int nc = col + rc[i];
                if(isValid(nr, nc, visited, grid) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, distance + 1});
                    //pathStops++; No need, calculating and saving distance in an arry
                }
            }
        }
        // The target was unreachable.
        return -1;
    }

    private boolean isValid(int r, int c, boolean[][] visited, int[][]grid) {
        if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c] == 0)
            return true;
        return false;
    }
}
