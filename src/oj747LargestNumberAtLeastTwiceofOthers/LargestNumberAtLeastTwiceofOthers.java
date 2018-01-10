package oj747LargestNumberAtLeastTwiceofOthers;

/**
 * In a given integer array nums, there is always exactly one largest element.

 Find whether the largest element in the array is at least twice as much as every other number in the array.

 If it is, return the index of the largest element, otherwise return -1.

 Example 1:
 Input: nums = [3, 6, 1, 0]
 Output: 1
 Explanation: 6 is the largest integer, and for every other number in the array x,
 6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
 Example 2:
 Input: nums = [1, 2, 3, 4]
 Output: -1
 Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
 Note:
 nums will have a length in the range [1, 50].
 Every nums[i] will be an integer in the range [0, 99].

 * Created by xueyingbai on 18/1/10.
 */
public class LargestNumberAtLeastTwiceofOthers {
    public int dominantIndex(int[] nums) {
        int result = -1;
        int len = nums.length;
        if(len == 1) return 0;
        int max;
        int second;
        if(nums[0] > nums[1]) {
            max = nums[0];
            second = nums[1];
            result = 0;
        } else {
            max = nums[1];
            second = nums[0];
            result = 1;
        }
        int i = 2;
        for(; i < len; i++) {
            if(nums[i] > max) {
                second = max;
                max = nums[i];
                result = i;
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        if(max >= 2 * second) {
            return result;
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1};
        LargestNumberAtLeastTwiceofOthers a = new LargestNumberAtLeastTwiceofOthers();
        System.out.println(a.dominantIndex(nums));
    }
}
