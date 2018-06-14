package oj369PlusOneLinkedList;

import java.util.Stack;

/**
 * Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.
 *
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * Example:
 * Input:
 * 1->2->3
 *
 * Output:
 * 1->2->4
 */

public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pointer1 = node;
        ListNode pointer2 = node;
        while(pointer2.next != null) {
            pointer2 = pointer2.next;
            if(pointer2.val != 9) {
                pointer1 = pointer2;
            }
        }

        if(pointer2.val != 9) {
            pointer2.val++;
        } else {
            pointer1.val++;
            pointer1 = pointer1.next;
            while (pointer1 != null) {
                pointer1.val = 0;
                pointer1 = pointer1.next;
            }
        }

        if(node.val == 0) {
            return node.next;
        } else {
            return node;
        }
    }
}
