package oj872LeafSimilarTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 *
 *
 *
 * Note:
 *
 * Both of the given trees will have between 1 and 100 nodes.
 */

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        getLeaves(root1, list1);
        getLeaves(root2, list2);
        if(list1.size() != list2.size()) {
            return false;
        }
        for(int i = 0; i < list1.size(); i++) {
            if(list1.get(i).val != list2.get(i).val) {
                return false;
            }
        }
        return true;
    }

    private void getLeaves(TreeNode root, List<TreeNode> leaves) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            leaves.add(root);
        }
        getLeaves(root.left, leaves);
        getLeaves(root.right, leaves);
    }
}
