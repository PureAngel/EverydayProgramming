package oj285InorderSuccessorInBST;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *
 * Note: If the given node has no in-order successor in the tree, return null.
 *
 * Example 1:
 *
 * Input: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 *
 * Output: 2
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * Output: null
 */

public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) {
            return null;
        }
        if(root.val == p.val) {
            return leftMost(root.right);
        }
        if(root.val > p.val) {
            TreeNode node = inorderSuccessor(root.left, p);
            if(node == null) {
                return root;
            }
            return node;
        }
        return inorderSuccessor(root.right, p);
    }

    private TreeNode leftMost(TreeNode root) {
        if(root == null) {
            return null;
        }
        if(root.left == null) {
            return root;
        }
        return leftMost(root.left);
    }
}
