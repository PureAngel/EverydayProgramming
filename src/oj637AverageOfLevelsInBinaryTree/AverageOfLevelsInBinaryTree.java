package oj637AverageOfLevelsInBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * Note:
 * The range of node's value is in the range of 32-bit signed integer.
 */

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            long sum = 0;
            int count = 0;
            Queue<TreeNode> temp_queue = new LinkedList<>();
            while(!queue.isEmpty()) {
                TreeNode node = queue.remove();
                sum += node.val;
                count++;
                if(node.left != null) {
                    temp_queue.add(node.left);
                }
                if(node.right != null) {
                    temp_queue.add(node.right);
                }
            }
            queue = temp_queue;
            list.add(1.0 * sum / count);
        }
        return list;
    }
}
