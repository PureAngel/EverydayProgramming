package oj462MinimumMovesToEqualArrayElementsII;

import java.util.Arrays;

/**
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
 *
 * You may assume the array's length is at most 10,000.
 *
 * Example:
 *
 * Input:
 * [1,2,3]
 *
 * Output:
 * 2
 *
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 *
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */

public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int len = nums.length;
        for(int i = len - 1; i >= 0; i--) {
            count += Math.abs(nums[len / 2] - nums[i]);
        }
        return count;
    }
}
