package oj525ContiguousArray;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000.
 */

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, max_len = 0;
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                count--;
            } else {
                count++;
            }
            if(!map.containsKey(count)) {
                map.put(count, i);
            } else {
                max_len = Math.max(max_len, i - map.get(count));
            }
        }
        return max_len;
    }
}
