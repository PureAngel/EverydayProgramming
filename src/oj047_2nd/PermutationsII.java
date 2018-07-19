package oj047_2nd;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(lists, new ArrayList<>(), nums, used);
        return lists;
    }

    private void backtrack(List<List<Integer>> lists, List<Integer> list, int[] nums, boolean[] used) {
        if(list.size() == nums.length && !lists.contains(list)) {
            lists.add(new ArrayList<>(list));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(used[i]) {
                    continue;
                } else {
                    used[i] = true;
                    list.add(nums[i]);
                    backtrack(lists, list, nums, used);
                    used[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        PermutationsII permutationsII = new PermutationsII();
        List<List<Integer>> lists = permutationsII.permuteUnique(nums);
        for(int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
    }
}
