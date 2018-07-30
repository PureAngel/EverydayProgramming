package oj062_2nd;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Example 1:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 *
 * Input: m = 7, n = 3
 * Output: 28
 */

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            res[i][1] = 1;
        }
        for(int i = 1; i <= n; i++) {
            res[1][i] = 1;
        }
        for(int i = 2; i <= m; i++) {
            for(int j = 2; j <= n; j++) {
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[m][n];
    }
}
