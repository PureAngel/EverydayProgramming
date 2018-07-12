package oj034_2nd;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */

public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int[] res = new int[]{-1, -1};
        if(nums.length == 0) {
            return res;
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if(nums[low] != target) {
            return res;
        } else {
            res[0] = low;
        }

        high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        res[1] = high;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        SearchForARange searchForARange = new SearchForARange();
        int[] res = searchForARange.searchRange(nums, 6);
        for(int i = 0; i < 2; i++) {
            System.out.println(res[i]);
        }
    }
}
