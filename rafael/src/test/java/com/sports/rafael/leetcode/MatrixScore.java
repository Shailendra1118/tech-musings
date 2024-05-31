package com.sports.rafael.leetcode;

public class MatrixScore {

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,1}, {1,0,1,0}, {1,1,0,0}};
        MatrixScore obj = new MatrixScore();
        int res = obj.matrixScore(grid);
        System.out.println("Res: "+res);
    }

    public int matrixScore(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        //int maxVal = -1;
        //iterate over rows
        for(int i=0; i<rows; i++) {
            String row = getString(grid, i, -1);
            String toggledRow = getToggled(row);
            if (Integer.parseInt(toggledRow, 2) > Integer.parseInt(row, 2)) {
                move(grid, i, -1, toggledRow);
            }
        }
        //iterate over cols
        for(int i=0; i<cols; i++) {
            String col = getString(grid, -1, i);
            String toggledCol = getToggled(col);
            if (Integer.parseInt(toggledCol, 2) > Integer.parseInt(col, 2)) {
                move(grid, -1, i, toggledCol);
            }
        }
        return getScore(grid);
    }

    private void move(int[][] grid, int row, int col, String value) {
        char[] val = value.toCharArray();
        if (col == -1) {
            for(int i=0; i<grid[0].length; i++) {
                grid[row][i] = Integer.valueOf(val[i]-'0');
            }
        } else {
            for(int i=0; i<grid.length; i++) {
                grid[i][col] = Integer.valueOf(val[i]-'0');
            }
        }
    }

    private int getScore(int[][] grid) {
        int score = 0;
        for(int i=0; i<grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<grid[0].length; j++) {
                sb.append(grid[i][j]);
            }
            score += Integer.parseInt(sb.toString(), 2);
        }
        return score;
    }

    private String getString(int[][] grid, int rowNum, int colNum) {
        StringBuilder sb = new StringBuilder();
        if (colNum == -1) {
            for (int i=0; i<grid[0].length; i++) {
                sb.append(grid[rowNum][i]);
            }
        } else {
            for(int i=0; i<grid.length; i++) {
                sb.append(grid[i][colNum]);
            }
        }
        return sb.toString();
    }

    private String getToggled(String row) {
        char[] chars = row.toCharArray();
        for(int i=0; i<chars.length; i++) {
            if (chars[i] == '1') {
                chars[i] = '0';
            } else {
                chars[i] = '1';
            }
        }
        return new String(chars);
    }
}
