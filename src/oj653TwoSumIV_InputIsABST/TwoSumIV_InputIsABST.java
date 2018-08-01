package oj653TwoSumIV_InputIsABST;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Example 1:
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 * Example 2:
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * Output: False
 */

public class TwoSumIV_InputIsABST {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        inorder(list, root);

        int low = 0, high = list.size() - 1;
        while(low < high) {
            int sum = list.get(low) + list.get(high);
            if(sum == k) {
                return true;
            }
            if(sum < k) {
                low++;
            } else {
                high--;
            }
        }
        return false;
    }

    private void inorder(List<Integer> list, TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }
}
