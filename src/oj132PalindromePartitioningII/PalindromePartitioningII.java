package oj132PalindromePartitioningII;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */

// cut[i] is the minimum of cut[j - 1] + 1 (j <= i), if [j, i] is palindrome.
// If [j, i] is palindrome, [j + 1, i - 1] is palindrome, and c[j] == c[i].
public class PalindromePartitioningII {
    public int minCut(String s) {
        int n = s.length();
        int[] cut = new int[n];
        boolean[][] isPalindrome = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j <= i; j++) {
                if(s.charAt(j) == s.charAt(i) && (j + 1 > i - 1 || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true;
                    if(j > 0) {
                        min = Math.min(min, cut[j - 1] + 1);
                    } else {
                        min = 0;
                    }
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }
}
