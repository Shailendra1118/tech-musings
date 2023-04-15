package com.sports.rafael.algos;

public class CherryPicking {

    private static int maxCherriesDown = 0;
    private static int maxCherriesUp = 0;
    public static void main(String[] args) {
        CherryPicking obj = new CherryPicking();
        int[][] grid = {
                {0,1,-1},
                {1,0,-1},
                {1,1,1}};
        int max = obj.cherryPickup(grid);
        System.out.println("Max: "+max);
    }

    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        if(grid[0][0] != -1) {
            dfs(grid, 0, 0, 0);
        }
        if(grid[r-1][c-1] != -1) {
            dfsUp(grid, r-1, c-1, 0);
        }
        return maxCherriesUp+maxCherriesDown;
    }

    private void dfsUp(int[][] grid, int r, int c, int cherries) {
        //base conditions
        if(isValid(grid, r, c)) {
            if(grid[r][c] == -1) {
                return;
            }
            int count = grid[r][c] == 1 ? 1 : 0;
            if(count == 1) {
                grid[r][c] = 0;
            }
            // is destination
            if(r == 0 && c == 0) {
                maxCherriesUp = Math.max(cherries+count, maxCherriesUp);
                return;
            }
            dfsUp(grid, r, c-1, cherries+count);
            dfsUp(grid, r-1, c, cherries+count);
        }
    }

    private void dfs(int[][] grid, int r, int c, int cherries) {
        //base conditions
        if(isValid(grid, r, c)) {
            if(grid[r][c] == -1) {
                return;
            }
            int count = grid[r][c] == 1 ? 1 : 0;
            if(count == 1) {
                grid[r][c] = 0;
            }
            // is destination
            if(r == grid.length-1 && c == grid[0].length-1) {
                maxCherriesDown = Math.max(cherries+count, maxCherriesDown);
                return;
            }
            dfs(grid, r, c+1, cherries+count);
            dfs(grid,r+1, c, cherries+count);
        }
    }

    private boolean isValid(int[][] grid, int row, int col) {
        int rowMax = grid.length;
        int colMax = grid[0].length;
        if(row >= 0 && row < rowMax && col >=0 && col < colMax) {
            return true;
        }
        return false;
    }
}
