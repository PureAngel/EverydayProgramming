package oj052NQueensII;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Example:
 *
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */

public class NQueensII {
    public int totalNQueens(int n) {
        List<List<String>> lists = new ArrayList<>();
        char[][] board = new char[n][n];
        backtrack(lists, board, 0);
        return lists.size();
    }

    private void backtrack(List<List<String>> lists, char[][] board, int col) {
        if(col == board.length) {
            lists.add(constructList(board));
        } else {
            for(int i = 0; i < board.length; i++) {
                if(isValid(board, i, col)) {
                    board[i][col] = 'Q';
                    backtrack(lists, board, col + 1);
                    board[i][col] = '.';
                }
            }
        }
    }

    private List<String> constructList(char[][] board) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            list.add(new String(board[i]));
        }
        return list;
    }

    private boolean isValid(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < y; j++) {
                if(board[i][j] == 'Q' && (x == i || x + y == i + j || x + j == y + i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
