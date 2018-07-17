package oj680ValidPalindromeII;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if(s.length() <= 2) {
            return true;
        }
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) {
                int j = s.length() - i - 1;
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        for(int k = i; k <= i + (j - i) / 2; k++) {
            if(s.charAt(k) != s.charAt(j - k + i)) {
                return false;
            }
        }
        return true;
    }
}
