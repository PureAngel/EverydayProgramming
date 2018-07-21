package oj053_2nd;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        int max = sums[0];
        for(int i = 1; i < sums.length; i++) {
            sums[i] = Math.max(nums[i] + sums[i - 1], nums[i]);
            max = Math.max(max, sums[i]);
        }
        return max;
    }
}
