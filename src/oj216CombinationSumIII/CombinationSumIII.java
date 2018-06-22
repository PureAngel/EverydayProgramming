package oj216CombinationSumIII;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        combination(lists, new ArrayList<>(), k, 1, n);
        return lists;
    }

    private void combination(List<List<Integer>> lists, List<Integer> list, int k, int start, int n) {
        if(list.size() == k && n == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i <= 9; i++) {
            list.add(i);
            combination(lists, list, k, i + 1, n - i);
            list.remove(list.size() - 1);
        }
    }
}
