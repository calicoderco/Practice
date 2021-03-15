package com.cc.practice.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private class Node {
        Node previous = null;
        Node next = null;
        int value;
        int key;
    }

    Map<Integer, Node> map;
    Node first = null, last = null;
    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        Node node = map.get(key);

        if(node == null) {
            return -1;
        } else if(first != last && node != last) {

            //move this node to the last position
            if(node == first) {
                first = node.next;
                first.previous = null;
            } else {
                node.previous.next = node.next;
            }
            node.next.previous = node.previous;
            last.next = node;
            node.next = null;
            node.previous = last;
            last = node;
        }

        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if(node != null) {
            node.value = value;

            if (first == last) {
                last = node;
                first = node;
            }  else if(node != last){
                //insert this node into the last position
                if(node != first) {
                    node.previous.next = node.next;
                } else if(first != last) {
                    first = first.next;
                }

                if(node != last) {
                    node.next.previous = node.previous;
                    last.next = node;
                }

                node.next = null;
                node.previous = last;
                last = node;
            }
        } else {
            if(map.size() == capacity) {
                evict();
            }

            node = new Node();
            node.key = key;
            node.value = value;

            if(first == null && last == null) {
                first = node;
                last = node;
            } else {
                last.next = node;
                node.previous = last;
                last = node;
            }
        }

        map.put(key, node);
    }

    private void evict() {
        map.remove(first.key);

        if(first == last) {
            first = null;
            last = null;
        }

        if(first != null) {
            if(first.next != null) {
                first.next.previous = null;
            }
            first = first.next;
            if(first == null) {
                last = null;
            }
        }
    }
}
