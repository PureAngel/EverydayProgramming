package oj054_2nd;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int row = matrix.length, col = matrix[0].length;
        int top = 0, down = row - 1;
        int left = 0, right = col - 1;
        while(left <= right && top <= down) {
            for(int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            for(int i = top + 1; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            if(left < right && top < down) {
                for(int i = right - 1; i >= left; i--) {
                    list.add(matrix[down][i]);
                }
                for(int i = down - 1; i > top; i--) {
                    list.add(matrix[i][left]);
                }
            }
            top++;
            down--;
            left++;
            right--;
        }
        return list;
    }
}
