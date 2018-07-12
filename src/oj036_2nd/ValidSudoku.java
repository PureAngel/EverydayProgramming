package oj036_2nd;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a Sudoku is valid
 *
 * The Sudoku board could be partially filled,
 * where empty cells are filled with the character '.'.
 *
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable.
 * Only the filled cells need to be validated.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 */

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            Set<Character> cubeSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(rowSet.contains(board[i][j])) {
                        return false;
                    }
                    rowSet.add(board[i][j]);
                }
                if(board[j][i] != '.') {
                    if(colSet.contains(board[j][i])) {
                        return false;
                    }
                    colSet.add(board[j][i]);
                }
                int cube_row = i / 3 * 3;
                int cube_col = i % 3 * 3;
                if(board[cube_row + j / 3][cube_col + j % 3] != '.') {
                    if(cubeSet.contains(board[cube_row + j / 3][cube_col + j % 3])) {
                        return false;
                    }
                    cubeSet.add(board[cube_row + j / 3][cube_col + j % 3]);
                }
            }
        }
        return true;
    }
}
