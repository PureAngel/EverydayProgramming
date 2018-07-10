package oj024_2nd;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Note:
 *
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        /* recursion */
//        if(head == null || head.next == null) {
//            return head;
//        }
//        ListNode node = head.next;
//        head.next = swapPairs(node.next);
//        node.next = head;
//        return node;

        /* iteration */
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode cur = node;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next = second.next;
            cur.next = second;
            cur.next.next = first;
            cur = cur.next.next;
        }
        return node.next;
    }
}
