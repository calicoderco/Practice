package com.cc.practice.removeNthNodeFromEnd;

import java.util.Stack;

public class Solution {



    /*public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int total = 1;
        while(current.next != null) {
            current = current.next;
            total++;
        }



        ListNode beforeIndex = head;
        int index = total - n + 1;
        for(int i = 1; i <= index - 2; i++) {
            beforeIndex = beforeIndex.next;
        }

        beforeIndex.next = beforeIndex.next.next;

        return head;
    }*/


    /*public ListNode removeNthFromEnd(ListNode head, int n) {
        removeNth(head, n, true);
        return head;
    }

    public int removeNth(ListNode head, int n, boolean isHead) {
        if(head == null) {
            return 0;
        } else {
            int i = removeNth(head.next, n, false);
            if(i == n) {
                head.next = head.next == null ? null : head.next.next;
            }
            return i + 1;
        }
    }*/

    /*public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<ListNode>();
        for(ListNode current = head; current != null; stack.push(current), current = current.next);

        int i = 0;
        if(stack.size() == n) {
            head = head.next;
        } else {
            while(!stack.empty()) {
                ListNode node = stack.pop();
                i++;

                if(i == n + 1) {
                    node.next = node.next == null ? null : node.next.next;

                    break;
                }
            }
        }

        return head;
    }*/

    //100% memory and speed!!! 0ms run time!!!
    int i = 0;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        return removeNth(head, n);
    }

    public ListNode removeNth(ListNode head, int n) {
        if(head == null) {
            return null;
        } else {
            ListNode next = removeNth(head.next, n);

            i++;

            if(n == i) {
                return head.next;
            } else {
                head.next = next;
                return head;
            }
        }
    }
}
