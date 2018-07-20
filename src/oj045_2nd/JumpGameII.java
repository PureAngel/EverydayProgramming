package oj045_2nd;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 *
 * You can assume that you can always reach the last index.
 */

public class JumpGameII {
    public int jump(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }
        int jump_min = 1;
        int cur_max_index = nums[0];
        int pre_max_index = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(cur_max_index < i) {
                jump_min++;
                cur_max_index = pre_max_index;
            }
            if(pre_max_index < nums[i] + i) {
                pre_max_index = nums[i] + i;
            }
        }
        return jump_min;
    }
}
