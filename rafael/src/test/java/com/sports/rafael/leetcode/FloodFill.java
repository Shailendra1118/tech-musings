package com.sports.rafael.leetcode;

import javax.crypto.spec.PSource;
import java.util.Arrays;

public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {{1,1,1},
                         {1,1,0},
                         {1,0,1}};
        FloodFill obj = new FloodFill();
        int orgColor = image[1][1];
        //image[1][1] = 2; //new color
        if(orgColor != 2)
            obj.floodFill(image, 1, 1, 2, orgColor);

        //System.out.println(Arrays.deepToString(image));
        Arrays.stream(image).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    private void floodFill(int[][] image, int sr, int sc, int newColor, int orgColor) {

        //image[sr][sc] = color; //update the pixel
        //base condition
        if (isValid(image, sr, sc, orgColor)) {
            //recur for 4-directionally
            image[sr][sc] = newColor;
            //recur
            floodFill(image, sr - 1, sc, newColor , orgColor);
            floodFill(image, sr, sc + 1, newColor, orgColor);
            floodFill(image, sr + 1, sc, newColor, orgColor);
            floodFill(image, sr, sc - 1, newColor, orgColor);
        }
    }

    private boolean isValid(int[][] image, int i, int j, int orgColor) {
        if(i>=0 && i<image.length && j>=0 && j<image[0].length && image[i][j] == orgColor)
            return true;
        return false;
    }


}
