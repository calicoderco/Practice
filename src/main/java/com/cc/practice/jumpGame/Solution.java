package com.cc.practice.jumpGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Solution {
    //time limit exceeded
    /*
    public int jump(int[] nums) {
        int[] jumps = new int[nums.length];
        jumps[0] = 0;
        List<Integer> reachable = new ArrayList<>();
        reachable.add(0);
        for(int i = 1; i < nums.length; i++) {
            int minJumps = Integer.MAX_VALUE;
            Iterator<Integer> reachableIt = reachable.iterator();
            while(reachableIt.hasNext()) {
                Integer reachableIndex = reachableIt.next();
                if(reachableIndex + nums[reachableIndex] < i) {
                    reachableIt.remove();
                } else {
                    minJumps = Math.min(minJumps, jumps[reachableIndex] + 1);
                }
            }

            if(nums[i] > 0) {
                reachable.add(i);
            }

            jumps[i] = minJumps;
        }
        return jumps[jumps.length - 1];
    }*/

    public int jump(int[] nums) {
        int[] jumps = new int[nums.length];
        jumps[0] = 0;
        int j = 1;
        for(int i = 0; i < nums.length && j < nums.length; i++) {
            while(j <= i + nums[i] && j < nums.length) {
                jumps[j] = jumps[i] + 1;
                j++;
            }
        }
        return jumps[jumps.length - 1];
    }
}
