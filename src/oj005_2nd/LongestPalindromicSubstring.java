package oj005_2nd;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String res = "";
        int currentLen = 0;
        for(int i = 0; i < s.length(); i++) {
            if(isPalindrom(s, i - 1 - currentLen, i)) {
                res = s.substring(i - 1 - currentLen, i + 1);
                currentLen += 2;
            } else if(isPalindrom(s, i - currentLen, i)) {
                res = s.substring(i - currentLen, i + 1);
                currentLen += 1;
            }
        }
        return res;
    }

    private boolean isPalindrom(String s, int i, int j) {
        if(i == j) {
            return true;
        }
        if(i > j || i < 0) {
            return false;
        }
        if(s.charAt(i) == s.charAt(j) && j == i + 1) {
            return true;
        }
        return s.charAt(i) == s.charAt(j) && isPalindrom(s, i + 1, j - 1);
    }
}
