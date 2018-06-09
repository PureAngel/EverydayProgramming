package oj416PartitionEqualSubsetSum;

/**
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * Example 1:
 *
 * Input: [1, 5, 11, 5]
 *
 * Output: true
 *
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: [1, 2, 3, 5]
 *
 * Output: false
 *
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */

// 0/1 knapsack problem: d[i][j] means sum j can be achieved with the first i numbers
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if(sum % 2 == 1) {
            return false;
        }
        sum /= 2;

        boolean[][] dp = new boolean[len + 1][sum + 1];
        for(int i = 0; i <= len; i++) {
            for(int j = 0; j <= sum; j++) {
                dp[i][j] = false;
            }
        }
        dp[0][0] = true;
        for(int i = 1; i <= len; i++) {
            dp[i][0] = true;
        }
        for(int i = 1; i <= len; i++) {
            for(int j = 1; j <= sum; j++) {
                if(dp[i - 1][j]) {
                    dp[i][j] = true;
                } else if(j >= nums[i - 1]){
                    dp[i][j] = dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[len][sum];
    }
}
