package oj041_2nd;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 * Note:
 *
 * Your algorithm should run in O(n) time and uses constant extra space.
 */

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int i = 0, n = nums.length;
        if(n == 0) {
            return 1;
        }
        while (i < n) {
            if(nums[i] > 0 && nums[i] < n && nums[nums[i]] != nums[i]) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }
        int j = 1;
        for(; j < n; j++) {
            if(nums[j] != j) {
                return j;
            }
        }
        if(nums[0] == j) {
            return j + 1;
        } else {
            return j;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(nums));
    }
}
