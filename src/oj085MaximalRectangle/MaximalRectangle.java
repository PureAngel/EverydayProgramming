package oj085MaximalRectangle;

import java.util.Arrays;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * Output: 6
 */

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length, col = matrix[0].length;
        int area = 0;
        int[] left = new int[col];
        int[] right = new int[col];
        int[] height = new int[col];
        Arrays.fill(right, col);
        for(int i = 0; i < row; i++) {
            int cur_left = 0, cur_right = col;
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], cur_left);
                } else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            for(int j = col - 1; j >= 0; j--) {
                if(matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], cur_right);
                } else {
                    right[j] = col;
                    cur_right = j;
                }
            }
            for(int j = 0; j < col; j++) {
                area = Math.max(area, (right[j] - left[j]) * height[j]);
            }
        }
        return area;
    }
}
