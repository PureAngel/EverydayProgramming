package oj035_2nd;

import oj034_2nd.SearchForARange;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 */

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0 || nums[0] > target) {
            return 0;
        }
        if(nums[nums.length - 1] < target) {
            return nums.length;
        }
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        System.out.println(searchInsertPosition.searchInsert(nums, 5));
    }
}
