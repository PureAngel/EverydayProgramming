package oj147InsertionSortList;

/**
 * Sort a linked list using insertion sort.
 *
 * transform the list to an array, and use insertion sort to the array.
 *
 * Created by xueyingbai on 1/26/18.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        int len = 0;
        ListNode p = head;
        while(p != null) {
            len++;
            p = p.next;
        }
        p = head;

        int[] array = new int[len];
        int index = 0;
        while(p != null) {
            array[index] = p.val;
            p = p.next;
            index++;
        }

        int temp;
        for(int i = 1; i < len; i++) {
            temp = array[i];
            int j = i - 1;
            for(; j >= 0 && array[j] > temp; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = temp;
        }

        p = head;
        index = 0;
        while(p != null) {
            p.val = array[index];
            p = p.next;
            index++;
        }

        return head;
    }
}
