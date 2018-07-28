package oj821ShortestDistanceToACharacter;

/**
 * Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
 *
 * Example 1:
 *
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 *
 *
 * Note:
 *
 * S string length is in [1, 10000].
 * C is a single character, and guaranteed to be in string S.
 * All letters in S and C are lowercase.
 */

public class ShortestDistanceToACharacter {
    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];
        int prev = Integer.MIN_VALUE / 2;
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == C) {
                prev = i;
            }
            res[i] = i - prev;
        }
        prev = Integer.MAX_VALUE / 2;
        for(int i = S.length() - 1; i >= 0; i--) {
            if(S.charAt(i) == C) {
                prev = i;
            }
            res[i] = Math.min(res[i], prev - i);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        ShortestDistanceToACharacter shortestDistanceToACharacter = new ShortestDistanceToACharacter();
        int[] nums = shortestDistanceToACharacter.shortestToChar(s, c);
        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
