package mocks;

import java.util.Arrays;

public class SNow {

    public static void main(String[] args) {
        System.out.println(1/9);  // == 0
        System.out.println(1%9); // == 1

        System.out.println(0/9);  // == 0
        System.out.println(0%9); // == 0

        System.out.println(2/9);  // == 0
        System.out.println(2%9); // == 2

        System.out.println(3/9);  // == 0
        System.out.println(3%9); // == 3

        //const int a = 10;
        SNow obj = new SNow();
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}};
        obj.solveSudoku(board);

        System.out.println(Arrays.deepToString(board));

    }

    public void solveSudokuOne(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solveOne(board);
    }

    public boolean solveOne(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell

                            if(solveOne(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidOne(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        //DFS
        if(board == null || (board.length == 0))
            return;
        solve(board, 0,0);
    }

    private boolean solve(char[][] board, int row, int col) {
        for(int i=row; i< 9; i++, col = 0) {
            for(int j=col; j<9; j++) {
                if(board[i][j] != '.') {
                    //it is filled
                    continue;
                }
                //check the options to fill
                for(char num = '1'; num <= '9'; num++) {
                    if(isValid(board, i, j, num)) {
                        board[i][j] = num;
                        if(solve(board, i, j+1))
                            return true;
                        //revert
                        board[i][j] = '.';
                    }
                }
                //all options tried
                return false;
            }
        }
        //all cells are processed
        return true;
    }


    private boolean isValid(char[][] board, int row, int col, char c) {
        int blkrow = (row / 3) * 3, blkcol = (col / 3) * 3; // Block no. is i/3, first element is i/3*3
        for (int i = 0; i < 9; i++)
            if (board[i][col] == c || board[row][i] == c ||
                    board[blkrow + i / 3][blkcol + i % 3] == c)
                return false;
        return true;
    }
}
