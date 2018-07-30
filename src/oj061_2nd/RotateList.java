package oj061_2nd;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode slow = node;
        ListNode fast = node;
        int len = 0;

        // find the length of the list
        while(fast.next != null) {
            len++;
            fast = fast.next;
        }
        k %= len;

        for(int i = len - k; i > 0; i--) {
            slow = slow.next;
        }

        fast.next = node.next;
        node.next = slow.next;
        slow.next = null;

        return node.next;
    }
}
