package com.cc.practice.mergeKSortedLists;

import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;

        PriorityQueue<ListNode> q = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });

        ListNode answerHead = null;
        ListNode answerTail = null;

        for(ListNode head : lists) {
            if(head != null) {
                q.add(head);
            }
        }

        while(q.size() > 0) {
            ListNode minHead = q.poll();
            if(minHead.next != null) {
                q.add(minHead.next);
            }

            if(answerHead == null) {
                answerHead = minHead;
            }

            if(answerTail == null) {
                answerTail = minHead;
            } else {
                answerTail.next = minHead;
                answerTail = minHead;
            }

            minHead.next = null;
        }

        return answerHead;
    }

    public ListNode buildList(int[] input) {
        if(input.length == 0 ) return null;

        ListNode head = new ListNode(input[0]);
        ListNode current = head;
        for(int i = 1; i < input.length; i++) {
            ListNode next = new ListNode(input[i]);
            current.next = next;
            current = next;
        }

        return head;
    }
}
