package com.cc.practice.removeNthNodeFromEnd;

import org.junit.Assert;
import org.junit.Test;

public class RemoveNthNodeFromEndTest {

    @Test
    public void test() {

        //test(new int[] {1,2,3,4,5,6}, 2, new int[]{1,2,3,4,6});
        //test(new int[] {1}, 1, new int[]{});
        test(new int[] {1,2}, 1, new int[]{1});
    }

    public void test(int[] inputArr, int n, int[] outputArr) {


        Solution solution = new Solution();
        ListNode input = build(inputArr);
        ListNode answer = solution.removeNthFromEnd(input, n);
        ListNode expected = build(outputArr);

        print(answer);
        print(expected);

        Assert.assertTrue(equals(expected, answer));
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
