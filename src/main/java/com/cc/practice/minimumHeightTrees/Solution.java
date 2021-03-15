package com.cc.practice.minimumHeightTrees;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    List<Integer>[] edgeLists;
    int[] maxDepths;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        edgeLists = new LinkedList[n];
        maxDepths = new int[n];
        Arrays.fill(maxDepths, 0);

        for(int i = 0; i < n; i++) {
            edgeLists[i] = new LinkedList();
            maxDepths[i] = 1;
        }

        Arrays.stream(edges).forEach((edge) -> {
            int from = edge[0], to = edge[1];
            edgeLists[from].add(to);
            edgeLists[to].add(from);
        });

        Set<Integer> considered = new HashSet<Integer>();
        Arrays.stream(edges).forEach((edge) -> {
           int from = edge[0], to = edge[1];

           int maxDepthTo = maxDepths[to];
           int maxDepthFrom = maxDepths[from];

           considered.add(from);
           considered.add(to);

           //if(maxDepths[from] + 1  > maxDepths[to]) {
               Set<Integer> covered = new HashSet<Integer>();
               addHeights(considered, covered, to, maxDepthFrom);
           //}

           //if(maxDepths[to] + 1 > maxDepths[from]) {
               //Set<Integer> covered = new HashSet<Integer>();
               addHeights(considered, covered, from, maxDepthTo );
           //}
        });

        List<int[]> indexesSortedByMaxDepths = (List<int[]>) IntStream.range(0, n).mapToObj((i) -> {
            return new int[]{i, maxDepths[i]};
        }).collect(Collectors.toList());

        Collections.sort(indexesSortedByMaxDepths, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        List<Integer> minHeightRoots = new LinkedList<>();
        int minHeight = indexesSortedByMaxDepths.get(0)[1];
        for(int i = 0; i < n && minHeight == indexesSortedByMaxDepths.get(i)[1]; i++) {
            minHeightRoots.add(indexesSortedByMaxDepths.get(i)[0]);
        };
        return minHeightRoots;
    }

    private void addHeights(Set<Integer> considered, Set<Integer> covered,int nodeToAddTo, int maxDepthFrom) {
        covered.add(nodeToAddTo);
        if(maxDepthFrom + 1 >  maxDepths[nodeToAddTo]) {
            maxDepths[nodeToAddTo] = maxDepthFrom + 1;
            for(int neighbor : edgeLists[nodeToAddTo]) {
                if(!covered.contains(neighbor) && considered.contains(neighbor)) {
                    addHeights(considered, covered, neighbor, maxDepths[nodeToAddTo]);
                }
            }
        }
    }


    /*public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] edgeLists = new LinkedList[n];
        Set<Integer> unvisitedSet = new HashSet<Integer>();
        int[] maxDepths = new int[n];

        for(int i = 0; i < n; i++) {
            edgeLists[i] = new LinkedList();
            unvisitedSet.add(i);
            maxDepths[i] = 0;
        }

        for(int i = 0; i < edges.length; i++) {
            edgeLists[edges[i][0]].add(edges[i][1]);
            edgeLists[edges[i][1]].add(edges[i][0]);
        }

        while(!unvisitedSet.isEmpty()) {
            int start = unvisitedSet.iterator().next();
            maxDepths[start] = dfs(unvisitedSet, edgeLists, maxDepths, 0, unvisitedSet.iterator().next());
        }

        List<int[]> indexesSortedByMaxDepths = (List<int[]>) IntStream.range(0, n).mapToObj((i) -> {return new int[]{i, maxDepths[i]};}).collect(Collectors.toList());
        Collections.sort(indexesSortedByMaxDepths, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        List<Integer> minHeightRoots = new LinkedList<>();
        int minHeight = indexesSortedByMaxDepths.get(0)[1];
        for(int i = 0; i < n && minHeight == indexesSortedByMaxDepths.get(i)[1]; i++) {
            minHeightRoots.add(indexesSortedByMaxDepths.get(i)[0]);
        };
        return minHeightRoots;
    }

    public int dfs(Set<Integer> unvisitedSet, List<Integer>[] edgeLists, int[] maxDepths, int depthFromStartToRoot, int root) {
        int maxDepthFromStartThroughRoot = depthFromStartToRoot;

        unvisitedSet.remove(root);

        int maxDepth = depthFromStartToRoot;
        for(Integer neighbor : edgeLists[root]) {
            if(unvisitedSet.contains(neighbor)) {
                int maxDepthFromStartThroughNeighbor = dfs(unvisitedSet, edgeLists, maxDepths, depthFromStartToRoot + 1, neighbor);
                int maxDepthFromNeighbor = maxDepthFromStartThroughNeighbor - depthFromStartToRoot;

                if(maxDepthFromNeighbor > maxDepth) {
                    maxDepth = maxDepthFromNeighbor;
                }

                if(maxDepthFromStartThroughNeighbor > maxDepthFromStartThroughRoot) {
                    maxDepthFromStartThroughRoot = maxDepthFromStartThroughNeighbor;
                }
            }
        }
        maxDepths[root] = maxDepth;


        return maxDepthFromStartThroughRoot;
    }*/
}
