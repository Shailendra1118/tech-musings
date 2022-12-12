package com.sports.rafael.leetcode;

public class UniquePaths {

    public static void main(String[] args) {
        int[][] input = {{0,0,0},{0,1,0},{0,0,0}};
        int res = uniquePathsWithObstacles(input);
        System.out.println("Res: "+res);
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
       // int[][] dp = new int[row][col];

        //input check
        if(obstacleGrid[0][0] == 1)
            return 0;

        // Number of ways of reaching the starting cell = 1.
        obstacleGrid[0][0] = 1;

        //boolean obstacleFound = false;
        for(int i=1; i<row; i++) {
            if(obstacleGrid[i][0] == 0) {
                obstacleGrid[i][0] = obstacleGrid[i-1][0];
            }else{
                obstacleGrid[i][0] = 0;
            }
        }

        for(int i=1; i<col; i++) {
            if(obstacleGrid[0][i] == 0) {
                obstacleGrid[0][i] = obstacleGrid[0][i-1];
            }else{
                obstacleGrid[i][0] = 0; //so it won't be counted further
            }
        }

        int i=0;
        int j=0;
        for(i=1; i<row; i++) {
            for(j=1; j<col; j++){
                if(obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }else{
                    //found obstacle
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        return obstacleGrid[i-1][j-1];


    }
}
