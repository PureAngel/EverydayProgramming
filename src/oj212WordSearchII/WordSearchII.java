package oj212WordSearchII;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 * Example:
 *
 * Input:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 *
 * Output: ["eat","oath"]
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> resultList = new ArrayList<>();
        for(String word: words) {
            if(hasWord(board, word) && !resultList.contains(word)) {
                resultList.add(word);
            }
        }
        return resultList;
    }

    private boolean hasWord(char[][] board, String word) {
        int r = 0, c = 0;
        int row = board.length, col = board[0].length;
        char[][] myboard = new char[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                myboard[i][j] = board[i][j];
            }
        }
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == word.charAt(0)) {
                    r = i;
                    c = j;
                    if(myHasWord(board, r, c, word, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean myHasWord(char[][] board, int r, int c, String word, int start) {
        int wordLen = word.length();
        char ch = board[r][c];
        board[r][c] = ' ';
        if(start >= wordLen) {
            board[r][c] = ch;
            return true;
        }
        if(r > 0 && board[r - 1][c] == word.charAt(start) && myHasWord(board, r - 1, c, word, start + 1)) {
            board[r][c] = ch;
            return true;
        }
        if(r < board.length - 1 && board[r + 1][c] == word.charAt(start) && myHasWord(board, r + 1, c, word, start + 1)) {
            board[r][c] = ch;
            return true;
        }
        if(c > 0 && board[r][c - 1] == word.charAt(start) && myHasWord(board, r, c - 1, word, start + 1)) {
            board[r][c] = ch;
            return true;
        }
        if(c < board[0].length - 1 && board[r][c + 1] == word.charAt(start) && myHasWord(board, r, c + 1, word, start + 1)) {
            board[r][c] = ch;
            return true;
        }
        board[r][c] = ch;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'a','b'},{'a','a'}};
        String[] words = {"aba","baa","bab","aaab","aaa","aaaa","aaba"};
        WordSearchII wordSearchII = new WordSearchII();
        List<String> list = wordSearchII.findWords(board, words);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
