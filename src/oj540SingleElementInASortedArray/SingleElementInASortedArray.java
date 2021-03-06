package oj540SingleElementInASortedArray;

/**
 * Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.
 *
 * Example 1:
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 */

public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if((mid < 0 || nums[mid - 1] != nums[mid]) && (mid + 1 > nums.length - 1 || nums[mid + 1] != nums[mid])) {
                return nums[mid];
            }
            if(mid + 1 < nums.length - 1 && nums[mid + 1] == nums[mid] && mid % 2 == 0
                    || mid - 1 >= 0 && nums[mid - 1] == nums[mid] && mid % 2 == 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return nums[start];
    }
}
