package oj657JudgeRouteCircle;

/**
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
 *
 * The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
 *
 * Example 1:
 * Input: "UD"
 * Output: true
 * Example 2:
 * Input: "LL"
 * Output: false
 */

public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        int up_down = 0;
        int left_right = 0;
        if(moves.length() % 2 == 1) {
            return false;
        }
        for(int i = 0; i < moves.length(); i++) {
            if(moves.charAt(i) == 'U') {
                up_down++;
            } else if(moves.charAt(i) == 'D') {
                up_down--;
            } else if(moves.charAt(i) == 'L') {
                left_right++;
            } else {
                left_right--;
            }
        }
        return up_down == 0 && left_right == 0;
    }
}
