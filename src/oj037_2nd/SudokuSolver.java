package oj037_2nd;

/**
 * VWrite a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 *
 * Note:
 *
 * The given board contain only digits 1-9 and the character '.'.
 * You may assume that the given Sudoku puzzle will have a single unique solution.
 * The given board size is always 9x9.
 */

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) return;
        solve(board);
    }

    private boolean solve(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    for(char c = '1'; c <= '9'; c++) {
                        if(isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if(solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int x, int y, char c) {
        for (int i = 0; i < 9; i++) {
            if(board[x][i] != '.' && board[x][i] == c) {
                return false;
            }
            if(board[i][y] != '.' && board[i][y] == c) {
                return false;
            }
            if(board[i / 3 + x / 3 * 3][i % 3 + y / 3 * 3] != '.' && board[i / 3 + x / 3 * 3][i % 3 + y / 3 * 3] == c) {
                return false;
            }
        }
        return true;
    }
}
