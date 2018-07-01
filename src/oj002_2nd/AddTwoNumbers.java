package oj002_2nd;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        int val = (l1.val + l2.val) % 10;
        int carry = (l1.val + l2.val) / 10;
        ListNode head = new ListNode(val);
        ListNode node = head;

        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null && l2 != null) {
            val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            node.next = new ListNode(val);
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            val = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            node.next = new ListNode(val);
            node = node.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            val = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            node.next = new ListNode(val);
            node = node.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            node.next = new ListNode(carry);
        }

        return head;
    }
}
