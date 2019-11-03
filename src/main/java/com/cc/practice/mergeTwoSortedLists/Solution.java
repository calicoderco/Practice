package com.cc.practice.mergeTwoSortedLists;


class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode current = null;
        ListNode answer = null;

        while(!(l1 == null && l2 == null)) {
             ListNode next = null;

            if((l1 != null && l2 == null) || (l1 != null && l2 != null && l1.val <= l2.val)) {
                next = l1;
                l1 = l1.next;
            } else if((l2 != null && l1 == null) || (l1 != null && l2 != null && l2.val < l1.val)) {
                next = l2;
                l2 = l2.next;
            }
            next.next = null;

            if(current != null) {
                current.next = next;
            }

            if(answer == null) {
                answer = next;
            }

            current = next;
        }

        return answer;
    }
}
