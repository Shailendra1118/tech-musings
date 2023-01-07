package com.sports.rafael.array;

import java.util.HashSet;
import java.util.Set;

public class SudokuUtils {
    private int[][] box = new int[3][3];
    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
                            ,{'6','.','.','1','9','5','.','.','.'}
                            ,{'.','9','8','.','.','.','.','6','.'}
                            ,{'8','.','.','.','6','.','.','.','3'}
                            ,{'4','.','.','8','.','3','.','.','1'}
                            ,{'7','.','.','.','2','.','.','.','6'}
                            ,{'.','6','.','.','.','.','2','8','.'}
                            ,{'.','.','.','4','1','9','.','.','5'}
                            ,{'.','.','.','.','8','.','.','7','9'}};
        SudokuUtils util = new SudokuUtils();
        System.out.println("Is it Valid: "+util.isValidSudoku(board));
    }

    private boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] != '.') {
                    if(!isValidOverall(board, i, j))
                        return false;
                }
            }
        }
        return true;
    }

    private boolean isValidOverall(char[][] board, int r, int c) {
        return isRowValid(board, r, c) && isColValid(board, r, c)
                && isBoxValid(board, r, c);
    }

    private boolean isRowValid(char[][] board, int r, int c) {
        Set<Character> set = new HashSet<>();
        for(int i=0; i<9; i++) {
            if(board[r][i] != '.') {
                if(set.contains(board[r][i]))
                    return false;
                else
                    set.add(board[r][i]);
            }
        }
        return true;
    }

    private boolean isColValid(char[][] board, int r, int c) {
        Set<Character> set = new HashSet<>();
        for(int i=0; i<9; i++) {
            if(board[i][c] != '.') {
                if(set.contains(board[i][c]))
                    return false;
                else
                    set.add(board[i][c]);
            }
        }
        return true;
    }

    private boolean isBoxValid(char[][] board, int r, int c) {
        Set<Character> set= new HashSet<>();
        int br = r/3;
        int bc = c/3;
        if(box[br][bc] == 1) {
            return true;
        }else {
            //check this box for validity
            int ibr = br*3;
            int jbc = bc*3;
            for(int i=ibr; i<ibr+3; i++) {
                for(int j=jbc; j<jbc+3; j++) {
                    if(board[i][j] != '.') {
                        if(set.contains(board[i][j])) {
                            return false;
                        }else
                            set.add(board[i][j]);
                    }
                }
            }
            //mark the box to be valid, so it can be checked later
            box[br][bc] = 1;
            return true;
        }
    }
}
