package oj039_2nd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if(candidates == null || candidates.length == 0) {
            return lists;
        }
        Arrays.sort(candidates);

        if(candidates[0] > target) {
            return lists;
        }
        backtrack(lists, new ArrayList<>(), candidates, target, 0);

        return lists;
    }

    private void backtrack(List<List<Integer>> lists, List<Integer> list, int[] candidates, int target, int start) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            lists.add(new ArrayList<>(list));
        } else {
            for(int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                backtrack(lists, list, candidates, target - candidates[i], i);
                list.remove(list.size() - 1);
            }
        }
    }
}
