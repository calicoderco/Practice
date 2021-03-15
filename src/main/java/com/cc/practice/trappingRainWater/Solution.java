package com.cc.practice.trappingRainWater;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    private class HeightAndIndex {
        public int index;
        public int height;
    }

    /*public int trap(int[] height) {
        int answer = 0;

        HeightAndIndex[] heightAndIndexes = new HeightAndIndex[height.length];

        for(int i = 0; i < height.length; i++) {
            HeightAndIndex hAndI = new HeightAndIndex();
            hAndI.height = height[i];
            hAndI.index = i;
            heightAndIndexes[i] = hAndI;
        }

        Arrays.sort(heightAndIndexes, (HeightAndIndex o1, HeightAndIndex o2) -> {
                return o2.height - o1.height;
            }
        );

        int maxLeft = 0, maxRightIndex = 0;
        for(int i = 0; i < height.length; i++) {

            while(maxRightIndex < heightAndIndexes.length && heightAndIndexes[maxRightIndex].index <= i) {
                maxRightIndex++;
            }

            if(i > 0 && i < height.length - 1) {
                int maxRight = heightAndIndexes[maxRightIndex].height;
                int heightDifference = Math.min(maxLeft, maxRight) - height[i];
                answer += heightDifference > 0 ? heightDifference : 0;
            }

            maxLeft = Math.max(maxLeft, height[i]);
        }

        return answer;
    }*/

    //better than 98% and 100% memory, wohoo!
    public int trap(int[] height) {
        int answer = 0;

        if(height.length > 2) {
            int[] maxLeft = new int[height.length],
                    maxRight = new int[height.length];
            maxLeft[0] = 0;
            maxRight[maxRight.length - 1] = 0;

            for (int left = 1; left < height.length; left++) {
                int right = height.length - 1 - left;
                maxLeft[left] = Math.max(maxLeft[left - 1], height[left - 1]);
                maxRight[right] = Math.max(maxRight[right + 1], height[right + 1]);
            }

            for(int i = 0; i < height.length; i++) {
                int difference = Math.min(maxLeft[i], maxRight[i]) - height[i];
                answer += difference > 0 ? difference : 0;
            }
        }

        return answer;
    }
}
