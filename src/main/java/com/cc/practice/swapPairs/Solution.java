package com.cc.practice.swapPairs;


class Solution {
    public ListNode swapPairs(ListNode head) {
       return swapPairs(head, 0);
    }

    public ListNode swapPairs(ListNode head, int i) {
        if(null == head) {
            return null;
        }

        ListNode next = swapPairs(head.next, i + 1);
        ListNode newHead = head;

        if(i % 2 == 0 && head.next != null) {
            ListNode temp = head.next;
            head.next = head.next.next;
            temp.next = head;
            newHead = temp;
        } else {
            newHead.next = next;
        }


        return newHead;
    }
}
