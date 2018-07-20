package oj051_2nd;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n¡Án chessboard
 * such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],
 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 */

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(lists, board, 0);

        return lists;
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
