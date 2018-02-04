package oj230KthSmallestElementinaBST;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

 Follow up:
 What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 How would you optimize the kthSmallest routine?

 * Created by xueyingbai on 2/3/18.
 */
public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        int leftCount = nodeCount(root.left);
        if(leftCount >= k) {
            return kthSmallest(root.left, k);
        } else if(leftCount == k - 1) {
            return root.val;
        } else {
            return kthSmallest(root.right, k - leftCount - 1);
        }
    }

    private int nodeCount(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return nodeCount(root.left) + nodeCount(root.right) + 1;
    }
}
