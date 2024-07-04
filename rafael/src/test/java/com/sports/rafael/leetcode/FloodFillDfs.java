package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FloodFillDfs {

    private int[] rDir = {-1,0,1,0};
    private int[] cDir = {0,1,0,-1};

    @Test
    void testFloodFill() {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        int[][] res = floodFill(image, sr, sc, color);
        Arrays.stream(image).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        //dfs call
        int origColor = image[sr][sc];
        if (color == origColor)
            return image;
        floodFillRec(image, sr, sc, origColor, color);
        return image;
    }

    private void floodFillRec(int[][] image, int r, int c, int origColor, int newColor) {
        // update neighbours if same color as this
        image[r][c] = newColor;
        for (int i=0; i<4; i++) {
            int nR = r + rDir[i];
            int nC = c + cDir[i];
            if (isValid(image, nR, nC) && image[nR][nC] == origColor) {
                //recurse
                floodFillRec(image, nR, nC, origColor, newColor);
            }
        }

    }

    private boolean isValid(int[][] image, int r, int c) {
        if (r < 0 || r >= image.length) {
            return false;
        }
        if (c < 0 || c >= image[0].length) {
            return false;
        }
        return true;
    }
}
