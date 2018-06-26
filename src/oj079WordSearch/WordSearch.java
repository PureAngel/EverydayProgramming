package oj079WordSearch;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] word_array = word.toCharArray();
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                if(exist(board, row, col, word_array, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int row, int col, char[] word_array, int index) {
        if(index == word_array.length) {
            return true;
        }
        if(row < 0 || col < 0 || row == board.length || col == board[0].length) {
            return false;
        }
        if(board[row][col] != word_array[index]) {
            return false;
        }
        board[row][col] ^= 256;
        boolean exist = exist(board, row + 1, col, word_array, index + 1)
                || exist(board, row - 1, col, word_array, index + 1)
                || exist(board, row, col + 1, word_array, index + 1)
                || exist(board, row, col - 1, word_array, index + 1);
        board[row][col] ^= 256;
        return exist;
    }
}
