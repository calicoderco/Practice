package com.cc.practice.longestConsecutive;

import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> groupMappings = new HashMap<>();
        Map<Integer, Integer> mins = new HashMap<>(),
                maxes = new HashMap<>();
        int nextGroup = 0;
        int largest = 0;
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(!groupMappings.containsKey(num)) {
                Integer aboveGroup = groupMappings.get(num + 1);
                Integer belowGroup = groupMappings.get(num - 1);
                Set<Integer> aboveSequence = map.getOrDefault(aboveGroup, Collections.emptySet());
                Set<Integer> belowSequence = map.getOrDefault(belowGroup, Collections.emptySet());

                if(aboveSequence.size() == 0 && belowSequence.size() == 0) {
                    Set<Integer> sequence = new HashSet<>();
                    sequence.add(num);
                    map.put(nextGroup, sequence);
                    mins.put(nextGroup, num);
                    maxes.put(nextGroup, num);
                    groupMappings.put(num, nextGroup);
                    nextGroup++;
                } else if(aboveSequence.size() > belowSequence.size()) {
                    aboveSequence.addAll(belowSequence);
                    for(Integer numberBelow : belowSequence) {
                        groupMappings.put(numberBelow, aboveGroup);
                    }
                    aboveSequence.add(num);
                    groupMappings.put(num, aboveGroup);
                    mins.put(aboveGroup, belowGroup != null ? mins.get(belowGroup) : num);
                    mins.remove(belowGroup);
                    maxes.remove(belowGroup);
                    map.remove(belowGroup);
                } else {
                    belowSequence.addAll(aboveSequence);
                    for(Integer numberAbove : aboveSequence) {
                        groupMappings.put(numberAbove, belowGroup);
                    }
                    belowSequence.add(num);
                    groupMappings.put(num, belowGroup);
                    maxes.put(belowGroup, aboveGroup != null ? maxes.get(aboveGroup) : num);
                    mins.remove(aboveGroup);
                    maxes.remove(aboveGroup);
                    map.remove(aboveGroup);
                }

                int group = groupMappings.get(num);
                int min = mins.get(group);
                int max = maxes.get(group);
                largest = Math.max(largest, max - min + 1);
            }
        }
        return largest;
    }
}
