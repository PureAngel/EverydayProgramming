package oj538ConvertBSTToGreaterTree;

import java.util.Stack;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 *
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 */

public class ConvertBSTToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || node != null) {
            while(node != null) {
                stack.add(node);
                node = node.right;
            }
            node = stack.pop();
            sum += node.val;
            node.val = sum;

            node = node.left;
        }

        return root;
    }
}
