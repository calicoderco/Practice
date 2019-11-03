package com.cc.practice.findSequence;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {

    class BetterLinkedList<E> {
        Node<E> first = null;
        Node<E> last = null;
        int size = 0;

        public void add(E element) {
            Node<E> node = new Node<E>();
            node.value = element;

            if(first == null && last == null) {
                first = node;
                last = node;
            } else {
                last.next = node;
                last = node;
            }
            size++;
        }

        public void mergeToEnd(BetterLinkedList<E> secondList) {
            if(first == null && last == null) {
                first = secondList.first;
                last = secondList.last;
            } else {
                last.next = secondList.first;
                last = secondList.last;
            }

            size += secondList.size;
        }

        class Node<E> {
            E value = null;
            Node<E> next = null;
        }

        public int size() {
            return size;
        }
    }


    public int findSequence(int[] nums) {
        Map<Integer, BetterLinkedList<Integer>> map = new HashMap<>();

        int longest = 0;
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if(!map.containsKey(num)) {
                int above = num + 1;
                int below = num - 1;

                BetterLinkedList<Integer> aboveList = map.get(above),
                        belowList = map.get(below);

                if (map.containsKey(above) && map.containsKey(below)) {
                    aboveList.mergeToEnd(belowList);
                    map.put(num, aboveList);
                    map.put(below, aboveList);
                } else if(map.containsKey(above)) {
                    aboveList.add(num);
                    map.put(num, aboveList);
                } else if(map.containsKey(below)) {
                    belowList.add(num);
                } else {
                    BetterLinkedList<Integer> list = new BetterLinkedList<>();
                    list.add(num);
                    map.put(num, list);
                }

                BetterLinkedList<Integer> list = map.get(num);
                longest = Math.max(longest, list.size());
            }
        }

        return longest;
    }
}
