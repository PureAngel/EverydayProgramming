package oj698PartitionToKEqualSumSubsets;

import java.util.Arrays;

/**
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 *
 * Example 1:
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 * Note:
 *
 * 1 <= k <= len(nums) <= 16.
 * 0 < nums[i] < 10000.
 */

public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if(sum % k != 0) {
            return false;
        }
        int target = sum / k;

        Arrays.sort(nums);
        if(nums[len - 1] > target) {
            return false;
        }
        int row = len - 1;
        while(row >= 0 && nums[row] == target) {
            row--;
            k--;
        }
        return search(new int[k], target, row, nums);
    }

    private boolean search(int[] groups, int target, int row, int[] nums) {
        if(row < 0) {
            return true;
        }
        int num = nums[row--];
        for(int i = 0; i < groups.length; i++) {
            if(groups[i] + num <= target) {
                groups[i] += num;
                if(search(groups, target, row, nums)) {
                    return true;
                }
                groups[i] -= num;
            }
        }
        return false;
    }
}
