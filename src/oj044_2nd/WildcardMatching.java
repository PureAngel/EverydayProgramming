package oj044_2nd;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 *
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * Example 4:
 *
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * Example 5:
 *
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 */

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int len_s = s.length();
        int len_p = p.length();
        boolean[][] isMatch = new boolean[len_s + 1][len_p + 1];

        isMatch[len_s][len_p] = true;
        for(int i = len_p - 1; i >= 0; i--) {
            if(p.charAt(i) != '*') {
                break;
            }
            isMatch[len_s][i] = true;
        }

        for(int i = len_s - 1; i >= 0; i--) {
            for(int j = len_p - 1; j >= 0; j--) {
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    isMatch[i][j] = isMatch[i + 1][j + 1];
                } else if(p.charAt(j) == '*') {
                    isMatch[i][j] = isMatch[i + 1][j] || isMatch[i][j + 1];
                } else {
                    isMatch[i][j] = false;
                }
            }
        }
        return isMatch[0][0];
    }
}
