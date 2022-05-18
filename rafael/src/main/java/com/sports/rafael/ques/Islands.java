package com.sports.rafael.ques;

public class Islands {

    int counter = 0;
    public static void main(String[] args) {

    }


    public int numIslands(char[][] grid) {

        int x = grid.length;
        int y = grid[0].length;
        boolean visited[][] = new boolean[x][y];

        //think twice code once!!
        //recursion DFS
        util(grid, visited, 0, 0);
        return counter;


    }


    private void util(char[][] grid, boolean[][] visited, int i, int j){

        if(isValid(i, j, grid) && grid[i][j] == '1'){
            // lies within boundaries , like it should not be -1 or greater than length
            if(visited[i][j]){
                return;
            }
            visited[i][j] = true;
            ++counter;
            util(grid, visited, i-1, j);
            util(grid, visited, i, j+1);
            util(grid, visited, i+1, j);
            util(grid, visited, i, j-1);

        }

    }

    private boolean isValid(int r, int c, char[][] grid){
        if(r >=0 && r <grid.length && c >=0 && c <grid[0].length){
            return true;
        }
        return false;
    }
}
