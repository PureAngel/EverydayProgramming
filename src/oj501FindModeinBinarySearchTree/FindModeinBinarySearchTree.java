package oj501FindModeinBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 Both the left and right subtrees must also be binary search trees.
 For example:
 Given BST [1,null,2,2],
   1
    \
     2
    /
   2
 return [2].

 Note: If a tree has more than one mode, you can return them in any order.

 Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

 * Created by xueyingbai on 1/23/18.
 */
public class FindModeinBinarySearchTree {
    int count = 1;
    TreeNode prev = null;
    int max = 0;
    public int[] findMode(TreeNode root) {
        if(root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<Integer>();
        traverse(root, list);
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }

        // left
        traverse(root.left, list);

        // node
        if(prev != null) {
            if(root.val == prev.val) {
                count++;
            } else {
                count = 1;
            }
        }
        if(count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root;

        // right
        traverse(root.right, list);
    }
}
