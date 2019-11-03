package com.cc.practice.mergeTwoSortedLists;

import org.junit.Test;

public class MergeTwoListsTest {


    @Test
    public void test() {
        ListNode l1 = build(new int[]{1,2,3});
        ListNode l2 = build(new int[]{1,2,4});
        Solution solution = new Solution();
        solution.mergeTwoLists(l1, l2);
    }

    public ListNode build(int[] input) {
        if(input.length == 0 ) return null;

        ListNode head = new ListNode(input[0]);
        ListNode current = head;
        for(int i = 1; i < input.length; i++) {
            current.next = new ListNode(input[i]);
            current = current.next;
        }
        return head;
    }

    public void print(ListNode head) {
        while(head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }

    public boolean equals(ListNode a, ListNode b) {
        if(a == b) return true;
        if(a == null) return false;
        if(b == null) return false;

        while(a.next != null && b.next != null && a.val == b.val) {
            a = a.next;
            b = b.next;
        }

        return a.next == null && b.next == null && a.val == b.val;
    }
}
