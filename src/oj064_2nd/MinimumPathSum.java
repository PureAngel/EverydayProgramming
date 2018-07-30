package oj064_2nd;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[][] sums = new int[m][n];

        sums[0][0] = grid[0][0];
        for(int i = 1; i < n; i++) {
            sums[0][i] += sums[0][i - 1] + grid[0][i];
        }
        for(int i = 1; i < m; i++) {
            sums[i][0] += sums[i - 1][0] + grid[i][0];
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                sums[i][j] = Math.min(sums[i - 1][j], sums[i][j - 1]) + grid[i][j];
            }
        }

        return sums[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        System.out.println(minimumPathSum.minPathSum(grid));
    }
}
