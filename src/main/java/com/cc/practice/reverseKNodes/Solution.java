package com.cc.practice.reverseKNodes;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 1;

        ListNode currentHead = head; // the head of the group I'm currently reversing
        ListNode current = head; // the element in the group I'm currently reversing by swapping with he currentHed
        ListNode currentPrev = null; // the element immediately before the current element if it exists
        ListNode currentHeadPrev = null; // the node immediately before currentHead, if such a node exists
        ListNode absoluteHead = head; // the head of the final, reversed list I'm returning

        int totalNodes = 0;
        for(ListNode counter = head; counter != null; counter = counter.next) {
            totalNodes++;
        }
        int nodesToVisit = ((totalNodes / k) * k);

        int nodesVisited = 0;

        //push the current node onto the head of the current group so that it is now the head and list is still linked
        while(current != null && nodesVisited <= nodesToVisit) {
            if(current != currentHead) {
                currentPrev.next = current.next;
                current.next = currentHead;

                if(currentHead == absoluteHead) {
                    absoluteHead = current;
                }

                ListNode currentNow = current;
                current = currentPrev;
                currentHead = currentNow;

                if(currentHeadPrev != null) {
                    currentHeadPrev.next = currentNow;
                }
            }


            if(k == count) {
                count = 1;
                currentHeadPrev = current;
                currentHead = current.next;
            } else {
                count++;
            }

            currentPrev = current;
            current = current.next;
            nodesVisited++;
        }

        return absoluteHead;
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

    public boolean equals(ListNode node, int[] arr) {
        int i = 0;
        while(node != null && i < arr.length) {
            if(node.val != arr[i]) {
                return false;
            }
            node = node.next;
            i++;
        }
        return true;
    }

    public boolean equals(ListNode a, ListNode b) {
        while(a != null && b != null) {
            if(a.val != b.val) {
                return false;
            }
            a = a.next;
            b = b.next;
        }

        return a == null && b == null;
    }

}
