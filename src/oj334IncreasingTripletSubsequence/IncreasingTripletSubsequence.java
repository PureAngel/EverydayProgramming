package oj334IncreasingTripletSubsequence;

/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 *
 * Formally the function should:
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 *
 * Examples:
 * Given [1, 2, 3, 4, 5],
 * return true.
 *
 * Given [5, 4, 3, 2, 1],
 * return false.
 */

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int min_num1 = nums[0];
        int min_num2 = 0;
        boolean has_num2 = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min_num1) {
                if (has_num2 && nums[i] > min_num2) {
                    return true;
                } else {
                    min_num2 = nums[i];
                    has_num2 = true;
                }
            } else {
                min_num1 = nums[i];
            }
        }
        return false;
    }
}
