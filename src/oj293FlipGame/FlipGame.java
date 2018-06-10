package oj293FlipGame;

import java.util.ArrayList;
import java.util.List;

/**
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
 *
 * Write a function to compute all possible states of the string after one valid move.
 *
 * Example:
 *
 * Input: s = "++++"
 * Output:
 * [
 *   "--++",
 *   "+--+",
 *   "++--"
 * ]
 */

public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList<>();
        if(s == null || s.length() < 2 || s.length() == 2 && (s.charAt(0) == '-' || s.charAt(1) == '-')) {
            return list;
        }
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == '-' || s.charAt(i + 1) == '-') {
                continue;
            }
            if(i < s.length() - 2) {
                list.add(s.substring(0, i) + "--" + s.substring(i + 2));
            } else {
                list.add(s.substring(0, i) + "--");
            }
        }
        return list;
    }
}
