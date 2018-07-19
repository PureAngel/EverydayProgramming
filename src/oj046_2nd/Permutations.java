package oj046_2nd;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(lists, new ArrayList<>(), nums);
        return lists;
    }

    private void backtrack(List<List<Integer>> lists, List<Integer> list, int[] nums) {
        if(list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(list.contains(nums[i])) {
                    continue;
                } else {
                    list.add(nums[i]);
                    backtrack(lists, list, nums);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
