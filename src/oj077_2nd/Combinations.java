package oj077_2nd;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(lists, new ArrayList<>(), n, k, 1);
        return lists;
    }

    private void backtrack(List<List<Integer>> lists, List<Integer> list, int n, int k, int start) {
        if(k == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i <= n; i++) {
            list.add(i);
            backtrack(lists, list, n, k - 1, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
