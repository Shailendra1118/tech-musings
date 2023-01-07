package com.sports.rafael.array;

public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{-8,-7,-5,-3,-3,-1,1},
                        {2,2,2,3,3,5,7},
                        {8,9,11,11,13,15,17},
                        {18,18,18,20,20,20,21},
                        {23,24,26,26,26,27,27},
                        {28,29,29,30,32,32,34}};
        int target = -5;

        boolean found = searchMatrix(matrix, target);
        System.out.println("Found: "+found);
    }

    private static boolean searchMatrix(int[][] matrix, int target) {

        int r = matrix.length;
        int c = matrix[0].length;

        for(int i=0; i<r; i++) {
            if(matrix[i][0] > target) {
                return false;
            }else if(matrix[i][0] == target || matrix[i][c-1] == target) {
                return true;
            }else {
                boolean found = binarySearch(matrix, i, 0,c-1, target);
                if(found)
                    return true;
            }
        }
        return false;
    }

    private static boolean binarySearch(int[][] matrix, int rowNum, int lo, int hi, int target) {
        if(lo > hi) {
            return false;
        }
        int mid = (hi-lo)/2 + lo;
        if(matrix[rowNum][mid] == target) {
            return true;
        }else if(matrix[rowNum][mid] > target) {
            return binarySearch(matrix, rowNum, lo, mid-1, target);
        }else {
            return binarySearch(matrix, rowNum, mid+1, hi, target);
        }
    }
}
