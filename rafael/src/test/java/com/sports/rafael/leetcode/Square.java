package com.sports.rafael.leetcode;

public class Square {

    public static void main(String[] args) {
        Square obj = new Square();
        char[][] matrix = {{'1','0','1','0','0'},
                            {'1','0','1','1','1'},
                            {'1','1','1','1','1'},
                            {'1','0','0','1','0'}};

        int res = obj.maximalSquare(matrix);
        System.out.println("Res: "+ res);
    }

    public int maximalSquare(char[][] matrix) {

        int ROW = matrix.length;
        int COL = matrix[0].length;
        int dp[][] = new int[ROW][COL];

        //iterate over matrix
        for(int i=0; i<COL; i++){
            System.out.println(Integer.parseInt(String.valueOf(matrix[0][i])));
            dp[0][i] = Integer.parseInt(String.valueOf(matrix[0][i]));
        }

        for(int i=0; i<ROW; i++){
            dp[i][0] = Integer.parseInt(String.valueOf(matrix[i][0]));
        }

        for(int i=1; i<ROW; i++) {
            for(int j=1; j<COL; j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                }else {
                    dp[i][j] = 0;
                }
            }
        }


        int max = 1;
        //iterate again to find max
        for(int i=0; i<ROW; i++){
            for(int j=0; j<COL; j++){
                if(dp[i][j] > max)
                    max = dp[i][j];
            }
        }

        return max * max;

    }
}
