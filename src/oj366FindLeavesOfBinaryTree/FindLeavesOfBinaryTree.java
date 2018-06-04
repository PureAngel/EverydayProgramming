package oj366FindLeavesOfBinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.
 *
 * Example:
 * Given binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Returns [4, 5, 3], [2], [1].
 *
 * Explanation:
 * 1. Removing the leaves [4, 5, 3] would result in this tree:
 *
 *           1
 *          /
 *         2
 * 2. Now removing the leaf [2] would result in this tree:
 *
 *           1
 * 3. Now removing the leaf [1] would result in the empty tree:
 *
 *           []
 * Returns [4, 5, 3], [2], [1].
 */

public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        findLevel(results, root);
        return results;
    }

    private int findLevel(List<List<Integer>> lists, TreeNode root) {
        if(root == null) {
            return -1;
        }
        int left_level = findLevel(lists, root.left);
        int right_level = findLevel(lists, root.right);
        int level = Math.max(left_level, right_level) + 1;
        if(lists.size() == level) {
            lists.add(new ArrayList<>());
        }
        lists.get(level).add(root.val);
        root.left = root.right = null;
        return level;
    }
}
