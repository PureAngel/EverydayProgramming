package oj337HouseRobberIII;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 * Example 1:
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 */

public class HouseRobberIII {
    public int rob(TreeNode root) {
        int sum = 0;
        if(root == null) {
            return sum;
        }
        if(root.left == null && root.right == null) {
            sum += root.val;
            return sum;
        }
//        int left_sum = rob(root.left);
//        int right_sum = rob(root.right);
        sum += root.val;
        if(root.left == null) {
            sum += rob(root.right.left) + rob(root.right.right);
            sum = Math.max(sum, rob(root.right));
        } else if(root.right == null) {
            sum += rob(root.left.left) + rob(root.left.right);
            sum = Math.max(sum, rob(root.left));
        } else {
            sum += rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right);
            sum = Math.max(sum, rob(root.left) + rob(root.right));
        }
        return sum;
    }
}
