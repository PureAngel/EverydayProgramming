package oj647PalindromicSubstrings;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.

 The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

 Example 1:
 Input: "abc"
 Output: 3
 Explanation: Three palindromic strings: "a", "b", "c".
 Example 2:
 Input: "aaa"
 Output: 6
 Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 Note:
 The input string length won't exceed 1000.

 * Created by xueyingbai on 2/27/18.
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        boolean[][] isPalindrom = new boolean[len][len];
        int res = 0;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                isPalindrom[i][j] = isPalindrom(s, i, j);
                if(isPalindrom[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }
    private boolean isPalindrom(String s, int i, int j) {
        int len = s.length();
        if(i == j) {
            return true;
        } else if (i > j) {
            return false;
        } else {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                if(j == i + 1) {
                    return true;
                } else {
                    return isPalindrom(s, i + 1, j - 1);
                }
            }
        }
    }
    public static void main(String args[]) {
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        System.out.println(palindromicSubstrings.countSubstrings("aaa"));
    }
}
