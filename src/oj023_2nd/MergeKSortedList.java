package oj023_2nd;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        if(lists.length == 2) return merge(lists[0], lists[1]);

        int mid = lists.length / 2;
        ListNode[] subLists1 = new ListNode[mid];
        ListNode[] subLists2 = new ListNode[lists.length - mid];

        for(int i = 0; i < mid; i++) {
            subLists1[i] = lists[i];
        }
        for(int i = 0; i < lists.length - mid; i++) {
            subLists2[i] = lists[mid + i];
        }
        ListNode l1 = mergeKLists(subLists1);
        ListNode l2 = mergeKLists(subLists2);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val < list2.val) {
            list1.next = merge(list1.next, list2);
            return list1;
        } else {
            list2.next = merge(list1, list2.next);
            return list2;
        }
    }
}
