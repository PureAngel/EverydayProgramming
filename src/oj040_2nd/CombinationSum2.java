package oj040_2nd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 *
 * Each number in C may only be used once in the combination.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:
 * [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 */

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if(!lists.contains(list)) {
                lists.add(new ArrayList<>(list));
            }
        } else {
            for(int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                backtrack(lists, list, candidates, target - candidates[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
