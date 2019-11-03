package com.cc.practice.cloneGraph;


import java.util.*;

class Solution {
    public Node cloneGraph(Node node) {
        Map<Integer, Node> clones = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        List<Node> toVisit = new LinkedList<>();

        toVisit.add(node);

        while(!toVisit.isEmpty()) {
            Node next = toVisit.remove(0);
            if(!visited.contains(next)) {
                Node nextClone;
                if(!clones.containsKey(next.val)) {
                    nextClone = new Node();
                    nextClone.neighbors = new LinkedList<>();
                    nextClone.val = next.val;
                    clones.put(next.val, nextClone);
                } else {
                    nextClone = clones.get(next.val);
                }

                for(Node neighbor : next.neighbors) {
                    if(!visited.contains(neighbor)) {
                        toVisit.add(neighbor);
                    }

                    Node neighborClone;
                    if(!clones.containsKey(neighbor.val)) {
                        neighborClone =  new Node();
                        neighborClone.neighbors = new LinkedList<>();
                        neighborClone.val = neighbor.val;
                        clones.put(neighbor.val, neighborClone);
                    } else {
                        neighborClone = clones.get(neighbor.val);
                    }

                    nextClone.neighbors.add(neighborClone);
                }

                visited.add(next);
            }
        }

        return clones.get(node.val);
    }
}
