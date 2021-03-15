package com.cc.practice.dataStructures;

import java.util.*;

public abstract class SegmentTree<Interval extends Comparable<Interval>, Data extends Comparable<Data>, Statistic extends Comparable<Statistic>> {
    List<Data> data = new ArrayList<>();
    Node root = null;

    public SegmentTree(List<Data> data) {
        this.data.addAll(data);
        buildTree();
    }

    private void buildTree() {
        //sort the data based on its natural ordering and build the first level of the tree above these leaves
        Collections.sort(this.data);
        List<Node> level = new ArrayList<>();
        for(int i = 0; i < data.size(); i += 2) {
            Node node = new Node();
            node.leftInterval = indexToInterval(i);
            node.rightInterval = indexToInterval(i + 1);
            node.value = computeStatistic(data.get(i), i + 1 < data.size() ? data.get(i + 1) : null);
            level.add(node);
        }

        //build the levels of the tree from the bottom up
        while(level.size() != 1) {
            List<Node> nextHighestLevel = new ArrayList<>();

            for(int i = 0; i < data.size(); i += 2) {
                Node node = new Node();
                node.left = level.get(i);
                node.right = i + 1 < level.size() ? level.get(i + 1) : null;
                node.leftInterval = level.get(i).leftInterval;
                node.rightInterval = i + 1 < level.size() ? level.get(i + 1).rightInterval : null;
                node.value = computeStatistic(level.get(i), i + 1 < level.size() ? level.get(i + 1) : null);
                nextHighestLevel.add(node);
            }

            level = nextHighestLevel;
        }

        //the root is the single node of the last level that was built
        root = level.get(0);
    }

    private class Node {
        Node left = null, right = null;
        Interval leftInterval, rightInterval;
        Statistic value;
    }

    protected abstract Statistic computeStatistic(Object left, Object right); //compute the stat based on left and right stat trees
    protected abstract Interval indexToInterval(int index); //convert an index in the data list to a interval boundary
}
