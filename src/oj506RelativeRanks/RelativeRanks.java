package oj506RelativeRanks;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 *
 * Example 1:
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 * Example 2:
 * Input: [10, 3, 8, 9, 4]
 * Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
 * Note:
 * N is a positive integer and won't exceed 10,000.
 * All the scores of athletes are guaranteed to be unique.
 */

public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        String[] rank = new String[nums.length];
        Integer[] index = new Integer[nums.length];

        for(int i = 0; i < index.length; i++) {
            index[i] = i;
        }

        Arrays.sort(index, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums[o2] - nums[o1];
            }
        });

        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                rank[index[i]] = "Gold Medal";
            } else if(i == 1) {
                rank[index[i]] = "Silver Medal";
            } else if(i == 2) {
                rank[index[i]] = "Bronze Medal";
            } else {
                rank[index[i]] = "" + (i + 1);
            }
        }

        return rank;
    }

    public static void main(String[] args) {
        int[] nums = {10, 3, 8, 9, 4}; // index = {0, 1, 2, 3, 4}, sorted index = {0, 4, 2, 1, 3}, rank = {gold, 5, bronze, silver, 4}
        RelativeRanks relativeRanks = new RelativeRanks();
        String[] rank = relativeRanks.findRelativeRanks(nums);
        for(int i = 0; i < rank.length; i++) {
            System.out.println(rank[i]);
        }
    }
}
