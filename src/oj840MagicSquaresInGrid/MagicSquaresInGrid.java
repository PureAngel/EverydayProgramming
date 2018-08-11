package oj840MagicSquaresInGrid;

/**
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
 *
 * Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).
 *
 *
 *
 * Example 1:
 *
 * Input: [[4,3,8,4],
 *         [9,5,1,9],
 *         [2,7,6,2]]
 * Output: 1
 * Explanation:
 * The following subgrid is a 3 x 3 magic square:
 * 438
 * 951
 * 276
 *
 * while this one is not:
 * 384
 * 519
 * 762
 *
 * In total, there is only one magic square inside the given grid.
 * Note:
 *
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 */

public class MagicSquaresInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        if(grid.length < 3 || grid[0].length < 3) {
            return 0;
        }
        int count = 0;
        for(int i = 0; i < grid.length - 2; i++) {
            for(int j = 0; j < grid[0].length - 2; j++) {
                if(isValid(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isValid(int[][] grid, int row, int col) {
        int[] nums = new int[10];
        for(int i = 1; i <= 9; i++) {
            nums[i] = 1;
        }
        for(int i = row; i <= row + 2; i++) {
            for(int j = col; j <= col + 2; j++) {
                if(grid[i][j] > 9 || grid[i][j] < 1) {
                    return false;
                }
                nums[grid[i][j]]--;
            }
        }
        for(int i = 1; i <= 9; i++) {
            if(nums[i] != 0) {
                return false;
            }
        }
        int sum = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        for(int i = row + 1; i <= row + 2; i++) {
            if(grid[i][col] + grid[i][col + 1] + grid[i][col + 2] != sum) {
                return false;
            }
        }
        for(int i = col; i <= col + 2; i++) {
            if(grid[row][i] + grid[row + 1][i] + grid[row + 2][i] != sum) {
                return false;
            }
        }
        if(grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] != sum || grid[row + 2][col] + grid[row + 1][col + 1] + grid[row][col + 2] != sum) {
            return false;
        }
        return true;
    }
}
