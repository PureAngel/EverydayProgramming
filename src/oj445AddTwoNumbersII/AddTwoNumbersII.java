package oj445AddTwoNumbersII;

import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * Example:
 *
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode node = new ListNode(0);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if(!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if(!stack2.isEmpty()) {
                sum += stack2.pop();
            }
            node.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = node;
            node = head;
            sum /= 10;
        }
        if (node.val == 0) {
            return node.next;
        } else {
            return node;
        }
    }
}
