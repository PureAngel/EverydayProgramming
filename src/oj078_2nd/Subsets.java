package oj078_2nd;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(lists, new ArrayList<>(), nums, 0);
        return lists;
    }

    private void backtrack(List<List<Integer>> lists, List<Integer> list, int[] nums, int start) {
        lists.add(new ArrayList<>(list));
        for(int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(lists, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
