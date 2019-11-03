package com.cc.practice.findKthLargest;

import java.util.PriorityQueue;

class Solution {

    //solve easily with sort, but cant really been O(nlogn) even with min and max heaps so I quit on this solution below, as it's a waste of time
    public int findKthLargest(int[] nums, int k) {
        int targetLeftCount = nums.length - k, targetRightCount = k - 1, leftCount = 0, rightCount = 0, i = 1, current = nums[0], maxLeft = Integer.MIN_VALUE, minRight = Integer.MAX_VALUE;

        while(i < nums.length) {
            if(nums[i] < current) {
                if(leftCount == targetLeftCount) {
                    minRight = current;
                    if(nums[i] > maxLeft) {
                        current = nums[i];
                    } else {

                    }
                    current = nums[i];
                    rightCount++;
                } else {
                    leftCount++;
                    maxLeft = Math.max(maxLeft, nums[i]);
                }
            } else {
                if(rightCount == targetRightCount) {
                    maxLeft = current;
                    if(nums[i] < minRight) {
                        current = nums[i];
                    } else {
                        current = minRight;
                        minRight = nums[i];
                    }
                    leftCount++;
                } else {
                    rightCount++;
                    minRight = Math.min(minRight, nums[i]);
                }
            }
            i++;
        }

        return current;
    }
}
