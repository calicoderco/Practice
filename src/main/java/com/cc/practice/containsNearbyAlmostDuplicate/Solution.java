package com.cc.practice.containsNearbyAlmostDuplicate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeMap<Integer, Integer> yToXOrderedMap = new TreeMap<>();

        for(int j =  0; j <= Math.min(k - 1, nums.length - 1); j++) {
            Integer count = yToXOrderedMap.getOrDefault(nums[j], 0);
            yToXOrderedMap.put(nums[j], new Integer(count.intValue() + 1));
        }

        for(int i = 0; i < nums.length; i++) {
            Integer count;

            if(i < nums.length - k) {
                count = yToXOrderedMap.getOrDefault(nums[i + k], 0);
                yToXOrderedMap.put(nums[i + k], count + 1);
            }

            count = yToXOrderedMap.get(nums[i]);

            if(count.intValue() == 1) {
                yToXOrderedMap.remove(nums[i]);
            } else {
                yToXOrderedMap.put(nums[i], count - 1);
            }

            Integer highestKeyLowerThanOrEqualToKAbove = yToXOrderedMap.lowerKey(nums[i] > Integer.MAX_VALUE - t - 1 ? Integer.MAX_VALUE : nums[i] + t + 1);
            if(highestKeyLowerThanOrEqualToKAbove != null && highestKeyLowerThanOrEqualToKAbove  >= nums[i] - t ) {
                return true;
            }

            Integer lowestKeyLowerThanOrEqualtoTBelow = yToXOrderedMap.higherKey(nums[i] < Integer.MIN_VALUE + t + 1 ? Integer.MIN_VALUE : nums[i] - t - 1);
            if(lowestKeyLowerThanOrEqualtoTBelow != null && lowestKeyLowerThanOrEqualtoTBelow  <= nums[i] + t ) {
                return true;
            }
        }

        return false;
    }
}