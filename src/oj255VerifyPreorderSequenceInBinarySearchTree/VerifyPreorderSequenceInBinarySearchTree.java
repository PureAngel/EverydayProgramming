package oj255VerifyPreorderSequenceInBinarySearchTree;

import java.util.Stack;

/**
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

 You may assume each number in the sequence is unique.

 Follow up:
 Could you do it using only constant space complexity?

 * Created by xueyingbai on 1/26/18.
 */
public class VerifyPreorderSequenceInBinarySearchTree {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<Integer>();
        int low = Integer.MIN_VALUE;

        for(int num: preorder) {
            if(num < low) {
                return false;
            }
            while(!stack.isEmpty() && stack.peek() < num) {
                low = stack.pop();
            }
            stack.push(num);
        }
        return true;
    }
}
