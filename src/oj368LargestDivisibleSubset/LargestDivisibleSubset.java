package oj368LargestDivisibleSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 *
 * If there are multiple solutions, return any subset is fine.
 *
 * Example 1:
 *
 * nums: [1,2,3]
 *
 * Result: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 *
 * nums: [1,2,4,8]
 *
 * Result: [1,2,4,8]
 */

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return list;
        }
        Arrays.sort(nums);

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = 1; i < nums.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max_index = 0;
        for(int i = 1; i < nums.length; i++) {
            if(dp[i] > dp[max_index]) {
                max_index = i;
            }
        }

        int temp = nums[max_index];
        int cur = dp[max_index];
        for(int i = max_index; i >= 0; i--) {
            if(temp % nums[i] == 0 && dp[i] == cur) {
                list.add(nums[i]);
                temp = nums[i];
                cur--;
            }
        }
        return list;
    }
}
