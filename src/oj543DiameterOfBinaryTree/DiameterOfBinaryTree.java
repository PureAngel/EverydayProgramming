package oj543DiameterOfBinaryTree;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */

public class DiameterOfBinaryTree {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 1;
        findDepth(root);
        return max  - 1;
    }

    private int findDepth(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left_depth = findDepth(node.left);
        int right_depth = findDepth(node.right);
        max = Math.max(max, left_depth + right_depth + 1);
        return Math.max(left_depth, right_depth) + 1;
    }
}
