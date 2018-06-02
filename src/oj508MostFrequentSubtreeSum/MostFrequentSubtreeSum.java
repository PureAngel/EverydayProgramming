package oj508MostFrequentSubtreeSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 *
 * Examples 1
 * Input:
 *
 *   5
 *  /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 *
 *   5
 *  /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */

public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        findSum(root, map);
        int max = Integer.MIN_VALUE;
        for(Integer freq: map.values()) {
            if(max < freq) {
                max = freq;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(Integer sum: map.keySet()) {
            if(map.get(sum) == max) {
                list.add(sum);
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private int findSum(TreeNode root, Map<Integer, Integer> map) {
        if(root == null) {
            return 0;
        }
        int key = root.val + findSum(root.left, map) + findSum(root.right, map);
        if(!map.containsKey(key)) {
            map.put(key, 1);
        } else {
            map.put(key, map.get(key) + 1);
        }
        return key;
    }
}
