package oj148SortList;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Created by xueyingbai on 1/26/18.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode l0 = new ListNode(0);
        ListNode p = l0;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            } else {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        while(l1 != null) {
            p.next = l1;
            p = p.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            p.next = l2;
            p = p.next;
            l2 = l2.next;
        }
        return  l0.next;
    }
}
