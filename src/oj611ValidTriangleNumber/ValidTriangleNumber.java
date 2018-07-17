package oj611ValidTriangleNumber;

import java.util.Arrays;

/**
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
 * Example 1:
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * Note:
 * The length of the given array won't exceed 1000.
 * The integers in the given array are in the range of [0, 1000].
 */

public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for(int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                k = binarySearchMin(nums, k, nums.length - 1, nums[i] + nums[j]);
                count += k - j - 1;
            }
        }
        return count;
    }

    private int binarySearchMin(int[] nums, int left, int right, int sum) {
        while (left <= right && right < nums.length) {
            int mid = left + (right - left) / 2;
            if(nums[mid] >= sum) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
