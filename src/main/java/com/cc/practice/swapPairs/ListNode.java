package com.cc.practice.swapPairs;
public class ListNode {
   public int val;
   public ListNode next;
   public ListNode(int x) { val = x; }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder("[");
      builder.append(val);
      ListNode node = this.next;
      while(node != null) {
         builder.append("," + node.val);
         node = node.next;
      }
      builder.append("]");
      return builder.toString();
   }
}
