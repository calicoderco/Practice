package com.cc.practice.networkDelayTime;

import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int networkDelayTime(int[][] inputs, int N, int K) {
        Map<Integer, List<int[]>> edgeLists = new HashMap<>(N);

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((input1, input2) -> {
            return input1[1] - input2[1];
        });

        Set<Integer> unknown = new HashSet<>();
        IntStream.range(1, N + 1).forEach((i) -> {
            unknown.add(i);
        });
        priorityQueue.add(new int[]{K, 0});

        IntStream.range(0, inputs.length).forEach((i) -> {
            int[] input = inputs[i];
            int source = input[0];
            int target = input[1];
            int time =  input[2];
            if(!edgeLists.containsKey(source)) {
                edgeLists.put(source, new LinkedList<int[]>());
            }
            List<int[]> edges = edgeLists.get(source);
            edges.add(new int[]{target, time});
        });

        int[] times = new int[N];
        Arrays.fill(times, Integer.MAX_VALUE);
        times[K - 1] = 0;

        while(!priorityQueue.isEmpty()) {
            int[] top = priorityQueue.poll();
            int nodeLabel = top[0];
            int nodeTime = top[1];

            if(unknown.contains(nodeLabel)) {
                if (edgeLists.get(nodeLabel) != null) {
                    for (int[] edge : edgeLists.get(nodeLabel)) {
                        int timeFromNodeToNeighbor = edge[1];
                        int neighborLabel = edge[0];
                        if (unknown.contains(neighborLabel)) {
                            int timeFromKToNodeToNeighbor = times[nodeLabel - 1] + timeFromNodeToNeighbor;
                            if(times[neighborLabel - 1] > timeFromKToNodeToNeighbor) {
                                times[neighborLabel - 1] = Math.min(times[neighborLabel - 1], timeFromKToNodeToNeighbor);
                                priorityQueue.add(new int[] {neighborLabel, times[neighborLabel - 1]});
                            }
                        }
                    }
                }
            }

            unknown.remove(nodeLabel);
        }

        if(unknown.size() > 0) {
            return -1;
        }

        return Arrays.stream(times).max().getAsInt();
    }
}
