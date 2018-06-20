package oj697DegreeOfAnArray;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 *
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 *
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 */

public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        int max_num = 0;
        int res = 1;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> index_map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
                index_map.put(nums[i], i);
                max_num = Math.max(max_num, 1);
            } else {
                int num = map.get(nums[i]);
                map.put(nums[i], num + 1);
                if(max_num < num + 1) {
                    max_num = num + 1;
                    res = i - index_map.get(nums[i]) + 1;
                } else if(max_num == num + 1) {
                    if(res > i - index_map.get(nums[i]) + 1) {
                        max_num = num + 1;
                        res = i - index_map.get(nums[i]) + 1;
                    }
                }
            }
        }
        return res;
    }
}
