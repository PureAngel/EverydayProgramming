package oj333LargestBSTSubtree;

/**
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
 *
 * Note:
 * A subtree must include all of its descendants.
 * Here's an example:
 *     10
 *     / \
 *    5  15
 *   / \   \
 *  1   8   7
 * The Largest BST Subtree in this case is the highlighted one.
 * The return value is the subtree's size, which is 3.
 * Follow up:
 * Can you figure out ways to solve it with O(n) time complexity?
 */

public class LargestBSTSubtree {
    public int largestBSTSubtree(TreeNode root) {
        int[] max = new int[1];
        helper(root, max);
        return max[0];
    }

    private Integer[] helper(TreeNode root, int[] max) {
        if(root == null) {
            return new Integer[]{null, null, 0, 1};
        }
        Integer[] left = helper(root.left, max);
        Integer[] right = helper(root.right, max);
        if((right[0] == null || root.val < right[0]) && (left[1] == null || left[1] < root.val) && left[3] == 1 && right[3] == 1) {
            max[0] = Math.max(max[0], left[2] + right[2] + 1);
            return new Integer[] {left[0]== null ? root.val : left[0], right[1] == null ? root.val : right[1], left[2] + right[2] + 1, 1};
        }
        return new Integer[] {null, null, 0, 0};
    }
}
