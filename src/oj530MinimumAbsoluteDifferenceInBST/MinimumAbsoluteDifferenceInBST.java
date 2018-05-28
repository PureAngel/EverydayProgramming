package oj530MinimumAbsoluteDifferenceInBST;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * Output:
 * 1
 *
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 * Note: There are at least two nodes in this BST.
 */

public class MinimumAbsoluteDifferenceInBST {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list = getSortedList(root);
        int differ = Math.abs(list.get(1) - list.get(0));
        for(int i = 2; i < list.size(); i++) {
            if(differ > Math.abs(list.get(i) - list.get(i - 1))) {
                differ = Math.abs(list.get(i) - list.get(i - 1));
            }
        }
        return differ;
    }

    private List<Integer> getSortedList(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        if(root.left != null) {
            leftList = getSortedList(root.left);
        }
        if(root.right != null) {
            rightList = getSortedList(root.right);
        }
        list.addAll(leftList);
        list.add(root.val);
        list.addAll(rightList);
        return list;
    }
}
