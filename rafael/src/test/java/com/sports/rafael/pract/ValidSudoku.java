package com.sports.rafael.pract;

import org.junit.jupiter.api.Test;

public class ValidSudoku {

    @Test
    void checkIfValid() {
        String[][] board = {{".",".",".",".","5",".",".","1","."},
                            {".","4",".","3",".",".",".",".","."},
                            {".",".",".",".",".","3",".",".","1"},
                            {"8",".",".",".",".",".",".","2","."},
                            {".",".","2",".","7",".",".",".","."},
                            {".","1","5",".",".",".",".",".","."},
                            {".",".",".",".",".","2",".",".","."},
                            {".","2",".","9",".",".",".",".","."},
                            {".",".","4",".",".",".",".",".","."}
        };

        String[][] board1 = {{".",".","4",".",".",".","6","3","."},
                             {".",".",".",".",".",".",".",".","."},
                             {"5",".",".",".",".",".",".","9","."},
                             {".",".",".","5","6",".",".",".","."},
                             {"4",".","3",".",".",".",".",".","1"},
                             {".",".",".","7",".",".",".",".","."},
                             {".",".",".","5",".",".",".",".","."},
                             {".",".",".",".",".",".",".",".","."},
                             {".",".",".",".",".",".",".",".","."}};

        System.out.println(isValidSudoku(board1));
    }

    public boolean isValidSudoku(String[][] board) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] != ".") {
                    if ((checkRow(i,j,board) && checkCol(i,j,board) && checkBox(i,j,board)) == false) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkRow(int i, int j, String[][]board) {
        String cur = board[i][j];
        for(int c=0; c<9; c++) {
            if(c != j && board[i][c] == cur) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(int i, int j, String[][]board) {
        String cur = board[i][j];
        for(int r=0; r<9; r++) {
            if(r != i && board[r][j] == cur) {
                return false;
            }
        }
        return true;
    }

    private boolean checkBox(int i, int j, String[][]board) {
        int row = (i/3)*3;
        int col = (j/3)*3;
        //int rowEnd = row+3;
        //int colEnd = col+3;
        String cur = board[i][j];
        for(int r=row; r<row+3; r++) {
            for(int c=col; c<col+3; c++) {
                if(cur == board[r][c] && i != r && j != c) {
                    return false;
                }
            }
        }
        return true;
    }
}
