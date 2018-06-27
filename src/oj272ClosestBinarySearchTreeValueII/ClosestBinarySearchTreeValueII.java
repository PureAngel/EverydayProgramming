package oj272ClosestBinarySearchTreeValueII;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 *
 * Note:
 *
 * Given target value is a floating point.
 * You may assume k is always valid, that is: k ≤ total nodes.
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 * Example:
 *
 * Input: root = [4,2,5,1,3], target = 3.714286, and k = 2
 *
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 *
 * Output: [4,3]
 * Follow up:
 * Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 */

public class ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> predecessors = new Stack<>();
        Stack<Integer> successors = new Stack<>();

        inorder(root, target, false, predecessors);
        inorder(root, target, true, successors);

        while (k-- > 0) {
            if(predecessors.isEmpty()) {
                list.add(successors.pop());
            } else if (successors.isEmpty()) {
                list.add(predecessors.pop());
            } else if (Math.abs(predecessors.peek() - target) > Math.abs(successors.peek() - target)) {
                list.add(successors.pop());
            } else {
                list.add(predecessors.pop());
            }
        }

        return list;
    }

    private void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> stack) {
        if(root == null) {
            return;
        }
        if(reverse) {
            inorder(root.right, target, reverse, stack);
            if(target >= root.val) {
                return;
            }
            stack.push(root.val);
            inorder(root.left, target, reverse, stack);
        } else {
            inorder(root.left, target, reverse, stack);
            if(target < root.val) {
                return;
            }
            stack.push(root.val);
            inorder(root.right, target, reverse, stack);
        }
    }
}
