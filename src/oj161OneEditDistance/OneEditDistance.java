package oj161OneEditDistance;

/**
 * Given two strings s and t, determine if they are both one edit distance apart.
 *
 * Note:
 *
 * There are 3 possiblities to satisify one edit distance apart:
 *
 * Insert a character into s to get t
 * Delete a character from s to get t
 * Replace a character of s to get t
 * Example 1:
 *
 * Input: s = "ab", t = "acb"
 * Output: true
 * Explanation: We can insert 'c' into s to get t.
 * Example 2:
 *
 * Input: s = "cab", t = "ad"
 * Output: false
 * Explanation: We cannot get t from s by only one step.
 * Example 3:
 *
 * Input: s = "1203", t = "1213"
 * Output: true
 * Explanation: We can replace '0' with '1' to get t.
 */

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        int len_s = s.length();
        int len_t = t.length();
        if (Math.abs(len_s - len_t) > 1) {
            return false;
        }
        int differ = 0;
        if (len_s == len_t) {
            for (int i = 0; i < len_s; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    differ++;
                    if (differ > 1) {
                        return false;
                    }
                }
            }
        } else if (len_s > len_t) {
            if(len_t == 0) {
                differ = 1;
            }
            for (int i = 0, j = 0; j < len_t;) {
                if (s.charAt(i) != t.charAt(j)) {
                    i++;
                    differ++;
                    if (i - j > 1) {
                        return false;
                    }
                } else {
                    i++;
                    j++;
                    if(j == len_t) {
                        return true;
                    }
                }
            }
        } else {
            if(len_s == 0) {
                differ = 1;
            }
            for (int i = 0, j = 0; i < len_s;) {
                if (s.charAt(i) != t.charAt(j)) {
                    j++;
                    differ++;
                    if (j - i > 1) {
                        return false;
                    }
                } else {
                    i++;
                    j++;
                    if(i == len_s) {
                        return true;
                    }
                }
            }
        }
        if(differ != 1) {
            return false;
        }
        return true;
    }
}
