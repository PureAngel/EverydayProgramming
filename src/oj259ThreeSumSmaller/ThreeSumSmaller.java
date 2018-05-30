package oj259ThreeSumSmaller;

import java.util.Arrays;

/**
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 *
 * Example:
 *
 * Input: nums = [-2,0,1,3], and target = 2
 * Output: 2
 * Explanation: Because there are two triplets which sums are less than 2:
 *              [-2,0,1]
 *              [-2,0,3]
 * Follow up: Could you solve it in O(n2) runtime?
 */

public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int index_num = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            index_num += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return index_num;
    }

    private int twoSumSmaller(int[] nums, int start, int target) {
        int left = start;
        int right = nums.length - 1;
        int num = 0;
        while(left < right) {
            if(nums[left] + nums[right] < target) {
                num += right - left;
                left++;
            } else {
                right--;
            }
        }
        return num;
    }
}
