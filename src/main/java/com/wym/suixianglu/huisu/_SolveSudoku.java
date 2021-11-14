package com.wym.suixianglu.huisu;

/**
 * 解树独
 * https://leetcode-cn.com/problems/sudoku-solver/
 */
public class _SolveSudoku {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board){

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) {
                    if (valid(board, i, j, k)) {
                        board[i][j] = k;
                        if (solve(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean valid(char[][] board, int row, int col, char val) {

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val) {
                return false;
            }
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
