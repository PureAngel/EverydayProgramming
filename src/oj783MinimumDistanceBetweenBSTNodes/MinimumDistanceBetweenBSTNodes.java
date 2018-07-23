package oj783MinimumDistanceBetweenBSTNodes;

/**
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.
 *
 * Example :
 *
 * Input: root = [4,2,6,1,3,null,null]
 * Output: 1
 * Explanation:
 * Note that root is a TreeNode object, not an array.
 *
 * The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
 * Note:
 *
 * The size of the BST will be between 2 and 100.
 * The BST is always valid, each node's value is an integer, and each node's value is different.
 */

public class MinimumDistanceBetweenBSTNodes {
    int min_diff = Integer.MAX_VALUE;
    TreeNode preNode = null;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min_diff;
    }

    private void dfs(TreeNode node) {
        if(node == null) {
            return;
        }
        dfs(node.left);
        if(preNode != null) {
            min_diff = Math.min(min_diff, node.val - preNode.val);
        }
        preNode = node;
        dfs(node.right);
    }
}
