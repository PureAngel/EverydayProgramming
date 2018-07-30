package oj059_2nd;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, down = n - 1;
        int count = 1;
        while(left <= right) {
            for(int i = left; i <= right; i++) {
                matrix[top][i] = count++;
            }
            top++;
            for(int i = top; i <= down; i++) {
                matrix[i][right] = count++;
            }
            right--;
            for(int i = right; i >= left; i--) {
                matrix[down][i] = count++;
            }
            down--;
            for(int i = down; i >= top; i--) {
                matrix[i][left] = count++;
            }
            left++;
        }
        return matrix;
    }
}
