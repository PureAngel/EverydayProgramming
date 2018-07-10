package oj025_2nd;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) { // search for the (k+1)th node
            cur = cur.next;
            count++;
        }
        if(count == k) { // found the (k+1)th node
            cur = reverseKGroup(cur, k);
            while (count-- > 0) {
                ListNode next = head.next;
                head.next = cur;
                cur = head; // 向前移动一个
                head = next; // 向后移动一个
            }
            head = cur;
        }
        return head;
    }
}
