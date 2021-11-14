package com.wym.suixianglu.huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N 皇后
 *
 * https://leetcode-cn.com/problems/n-queens/
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 *
 */
public class _13NQueens {


    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        nQueens(n, board, 0);
        return result;
    }

    List<List<String>> result = new ArrayList<>();

    private void nQueens(int n, char[][] board, int row) {
        if (row == n) {
            result.add(buildResult(board));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(row, i, n, board)) {
                board[row][i] = 'Q';
                nQueens(n, board, row + 1);
                board[row][i] = '.';
            }
        }
    }

    private boolean check(int row, int col, int n, char[][] board) {

        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private List<String> buildResult(char[][] board) {

        List<String> list = new ArrayList<>();

        for (char[] chars : board) {
            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                sb.append(c);
            }
            list.add(sb.toString());
        }
        return list;
    }
//    public List<List<String>> solveNQueens(int n) {
//        solveNQueens(n, 0);
//        return result;
//    }
//
//    List<List<String>> result = new ArrayList<>();
//    List<Integer> list = new ArrayList<>();
//
//    private void solveNQueens(int n, int index) {
//        if (index == n) {
//            List<String> temp = new ArrayList<>();
//            for (Integer i : list) {
//                StringBuilder sb = new StringBuilder();
//                for (int j = 0; j < i; j++) {
//                    sb.append(".");
//                }
//                sb.append("Q");
//                for (int j = i + 1; j < n; j++) {
//                    sb.append(".");
//                }
//                temp.add(sb.toString());
//            }
//            result.add(temp);
//            return;
//        }
//        for (int i = 0; i < n; i++) {
//            list.add(i);
//            if (check(list, index)) {
//                solveNQueens(n, index + 1);
//            }
//            list.remove(list.size() - 1);
//        }
//    }
//
//    private boolean check(List<Integer> list, int index) {
//
//        Integer val = list.get(index);
//        for (int i = 0; i < list.size() - 1; i++) {
//            if (list.get(i).equals(val) || Math.abs(list.get(i) - val) == index - i) {
//                return false;
//            }
//        }
//
//        return true;
//    }
}
